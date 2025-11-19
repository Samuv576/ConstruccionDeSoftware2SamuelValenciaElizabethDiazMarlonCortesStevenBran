package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.domain.ports.MedicalHistoryPort;
import Clinic.Clinic.infrastructure.persistence.entities.MedicalHistoryEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.MedicalHistoryMapper;
import Clinic.Clinic.infrastructure.persistence.repository.MedicalHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MedicalHistoryAdapter implements MedicalHistoryPort {

    private final MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistoryAdapter(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    @Override
    public MedicalHistory findByPatientDocument(String document) {
        Optional<MedicalHistoryEntity> entity = medicalHistoryRepository.findByPatientDocument(document);
        return entity.map(MedicalHistoryMapper::toDomain).orElse(null);
    }

    @Override
    public void save(MedicalHistory history) {
        MedicalHistoryEntity entity = MedicalHistoryMapper.toEntity(history);
        MedicalHistoryEntity saved = medicalHistoryRepository.save(entity);
        history.setId(saved.getId());
    }

    @Override
    public void delete(MedicalHistory history) {
        Optional<MedicalHistoryEntity> entity = medicalHistoryRepository.findByPatientDocument(history.getPatientDocument());
        entity.ifPresent(medicalHistoryRepository::delete);
    }
}
