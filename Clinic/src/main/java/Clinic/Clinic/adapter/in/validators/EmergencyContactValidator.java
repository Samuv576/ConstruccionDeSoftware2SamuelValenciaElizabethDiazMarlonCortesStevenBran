package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class EmergencyContactValidator extends SimpleValidator {

    public String validateFirstName(String value) throws Exception {
        return stringValidator("nombre del contacto", value);
    }

    public String validateLastName(String value) throws Exception {
        return stringValidator("apellido del contacto", value);
    }

    public String validateRelationship(String value) throws Exception {
        return stringValidator("relación con el paciente", value);
    }

    public String validatePhone(String value) throws Exception {
        if (value == null || !value.matches("\\d{10}")) {
            throw new Exception("El número de teléfono debe tener exactamente 10 dígitos numéricos");
        }
        return value;
    }

    public String validatePatientDocument(String value) throws Exception {
        return stringValidator("documento del paciente", value);
    }
}
