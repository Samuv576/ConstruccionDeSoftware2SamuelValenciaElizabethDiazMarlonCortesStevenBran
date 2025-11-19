package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.VitalSigns;
import Clinic.Clinic.domain.ports.VitalSignsPort;
import Clinic.Clinic.infrastructure.persistence.entities.VitalSignsEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.VitalSignsMapper;
import Clinic.Clinic.infrastructure.persistence.repository.VitalSignsRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VitalSignsAdapter implements VitalSignsPort {

    private final VitalSignsRepository vitalSignsRepository;
    private String tempDocumentHolder;

    public VitalSignsAdapter(VitalSignsRepository vitalSignsRepository) {
        this.vitalSignsRepository = vitalSignsRepository;
    }

    @Override
    public VitalSigns findByPatientId(String patientDocument) {
        Optional<VitalSignsEntity> entity = vitalSignsRepository.findByPatientDocument(patientDocument);
        return entity.map(VitalSignsMapper::toDomain).orElse(null);
    }

    @Override
    public void save(VitalSigns vitalSigns) {
        VitalSignsEntity entity = VitalSignsMapper.toEntity(vitalSigns);
        if (tempDocumentHolder != null) {
            entity.setPatientDocument(tempDocumentHolder);
        }
        VitalSignsEntity saved = vitalSignsRepository.save(entity);
        vitalSigns.setId(saved.getId());
    }

    @Override
    public void delete(VitalSigns vitalSigns) {
        if (vitalSigns.getId() != null) {
            vitalSignsRepository.deleteById(vitalSigns.getId());
        }
    }

    public void setTempDocument(String document) {
        this.tempDocumentHolder = document;
    }
}
