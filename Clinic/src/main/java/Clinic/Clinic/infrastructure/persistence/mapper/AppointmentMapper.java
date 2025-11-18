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
        entity.setId(appointment.getId());
        entity.setPatient(toPatientEntity(appointment.getPatient()));
        entity.setDoctor(toUserEntity(appointment.getDoctor()));
        entity.setDateTime(appointment.getDateTime());
        entity.setReason(appointment.getReason());
        // Removed mapping for `details`
        return entity;
    }

    public static Appointment toDomain(AppointmentEntity entity) {
        if (entity == null) return null;
        Appointment appointment = new Appointment();
        appointment.setId(entity.getId());
        appointment.setPatient(toPatientDomain(entity.getPatient()));
        appointment.setDoctor(toUserDomain(entity.getDoctor()));
        appointment.setDateTime(entity.getDateTime());
        appointment.setReason(entity.getReason());
        // Map other fields
        return appointment;
    }
    // Métodos de conversión entre Patient y PatientEntity
    private static PatientEntity toPatientEntity(Patient patient) {
        if (patient == null) return null;
        PatientEntity entity = new PatientEntity();
        entity.setId(patient.getId());
        entity.setFullName(patient.getFullName());
        entity.setDocument(patient.getDocument());
        // Agrega otros campos si existen en PatientEntity
        return entity;
    }

    private static Patient toPatientDomain(PatientEntity entity) {
        if (entity == null) return null;
        Patient patient = new Patient();
        patient.setId(entity.getId());
        patient.setFullName(entity.getFullName());
        patient.setDocument(entity.getDocument());
        // Agrega otros campos si existen en Patient
        return patient;
    }

    // Métodos de conversión entre User y UserEntity
    private static UserEntity toUserEntity(User user) {
        if (user == null) return null;
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUserName(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setRole(user.getRole() != null ? user.getRole().name() : null);
        entity.setDateOfBirth(user.getDateOfBirth());
        return entity;
    }

    private static User toUserDomain(UserEntity entity) {
        if (entity == null) return null;
        User user = new User();
        user.setId(entity.getId());
        user.setUsername(entity.getUserName());
        user.setPassword(entity.getPassword());
        user.setEmail(entity.getEmail());
        // Si tienes un enum Role, conviértelo aquí:
        // user.setRole(Role.valueOf(entity.getRole()));
        user.setDateOfBirth(entity.getDateOfBirth());
        return user;
    }
}