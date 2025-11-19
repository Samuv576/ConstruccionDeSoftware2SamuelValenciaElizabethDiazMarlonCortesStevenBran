package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class MedicalHistoryValidator {

    public String validatePatientDocument(String document) throws Exception {
        if (document == null || document.isEmpty()) {
            throw new Exception("El documento del paciente no puede estar vacío");
        }
        if (document.length() > 20) {
            throw new Exception("El documento del paciente no puede tener más de 20 caracteres");
        }
        return document;
    }
}
