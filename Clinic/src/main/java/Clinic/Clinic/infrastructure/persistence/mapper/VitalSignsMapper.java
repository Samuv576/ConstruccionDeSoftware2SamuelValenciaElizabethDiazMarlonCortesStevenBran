package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.infrastructure.persistence.entities.VitalSignsEntity;

public class VitalSignsMapper {

    public static VitalSignsEntity toEntity(VitalSigns vitalSigns) {
        if (vitalSigns == null) return null;
        VitalSignsEntity entity = new VitalSignsEntity();
        entity.setId(vitalSigns.getId());
        entity.setPatientDocument(vitalSigns.getPatientDocument());
        entity.setVitalSignsDetails(vitalSigns.getVitalSignsDetails());
        // Map other fields
        return entity;
    }

    public static VitalSigns toDomain(VitalSignsEntity entity) {
        if (entity == null) return null;
        VitalSigns vitalSigns = new VitalSigns();
        vitalSigns.setId(entity.getId());
        vitalSigns.setPatientDocument(entity.getPatientDocument());
        vitalSigns.setVitalSignsDetails(entity.getVitalSignsDetails());
        // Map other fields
        return vitalSigns;
    }
}