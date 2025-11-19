package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.ports.MedicalNotePort;
import Clinic.Clinic.infrastructure.persistence.entities.MedicalNoteEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.MedicalNoteMapper;
import Clinic.Clinic.infrastructure.persistence.repository.MedicalNoteRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MedicalNoteAdapter implements MedicalNotePort {

    private final MedicalNoteRepository medicalNoteRepository;

    public MedicalNoteAdapter(MedicalNoteRepository medicalNoteRepository) {
        this.medicalNoteRepository = medicalNoteRepository;
    }

    @Override
    public MedicalNote findById(MedicalNote note) {
        Optional<MedicalNoteEntity> entity = medicalNoteRepository.findById(note.getId());
        return entity.map(MedicalNoteMapper::toDomain).orElse(null);
    }

    @Override
    public void save(MedicalNote note) {
        MedicalNoteEntity entity = MedicalNoteMapper.toEntity(note);
        MedicalNoteEntity saved = medicalNoteRepository.save(entity);
        note.setId(saved.getId());
    }

    @Override
    public void delete(MedicalNote note) {
        medicalNoteRepository.deleteById(note.getId());
    }
}
