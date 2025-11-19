package Clinic.Clinic.infrastructure.persistence.repository;

import Clinic.Clinic.infrastructure.persistence.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    java.util.List<AppointmentEntity> findByDoctorDocumentAndDateTimeBetween(
        String doctorDocument, 
        java.time.LocalDateTime start, 
        java.time.LocalDateTime end
    );
}