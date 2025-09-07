package Clinic.Clinic.adapter.in.validators;

import Clinic.Clinic.domain.model.MedicalHistoryEntry;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MedicalHistoryValidator extends SimpleValidator {

    public String validatePatientDocument(String value) throws Exception {
        return stringValidator("documento del paciente", value);
    }

    public LocalDate validateEntryDate(String value) throws Exception {
        try {
            LocalDate date = LocalDate.parse(value);
            if (date.isAfter(LocalDate.now())) {
                throw new Exception("La fecha de la entrada no puede ser futura");
            }
            return date;
        } catch (Exception e) {
            throw new Exception("La fecha ingresada no tiene un formato válido (yyyy-MM-dd)");
        }
    }

    public void validateEntry(MedicalHistoryEntry entry) throws Exception {
        if (entry == null) {
            throw new Exception("La entrada del historial médico no puede ser nula");
        }
    }
}
