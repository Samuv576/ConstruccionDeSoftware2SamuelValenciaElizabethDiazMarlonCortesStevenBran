package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.SpecialistType;
import Clinic.Clinic.domain.ports.SpecialistTypePort;
import Clinic.Clinic.infrastructure.persistence.entities.SpecialistTypeEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.SpecialistTypeMapper;
import Clinic.Clinic.infrastructure.persistence.repository.SpecialistTypeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SpecialistTypeAdapter implements SpecialistTypePort {

    private final SpecialistTypeRepository specialistTypeRepository;

    public SpecialistTypeAdapter(SpecialistTypeRepository specialistTypeRepository) {
        this.specialistTypeRepository = specialistTypeRepository;
    }

    @Override
    public SpecialistType findById(Integer id) {
        if (id == null) {
            return null;
        }
        return specialistTypeRepository.findById(id.longValue())
                .map(SpecialistTypeMapper::toDomain)
                .orElse(null);
    }

    @Override
    public SpecialistType findByName(String name) {
        return specialistTypeRepository.findByName(name)
                .map(SpecialistTypeMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void save(SpecialistType specialistType) {
        SpecialistTypeEntity entity = SpecialistTypeMapper.toEntity(specialistType);
        SpecialistTypeEntity saved = specialistTypeRepository.save(entity);
        specialistType.setId(saved.getId().intValue());
    }

    @Override
    public void delete(SpecialistType specialistType) {
        if (specialistType.getId() != null) {
            specialistTypeRepository.deleteById(specialistType.getId().longValue());
        }
    }

    @Override
    public List<SpecialistType> findAll() {
        return specialistTypeRepository.findAll().stream()
                .map(SpecialistTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
