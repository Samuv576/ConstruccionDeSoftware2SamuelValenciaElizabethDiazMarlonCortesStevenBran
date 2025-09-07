package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.MedicalNoteValidator;
import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.model.Patient;
import Clinic.Clinic.domain.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MedicalNoteBuilder {

    private final MedicalNoteValidator validator;

    public MedicalNoteBuilder(MedicalNoteValidator validator) {
        this.validator = validator;
    }

    public MedicalNote build(String patientIdStr, String doctorIdStr, String noteContentStr, String dateTimeStr) throws Exception {
        long patientId = validator.validatePatientId(patientIdStr);
        long doctorId = validator.validateDoctorId(doctorIdStr);
        String noteContent = validator.validateNoteContent(noteContentStr);
        LocalDateTime dateTime = validator.validateDateTime(dateTimeStr);

        Patient patient = new Patient();
        patient.setId(patientId);

        User doctor = new User();
        doctor.setId(doctorId);

        MedicalNote note = new MedicalNote();
        note.setPatient(patient);
        note.setDoctor(doctor);
        note.setNote(noteContent);
        note.setDateTime(dateTime);

        return note;
    }
}
