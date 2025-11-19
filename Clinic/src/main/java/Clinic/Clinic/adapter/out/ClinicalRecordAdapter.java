package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.ClinicalRecord;
import Clinic.Clinic.domain.ports.ClinicalRecordPort;
import Clinic.Clinic.infrastructure.persistence.entities.ClinicalRecordEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.ClinicalRecordMapper;
import Clinic.Clinic.infrastructure.persistence.repository.ClinicalRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClinicalRecordAdapter implements ClinicalRecordPort {

    private final ClinicalRecordRepository clinicalRecordRepository;

    public ClinicalRecordAdapter(ClinicalRecordRepository clinicalRecordRepository) {
        this.clinicalRecordRepository = clinicalRecordRepository;
    }

    @Override
    public ClinicalRecord findByPatientId(String patientDocument) {
        Optional<ClinicalRecordEntity> entity = clinicalRecordRepository.findByRecordDetails(patientDocument);
        return entity.map(ClinicalRecordMapper::toDomain).orElse(null);
    }

    @Override
    public void save(ClinicalRecord record) {
        ClinicalRecordEntity entity = ClinicalRecordMapper.toEntity(record);
        ClinicalRecordEntity saved = clinicalRecordRepository.save(entity);
        record.setId(saved.getId());
    }

    @Override
    public void delete(ClinicalRecord record) {
        if (record.getId() != null) {
            clinicalRecordRepository.deleteById(record.getId());
        }
    }
}
