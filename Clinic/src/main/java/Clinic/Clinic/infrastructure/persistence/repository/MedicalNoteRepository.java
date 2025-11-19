package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.MedicalNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalNoteRepository extends JpaRepository<MedicalNoteEntity, Long> {
    // Custom query methods if needed
}
