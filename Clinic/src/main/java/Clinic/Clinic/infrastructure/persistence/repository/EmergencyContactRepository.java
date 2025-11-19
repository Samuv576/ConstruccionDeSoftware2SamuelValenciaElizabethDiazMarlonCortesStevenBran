package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.EmergencyContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContactEntity, Long> {
    Optional<EmergencyContactEntity> findByPhone(String phone);
    Optional<EmergencyContactEntity> findByPatientDocument(String patientDocument);
}