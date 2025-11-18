package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.infrastructure.persistence.entities.ClinicalOrderEntity;

public class ClinicalOrderMapper {

    public static ClinicalOrderEntity toEntity(ClinicalOrder clinicalOrder) {
        if (clinicalOrder == null) return null;
        ClinicalOrderEntity entity = new ClinicalOrderEntity();
        entity.setId(clinicalOrder.getId());
        entity.setOrderDetails(clinicalOrder.getOrderDetails());
        // Map other fields
        return entity;
    }

    public static ClinicalOrder toDomain(ClinicalOrderEntity entity) {
        if (entity == null) return null;
        ClinicalOrder clinicalOrder = new ClinicalOrder();
        clinicalOrder.setId(entity.getId());
        clinicalOrder.setOrderDetails(entity.getOrderDetails());
        // Map other fields
        return clinicalOrder;
    }
}