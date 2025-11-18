package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.DiagnosticAidOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticAidOrderItemRepository extends JpaRepository<DiagnosticAidOrderItemEntity, Long> {
    // Add custom query methods if needed
}