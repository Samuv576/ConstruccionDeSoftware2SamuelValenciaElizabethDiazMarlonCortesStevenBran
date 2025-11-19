package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.infrastructure.persistence.entities.MedicalNoteEntity;

public class MedicalNoteMapper {
    public static MedicalNoteEntity toEntity(MedicalNote medicalNote) {
        MedicalNoteEntity entity = new MedicalNoteEntity();
        if (medicalNote.getId() > 0) {
            entity.setId(medicalNote.getId());
        }
        entity.setPatientDocument(medicalNote.getPatientDocument());
        entity.setDoctorDocument(medicalNote.getDoctorDocument());
        entity.setConsultationDate(medicalNote.getConsultationDate());
        entity.setConsultationReason(medicalNote.getConsultationReason());
        entity.setSymptoms(medicalNote.getSymptoms());
        entity.setDiagnosis(medicalNote.getDiagnosis());
        entity.setNotes(medicalNote.getNotes());
        return entity;
    }

    public static MedicalNote toDomain(MedicalNoteEntity entity) {
        MedicalNote medicalNote = new MedicalNote();
        medicalNote.setId(entity.getId());
        medicalNote.setPatientDocument(entity.getPatientDocument());
        medicalNote.setDoctorDocument(entity.getDoctorDocument());
        medicalNote.setConsultationDate(entity.getConsultationDate());
        medicalNote.setConsultationReason(entity.getConsultationReason());
        medicalNote.setSymptoms(entity.getSymptoms());
        medicalNote.setDiagnosis(entity.getDiagnosis());
        medicalNote.setNotes(entity.getNotes());
        return medicalNote;
    }
}
