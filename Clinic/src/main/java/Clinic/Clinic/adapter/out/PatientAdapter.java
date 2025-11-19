package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.ports.PatientPort;
import Clinic.Clinic.infrastructure.persistence.entities.PatientEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.PatientMapper;
import Clinic.Clinic.infrastructure.persistence.repository.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PatientAdapter implements PatientPort {

    private final PatientRepository patientRepository;

    public PatientAdapter(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findByDocument(Patient patient) {
        Optional<PatientEntity> entity = patientRepository.findByDocument(patient.getDocument());
        return entity.map(PatientMapper::toDomain).orElse(null);
    }

    @Override
    public Patient findByName(Patient patient) {
        Optional<PatientEntity> entity = patientRepository.findByFullName(patient.getFullName());
        return entity.map(PatientMapper::toDomain).orElse(null);
    }

    @Override
    public void save(Patient patient) {
        PatientEntity entity = PatientMapper.toEntity(patient);
        PatientEntity saved = patientRepository.save(entity);
        patient.setId(saved.getId());
    }

    @Override
    public void delete(Patient patient) {
        Optional<PatientEntity> entity = patientRepository.findByDocument(patient.getDocument());
        entity.ifPresent(patientRepository::delete);
    }
}
