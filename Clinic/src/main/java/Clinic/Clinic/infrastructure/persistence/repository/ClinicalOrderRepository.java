package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.ClinicalOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClinicalOrderRepository extends JpaRepository<ClinicalOrderEntity, Long> {
    Optional<ClinicalOrderEntity> findByOrderNumber(String orderNumber);
}