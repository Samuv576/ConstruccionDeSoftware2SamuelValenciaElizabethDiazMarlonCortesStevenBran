package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.infrastructure.persistence.entities.MedicalHistoryEntity;

public class MedicalHistoryMapper {

    public static MedicalHistoryEntity toEntity(MedicalHistory medicalHistory) {
        if (medicalHistory == null) return null;
        MedicalHistoryEntity entity = new MedicalHistoryEntity();
        if (medicalHistory.getId() != null && medicalHistory.getId() > 0) {
            entity.setId(medicalHistory.getId());
        }
        entity.setPatientDocument(medicalHistory.getPatientDocument());
        entity.setCreationDate(medicalHistory.getCreationDate());
        entity.setGeneralObservations(medicalHistory.getGeneralObservations());
        return entity;
    }

    public static MedicalHistory toDomain(MedicalHistoryEntity entity) {
        if (entity == null) return null;
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setId(entity.getId());
        medicalHistory.setPatientDocument(entity.getPatientDocument());
        medicalHistory.setCreationDate(entity.getCreationDate());
        medicalHistory.setGeneralObservations(entity.getGeneralObservations());
        return medicalHistory;
    }
}