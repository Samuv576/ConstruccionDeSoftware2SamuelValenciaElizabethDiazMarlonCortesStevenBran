package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    // Add custom query methods if needed
}