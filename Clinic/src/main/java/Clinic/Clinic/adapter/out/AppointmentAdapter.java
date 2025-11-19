package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.Appointment;
import Clinic.Clinic.domain.ports.AppointmentPort;
import Clinic.Clinic.infrastructure.persistence.entities.AppointmentEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.AppointmentMapper;
import Clinic.Clinic.infrastructure.persistence.repository.AppointmentRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AppointmentAdapter implements AppointmentPort {

    private final AppointmentRepository appointmentRepository;

    public AppointmentAdapter(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment findById(Appointment appointment) {
        Optional<AppointmentEntity> entity = appointmentRepository.findById(appointment.getId());
        return entity.map(AppointmentMapper::toDomain).orElse(null);
    }

    @Override
    public java.util.List<Appointment> findByDoctorDocumentAndDateTimeBetween(
            String doctorDocument, 
            java.time.LocalDateTime start, 
            java.time.LocalDateTime end) {
        return appointmentRepository
            .findByDoctorDocumentAndDateTimeBetween(doctorDocument, start, end)
            .stream()
            .map(AppointmentMapper::toDomain)
            .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void save(Appointment appointment) {
        AppointmentEntity entity = AppointmentMapper.toEntity(appointment);
        AppointmentEntity saved = appointmentRepository.save(entity);
        appointment.setId(saved.getId());
    }

    @Override
    public void cancel(Appointment appointment) {
        appointmentRepository.deleteById(appointment.getId());
    }
}
