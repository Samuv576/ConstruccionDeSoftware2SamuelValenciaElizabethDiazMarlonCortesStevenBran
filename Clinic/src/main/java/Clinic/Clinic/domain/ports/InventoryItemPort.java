package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.InventoryItem;

public interface InventoryItemPort {
    InventoryItem findById(Long id) throws Exception;
    InventoryItem findByName(String name) throws Exception;
    void save(InventoryItem item) throws Exception;
    void delete(InventoryItem item) throws Exception;
}
