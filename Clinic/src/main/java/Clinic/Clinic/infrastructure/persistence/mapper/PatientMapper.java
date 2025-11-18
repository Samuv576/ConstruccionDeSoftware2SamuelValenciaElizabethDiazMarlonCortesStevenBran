package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    public static PatientEntity toEntity(Patient patient) {
        if (patient == null) return null;
        PatientEntity entity = new PatientEntity();
        entity.setId(patient.getId());
        entity.setFullName(patient.getFullName());
        entity.setDocument(patient.getDocument());
        // Map other fields
        return entity;
    }

    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;
        Patient patient = new Patient();
        patient.setId(entity.getId());
        patient.setFullName(entity.getFullName());
        patient.setDocument(entity.getDocument());
        // Map other fields
        return patient;
    }
}