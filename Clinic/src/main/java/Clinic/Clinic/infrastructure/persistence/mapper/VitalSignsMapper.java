package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.infrastructure.persistence.entities.VitalSignsEntity;

public class VitalSignsMapper {

    public static VitalSignsEntity toEntity(VitalSigns vitalSigns) {
        if (vitalSigns == null) return null;
        VitalSignsEntity entity = new VitalSignsEntity();
        if (vitalSigns.getId() != null && vitalSigns.getId() > 0) {
            entity.setId(vitalSigns.getId());
        }
        entity.setPatientDocument(vitalSigns.getPatientDocument());
        entity.setVitalSignsDetails(vitalSigns.getVitalSignsDetails());
        entity.setBloodPressure(vitalSigns.getBloodPressure());
        entity.setTemperature(vitalSigns.getTemperature());
        entity.setPulse(vitalSigns.getPulse());
        entity.setHeartRate(vitalSigns.getHeartRate());
        entity.setOxygenLevel(vitalSigns.getOxygenLevel());
        entity.setWeight(vitalSigns.getWeight());
        return entity;
    }

    public static VitalSigns toDomain(VitalSignsEntity entity) {
        if (entity == null) return null;
        VitalSigns vitalSigns = new VitalSigns();
        vitalSigns.setId(entity.getId());
        vitalSigns.setPatientDocument(entity.getPatientDocument());
        vitalSigns.setVitalSignsDetails(entity.getVitalSignsDetails());
        vitalSigns.setBloodPressure(entity.getBloodPressure());
        vitalSigns.setTemperature(entity.getTemperature());
        vitalSigns.setPulse(entity.getPulse());
        vitalSigns.setHeartRate(entity.getHeartRate());
        vitalSigns.setOxygenLevel(entity.getOxygenLevel());
        vitalSigns.setWeight(entity.getWeight());
        return vitalSigns;
    }
}