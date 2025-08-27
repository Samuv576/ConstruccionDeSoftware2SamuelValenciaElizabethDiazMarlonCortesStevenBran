package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.InventoryItem;

public interface InventoryItemPort {
    InventoryItem findById(String id) throws Exception;
    void save(InventoryItem item) throws Exception;
    void delete(InventoryItem item) throws Exception;
}
