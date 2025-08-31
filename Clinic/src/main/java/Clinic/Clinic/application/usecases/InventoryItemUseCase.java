package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.InventoryItem;
import Clinic.Clinic.domain.services.InventoryItemService;

import java.util.List;

public class InventoryItemUseCase {

    private final InventoryItemService inventoryItemService;

    public InventoryItemUseCase(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    public void createItem(InventoryItem item) throws Exception {
        inventoryItemService.create(item);
    }

    public void updateItem(InventoryItem item) throws Exception {
        inventoryItemService.update(item);
    }

    public void deleteItem(InventoryItem item) throws Exception {
        inventoryItemService.delete(item);
    }

    public List<InventoryItem> findItemsByType(String type) throws Exception {
        return inventoryItemService.findByType(type);
    }
}