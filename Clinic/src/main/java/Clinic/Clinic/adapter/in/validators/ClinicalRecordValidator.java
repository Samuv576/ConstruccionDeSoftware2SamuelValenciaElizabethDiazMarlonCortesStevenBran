package Clinic.Clinic.adapter.in.validators;

import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.model.VitalSigns;
import org.springframework.stereotype.Component;

@Component
public class ClinicalRecordValidator extends SimpleValidator {

    public void validateMedicalNote(MedicalNote note) throws Exception {
        if (note == null) {
            throw new Exception("La nota médica no puede ser nula");
        }
    }

    public void validateClinicalOrder(ClinicalOrder order) throws Exception {
        if (order == null) {
            throw new Exception("La orden clínica no puede ser nula");
        }
    }

    public void validateVitalSigns(VitalSigns signs) throws Exception {
        if (signs == null) {
            throw new Exception("Los signos vitales no pueden ser nulos");
        }
    }

    public String validatePatientDocument(String value) throws Exception {
        return stringValidator("documento del paciente", value);
    }
}
