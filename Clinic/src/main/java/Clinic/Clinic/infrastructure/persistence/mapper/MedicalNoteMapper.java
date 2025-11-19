package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.infrastructure.persistence.entities.MedicalNoteEntity;

public class MedicalNoteMapper {
    public static MedicalNoteEntity toEntity(MedicalNote medicalNote) {
        MedicalNoteEntity entity = new MedicalNoteEntity();
        entity.setId(medicalNote.getId());
        entity.setNote(medicalNote.getNote());
        return entity;
    }

    public static MedicalNote toDomain(MedicalNoteEntity entity) {
        MedicalNote medicalNote = new MedicalNote();
        medicalNote.setId(entity.getId());
        medicalNote.setNote(entity.getNote());
        return medicalNote;
    }
}
