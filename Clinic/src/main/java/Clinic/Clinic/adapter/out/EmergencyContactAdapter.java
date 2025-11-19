package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.EmergencyContact;
import Clinic.Clinic.domain.ports.EmergencyContactPort;
import Clinic.Clinic.infrastructure.persistence.entities.EmergencyContactEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.EmergencyContactMapper;
import Clinic.Clinic.infrastructure.persistence.repository.EmergencyContactRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmergencyContactAdapter implements EmergencyContactPort {

    private final EmergencyContactRepository emergencyContactRepository;

    public EmergencyContactAdapter(EmergencyContactRepository emergencyContactRepository) {
        this.emergencyContactRepository = emergencyContactRepository;
    }

    @Override
    public EmergencyContact findByPatientId(String patientDocument) {
        Optional<EmergencyContactEntity> entity = emergencyContactRepository.findByPatientDocument(patientDocument);
        return entity.map(EmergencyContactMapper::toDomain).orElse(null);
    }

    @Override
    public void save(EmergencyContact contact) {
        EmergencyContactEntity entity = EmergencyContactMapper.toEntity(contact);
        EmergencyContactEntity saved = emergencyContactRepository.save(entity);
        contact.setId(saved.getId());
    }

    @Override
    public void delete(EmergencyContact contact) {
        if (contact.getId() != null) {
            emergencyContactRepository.deleteById(contact.getId());
        }
    }
}
