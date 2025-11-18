package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.InventoryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItemEntity, Long> {
    // Add custom query methods if needed
}