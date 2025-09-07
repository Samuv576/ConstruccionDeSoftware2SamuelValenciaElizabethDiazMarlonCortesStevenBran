package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InvoiceValidator extends SimpleValidator {

    public long validatePatientId(String value) throws Exception {
        return longValidator("ID del paciente", value);
    }

    public String validatePolicyNumber(String value) throws Exception {
        return stringValidator("número de póliza", value);
    }

    public double validateAmount(String value) throws Exception {
        return doubleValidator("monto de la factura", value);
    }

    public String validateDescription(String value) throws Exception {
        return stringValidator("descripción de la factura", value);
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
