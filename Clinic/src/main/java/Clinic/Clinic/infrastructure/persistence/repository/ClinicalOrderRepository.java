package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.ClinicalOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalOrderRepository extends JpaRepository<ClinicalOrderEntity, Long> {
    // Add custom query methods if needed
}