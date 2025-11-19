package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    public static PatientEntity toEntity(Patient patient) {
        if (patient == null) return null;
        PatientEntity entity = new PatientEntity();
        // Don't set ID for new entities - let Hibernate generate it
        if (patient.getId() > 0) {
            entity.setId(patient.getId());
        }
        entity.setFullName(patient.getFullName());
        entity.setDocument(patient.getDocument());
        entity.setGender(patient.getGender() != null ? patient.getGender().name() : null);
        entity.setDateOfBirth(patient.getDateOfBirth());
        entity.setPhone(patient.getPhone());
        entity.setAddress(patient.getAddress());
        return entity;
    }

    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;
        Patient patient = new Patient();
        patient.setId(entity.getId());
        patient.setFullName(entity.getFullName());
        patient.setDocument(entity.getDocument());
        if (entity.getGender() != null) {
            patient.setGender(Clinic.Clinic.domain.model.enums.Gender.valueOf(entity.getGender()));
        }
        patient.setDateOfBirth(entity.getDateOfBirth());
        patient.setPhone(entity.getPhone());
        patient.setAddress(entity.getAddress());
        return patient;
    }
}