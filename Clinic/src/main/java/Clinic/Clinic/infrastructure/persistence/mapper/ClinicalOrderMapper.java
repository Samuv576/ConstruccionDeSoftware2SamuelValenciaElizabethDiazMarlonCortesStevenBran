package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.infrastructure.persistence.entities.ClinicalOrderEntity;

public class ClinicalOrderMapper {

    public static ClinicalOrderEntity toEntity(ClinicalOrder clinicalOrder) {
        if (clinicalOrder == null) return null;
        ClinicalOrderEntity entity = new ClinicalOrderEntity();
        if (clinicalOrder.getId() != null && clinicalOrder.getId() > 0) {
            entity.setId(clinicalOrder.getId());
        }
        entity.setOrderDetails(clinicalOrder.getOrderDetails());
        entity.setOrderNumber(clinicalOrder.getOrderNumber());
        // Map other fields
        return entity;
    }

    public static ClinicalOrder toDomain(ClinicalOrderEntity entity) {
        if (entity == null) return null;
        ClinicalOrder clinicalOrder = new ClinicalOrder();
        clinicalOrder.setId(entity.getId());
        clinicalOrder.setOrderDetails(entity.getOrderDetails());
        clinicalOrder.setOrderNumber(entity.getOrderNumber());
        // Map other fields
        return clinicalOrder;
    }
}