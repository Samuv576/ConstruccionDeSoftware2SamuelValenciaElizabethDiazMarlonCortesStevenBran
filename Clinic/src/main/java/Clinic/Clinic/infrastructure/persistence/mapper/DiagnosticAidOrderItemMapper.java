package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.DiagnosticAidOrderItem;
import Clinic.Clinic.infrastructure.persistence.entities.DiagnosticAidOrderItemEntity;

public class DiagnosticAidOrderItemMapper {

    public static DiagnosticAidOrderItemEntity toEntity(DiagnosticAidOrderItem diagnosticAidOrderItem) {
        if (diagnosticAidOrderItem == null) return null;
        DiagnosticAidOrderItemEntity entity = new DiagnosticAidOrderItemEntity();
        entity.setId(diagnosticAidOrderItem.getId());
        entity.setItemDetails(diagnosticAidOrderItem.getItemDetails());
        // Map other fields
        return entity;
    }

    public static DiagnosticAidOrderItem toDomain(DiagnosticAidOrderItemEntity entity) {
        if (entity == null) return null;
        DiagnosticAidOrderItem diagnosticAidOrderItem = new DiagnosticAidOrderItem();
        diagnosticAidOrderItem.setId(entity.getId());
        diagnosticAidOrderItem.setItemDetails(entity.getItemDetails());
        // Map other fields
        return diagnosticAidOrderItem;
    }
}