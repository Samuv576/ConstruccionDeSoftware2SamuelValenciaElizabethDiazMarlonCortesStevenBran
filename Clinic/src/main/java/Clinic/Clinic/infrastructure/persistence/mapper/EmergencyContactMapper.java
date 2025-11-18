package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.EmergencyContact;
import Clinic.Clinic.infrastructure.persistence.entities.EmergencyContactEntity;

public class EmergencyContactMapper {

    public static EmergencyContactEntity toEntity(EmergencyContact emergencyContact) {
        if (emergencyContact == null) return null;
        EmergencyContactEntity entity = new EmergencyContactEntity();
        entity.setId(emergencyContact.getId());
        entity.setName(emergencyContact.getFirstName() + " " + emergencyContact.getLastName());
        entity.setPhoneNumber(emergencyContact.getPhone());
        // Removed direct mapping for non-existent fields
        return entity;
    }

    public static EmergencyContact toDomain(EmergencyContactEntity entity) {
        if (entity == null) return null;
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setId(entity.getId());
        emergencyContact.setPhone(entity.getPhoneNumber());
        emergencyContact.setFirstName(entity.getName().split(" ")[0]);
        emergencyContact.setLastName(entity.getName().substring(entity.getName().indexOf(" ") + 1));
        // Map other fields
        return emergencyContact;
    }
}