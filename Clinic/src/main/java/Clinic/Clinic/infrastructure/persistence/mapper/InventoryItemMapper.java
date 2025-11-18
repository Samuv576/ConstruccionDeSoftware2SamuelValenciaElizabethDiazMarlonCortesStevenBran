package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.InventoryItem;
import Clinic.Clinic.infrastructure.persistence.entities.InventoryItemEntity;

public class InventoryItemMapper {

    public static InventoryItemEntity toEntity(InventoryItem inventoryItem) {
        if (inventoryItem == null) return null;
        InventoryItemEntity entity = new InventoryItemEntity();
        entity.setId(inventoryItem.getId());
        entity.setItemName(inventoryItem.getItemName());
        entity.setQuantity(inventoryItem.getQuantity());
        // Map other fields
        return entity;
    }

    public static InventoryItem toDomain(InventoryItemEntity entity) {
        if (entity == null) return null;
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setId(entity.getId());
        inventoryItem.setItemName(entity.getItemName());
        inventoryItem.setQuantity(entity.getQuantity());
        // Map other fields
        return inventoryItem;
    }
}