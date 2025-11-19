package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.infrastructure.persistence.entities.SpecialistTypeEntity;

public class SpecialistTypeMapper {
    public static SpecialistTypeEntity toEntity(SpecialistType specialistType) {
        SpecialistTypeEntity entity = new SpecialistTypeEntity();
        if (specialistType.getId() != null && specialistType.getId() > 0) {
            entity.setId(specialistType.getId().longValue());
        }
        entity.setName(specialistType.getName());
        return entity;
    }

    public static SpecialistType toDomain(SpecialistTypeEntity entity) {
        SpecialistType specialistType = new SpecialistType();
        if (entity.getId() != null) {
            specialistType.setId(entity.getId().intValue());
        }
        specialistType.setName(entity.getName());
        return specialistType;
    }
}
