package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.InventoryItem;
import Clinic.Clinic.domain.ports.InventoryItemPort;

import java.util.ArrayList;
import java.util.List;

public class InventoryItemService {

    private final InventoryItemPort inventoryItemPort;

    public InventoryItemService(InventoryItemPort inventoryItemPort) {
        this.inventoryItemPort = inventoryItemPort;
    }


    public void create(InventoryItem item) throws Exception {
        if (item.getId() == null || item.getId().isEmpty()) {
            throw new Exception("El ID del ítem es obligatorio");
        }

        if (item.getName() == null || item.getName().isEmpty()) {
            throw new Exception("El nombre del ítem es obligatorio");
        }

        if (item.getType() == null || item.getType().isEmpty()) {
            throw new Exception("El tipo del ítem es obligatorio");
        }

        InventoryItem existing = inventoryItemPort.findById(item.getId());
        if (existing != null) {
            throw new Exception("Ya existe un ítem con ese ID");
        }

        inventoryItemPort.save(item);
    }

    public List<InventoryItem> findByType(String type) throws Exception {
        throw new UnsupportedOperationException("findByType debe ser implementado en el adaptador");
    }


    public void update(InventoryItem item) throws Exception {
        InventoryItem existing = inventoryItemPort.findById(item.getId());
        if (existing == null) {
            throw new Exception("No se encontró el ítem para actualizar");
        }

        inventoryItemPort.save(item);
    }


    public void delete(InventoryItem item) throws Exception {
        InventoryItem existing = inventoryItemPort.findById(item.getId());
        if (existing == null) {
            throw new Exception("No se encontró el ítem para eliminar");
        }

        inventoryItemPort.delete(item);
    }
}
