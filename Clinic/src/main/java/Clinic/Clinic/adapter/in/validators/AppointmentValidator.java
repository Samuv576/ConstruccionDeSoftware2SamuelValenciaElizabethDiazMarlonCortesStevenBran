package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppointmentValidator extends SimpleValidator {

    public LocalDateTime validateDateTime(String value) throws Exception {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(value);
            if (dateTime.isBefore(LocalDateTime.now())) {
                throw new Exception("La fecha de la cita debe ser futura");
            }
            return dateTime;
        } catch (Exception e) {
            throw new Exception("La fecha ingresada no tiene un formato válido (yyyy-MM-ddTHH:mm)");
        }
    }

    public String validateReason(String value) throws Exception {
        return stringValidator("motivo de la cita", value);
    }

    public long validatePatientId(String value) throws Exception {
        return longValidator("ID del paciente", value);
    }

    public long validateDoctorId(String value) throws Exception {
        return longValidator("ID del doctor", value);
    }
}
