package Clinic.Clinic.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AppointmentValidator extends SimpleValidator {

    public LocalDateTime validateDateTime(String value) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(value.trim(), formatter);
            if (dateTime.isBefore(LocalDateTime.now())) {
                throw new Exception("La fecha de la cita debe ser futura");
            }
            return dateTime;
        } catch (Exception e) {
            throw new Exception("La fecha ingresada no tiene un formato válido (yyyy-MM-dd HH:mm)");
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
