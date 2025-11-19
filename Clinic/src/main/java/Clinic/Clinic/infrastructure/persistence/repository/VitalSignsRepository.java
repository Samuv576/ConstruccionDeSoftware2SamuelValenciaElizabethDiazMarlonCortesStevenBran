package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.VitalSignsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VitalSignsRepository extends JpaRepository<VitalSignsEntity, Long> {
    Optional<VitalSignsEntity> findByPatientDocument(String patientDocument);
}