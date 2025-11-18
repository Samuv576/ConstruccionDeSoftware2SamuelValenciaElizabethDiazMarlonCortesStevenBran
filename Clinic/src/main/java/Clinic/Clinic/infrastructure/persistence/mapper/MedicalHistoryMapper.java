package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.infrastructure.persistence.entities.MedicalHistoryEntity;

public class MedicalHistoryMapper {

    public static MedicalHistoryEntity toEntity(MedicalHistory medicalHistory) {
        if (medicalHistory == null) return null;
        MedicalHistoryEntity entity = new MedicalHistoryEntity();
        entity.setId(medicalHistory.getId());
        entity.setPatientName(medicalHistory.getPatientDocument());
        entity.setHistoryDetails(medicalHistory.getEntries().toString());
        // Adjusted mapping to use `patientDocument` and convert `entries` to string
        // Map other fields
        return entity;
    }

    public static MedicalHistory toDomain(MedicalHistoryEntity entity) {
        if (entity == null) return null;
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setId(entity.getId());
        medicalHistory.setPatientName(entity.getPatientName());
        medicalHistory.setHistoryDetails(entity.getHistoryDetails());
        // Map other fields
        return medicalHistory;
    }
}