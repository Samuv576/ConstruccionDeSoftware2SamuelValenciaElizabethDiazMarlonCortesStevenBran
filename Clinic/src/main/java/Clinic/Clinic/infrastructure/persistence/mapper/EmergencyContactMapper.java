package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.EmergencyContact;
import Clinic.Clinic.infrastructure.persistence.entities.EmergencyContactEntity;

public class EmergencyContactMapper {

    public static EmergencyContactEntity toEntity(EmergencyContact emergencyContact) {
        if (emergencyContact == null) return null;
        EmergencyContactEntity entity = new EmergencyContactEntity();
        if (emergencyContact.getId() != null && emergencyContact.getId() > 0) {
            entity.setId(emergencyContact.getId());
        }
        entity.setFirstName(emergencyContact.getFirstName());
        entity.setLastName(emergencyContact.getLastName());
        entity.setRelationship(emergencyContact.getRelationship());
        entity.setPhone(emergencyContact.getPhone());
        entity.setPatientDocument(emergencyContact.getPatientDocument());
        return entity;
    }

    public static EmergencyContact toDomain(EmergencyContactEntity entity) {
        if (entity == null) return null;
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setId(entity.getId());
        emergencyContact.setFirstName(entity.getFirstName());
        emergencyContact.setLastName(entity.getLastName());
        emergencyContact.setRelationship(entity.getRelationship());
        emergencyContact.setPhone(entity.getPhone());
        emergencyContact.setPatientDocument(entity.getPatientDocument());
        return emergencyContact;
    }
}