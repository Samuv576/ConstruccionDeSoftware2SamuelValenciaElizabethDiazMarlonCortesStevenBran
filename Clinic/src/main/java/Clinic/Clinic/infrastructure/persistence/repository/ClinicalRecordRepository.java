package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.ClinicalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long> {
    // Add custom query methods if needed
}