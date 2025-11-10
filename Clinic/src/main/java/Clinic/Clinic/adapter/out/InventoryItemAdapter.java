package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.InventoryItem;
import Clinic.Clinic.domain.ports.InventoryItemPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InventoryItemAdapter implements InventoryItemPort {

    // Simulación de base de datos en memoria
    private final Map<String, InventoryItem> database = new HashMap<>();

    @Override
    public InventoryItem findById(String id) {
        return database.get(id);
    }

    @Override
    public void save(InventoryItem item) {
        database.put(item.getId(), item);
    }

    @Override
    public void delete(InventoryItem item) {
        database.remove(item.getId());
    }

    // Implementación adicional para búsqueda por tipo
    public List<InventoryItem> findByType(String type) {
        return database.values().stream()
                .filter(item -> item.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
