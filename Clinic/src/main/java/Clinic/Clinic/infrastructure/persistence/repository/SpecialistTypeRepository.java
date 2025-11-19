package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.SpecialistTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistTypeRepository extends JpaRepository<SpecialistTypeEntity, Long> {
    java.util.Optional<SpecialistTypeEntity> findByName(String name);
}
