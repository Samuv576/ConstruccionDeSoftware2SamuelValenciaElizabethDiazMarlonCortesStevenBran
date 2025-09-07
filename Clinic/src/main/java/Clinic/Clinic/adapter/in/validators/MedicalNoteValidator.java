package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MedicalNoteValidator extends SimpleValidator {

    public long validatePatientId(String value) throws Exception {
        return longValidator("ID del paciente", value);
    }

    public long validateDoctorId(String value) throws Exception {
        return longValidator("ID del médico", value);
    }

    public String validateNoteContent(String value) throws Exception {
        return stringValidator("contenido de la nota médica", value);
    }

    public LocalDateTime validateDateTime(String value) throws Exception {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(value);
            return dateTime;
        } catch (Exception e) {
            throw new Exception("La fecha ingresada no tiene un formato válido (yyyy-MM-ddTHH:mm)");
        }
    }
}
