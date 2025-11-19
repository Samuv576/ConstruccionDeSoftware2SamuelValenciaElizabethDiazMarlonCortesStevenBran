package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.Appointment;
import Clinic.Clinic.infrastructure.persistence.entities.AppointmentEntity;
import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.infrastructure.persistence.entities.UserEntity;
import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.infrastructure.persistence.entities.PatientEntity;

public class AppointmentMapper {

    public static AppointmentEntity toEntity(Appointment appointment) {
        if (appointment == null) return null;
        AppointmentEntity entity = new AppointmentEntity();
        if (appointment.getId() > 0) {
            entity.setId(appointment.getId());
        }
        entity.setPatientDocument(appointment.getPatientDocument());
        entity.setDoctorDocument(appointment.getDoctorDocument());
        entity.setDateTime(appointment.getDateTime());
        entity.setReason(appointment.getReason());
        return entity;
    }

    public static Appointment toDomain(AppointmentEntity entity) {
        if (entity == null) return null;
        Appointment appointment = new Appointment();
        appointment.setId(entity.getId());
        appointment.setPatientDocument(entity.getPatientDocument());
        appointment.setDoctorDocument(entity.getDoctorDocument());
        appointment.setDateTime(entity.getDateTime());
        appointment.setReason(entity.getReason());
        return appointment;
    }
}