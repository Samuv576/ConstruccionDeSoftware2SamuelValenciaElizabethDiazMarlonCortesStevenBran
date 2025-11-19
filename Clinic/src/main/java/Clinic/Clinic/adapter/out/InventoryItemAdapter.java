package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.InventoryItem;
import Clinic.Clinic.domain.ports.InventoryItemPort;
import Clinic.Clinic.infrastructure.persistence.entities.InventoryItemEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.InventoryItemMapper;
import Clinic.Clinic.infrastructure.persistence.repository.InventoryItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InventoryItemAdapter implements InventoryItemPort {

    private final InventoryItemRepository inventoryItemRepository;

    public InventoryItemAdapter(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    public InventoryItem findById(Long id) {
        Optional<InventoryItemEntity> entity = inventoryItemRepository.findById(id);
        return entity.map(InventoryItemMapper::toDomain).orElse(null);
    }

    @Override
    public InventoryItem findByName(String name) {
        InventoryItemEntity entity = inventoryItemRepository.findByItemName(name);
        return entity != null ? InventoryItemMapper.toDomain(entity) : null;
    }

    @Override
    public void save(InventoryItem item) {
        InventoryItemEntity entity = InventoryItemMapper.toEntity(item);
        InventoryItemEntity saved = inventoryItemRepository.save(entity);
        item.setId(saved.getId());
    }

    @Override
    public void delete(InventoryItem item) {
        if (item.getId() != null) {
            inventoryItemRepository.deleteById(item.getId());
        }
    }

    public List<InventoryItem> findByType(String type) {
        return inventoryItemRepository.findByType(type).stream()
                .map(InventoryItemMapper::toDomain)
                .collect(Collectors.toList());
    }
}
