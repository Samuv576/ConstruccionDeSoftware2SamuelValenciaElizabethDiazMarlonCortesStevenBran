package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.ClinicalRecord;
import Clinic.Clinic.infrastructure.persistence.entities.ClinicalRecordEntity;

public class ClinicalRecordMapper {

    public static ClinicalRecordEntity toEntity(ClinicalRecord clinicalRecord) {
        if (clinicalRecord == null) return null;
        ClinicalRecordEntity entity = new ClinicalRecordEntity();
        if (clinicalRecord.getId() != null && clinicalRecord.getId() > 0) {
            entity.setId(clinicalRecord.getId());
        }
        entity.setRecordDetails(clinicalRecord.getRecordDetails());
        
        // Map foreign key IDs
        if (clinicalRecord.getMedicalNote() != null) {
            entity.setMedicalNoteId(clinicalRecord.getMedicalNote().getId());
        }
        if (clinicalRecord.getClinicalOrder() != null) {
            entity.setClinicalOrderId(clinicalRecord.getClinicalOrder().getId());
        }
        if (clinicalRecord.getVitalSigns() != null) {
            entity.setVitalSignsId(clinicalRecord.getVitalSigns().getId());
        }
        
        return entity;
    }

    public static ClinicalRecord toDomain(ClinicalRecordEntity entity) {
        if (entity == null) return null;
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        clinicalRecord.setId(entity.getId());
        clinicalRecord.setRecordDetails(entity.getRecordDetails());
        // Map other fields
        return clinicalRecord;
    }
}