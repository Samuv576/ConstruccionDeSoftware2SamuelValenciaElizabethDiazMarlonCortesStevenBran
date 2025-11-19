package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.infrastructure.persistence.entities.SpecialistTypeEntity;

public class SpecialistTypeMapper {
    public static SpecialistTypeEntity toEntity(SpecialistType specialistType) {
        SpecialistTypeEntity entity = new SpecialistTypeEntity();
            if (specialistType.getId() != null) {
                entity.setId(Long.parseLong(specialistType.getId()));
            }
        entity.setName(specialistType.getName());
        return entity;
    }

    public static SpecialistType toDomain(SpecialistTypeEntity entity) {
        SpecialistType specialistType = new SpecialistType();
            if (entity.getId() != null) {
                specialistType.setId(String.valueOf(entity.getId()));
            }
        specialistType.setName(entity.getName());
        return specialistType;
    }
}
