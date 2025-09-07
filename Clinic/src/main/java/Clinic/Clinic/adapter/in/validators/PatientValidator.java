package Clinic.Clinic.adapter.in.validators;

import Clinic.Clinic.domain.model.enums.Gender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class PatientValidator extends SimpleValidator {

    public String validateFullName(String value) throws Exception {
        return stringValidator("nombre completo", value);
    }

    public LocalDate validateDateOfBirth(String value) throws Exception {
        try {
            LocalDate date = LocalDate.parse(value);
            int age = Period.between(date, LocalDate.now()).getYears();
            if (age > 150) {
                throw new Exception("La fecha de nacimiento no puede superar los 150 años");
            }
            return date;
        } catch (Exception e) {
            throw new Exception("La fecha ingresada no tiene un formato válido (yyyy-MM-dd)");
        }
    }

    public String validatePhone(String value) throws Exception {
        if (value == null || !value.matches("\\d{10}")) {
            throw new Exception("El número de teléfono debe tener exactamente 10 dígitos");
        }
        return value;
    }

    public String validateAddress(String value) throws Exception {
        if (value == null || value.length() > 30) {
            throw new Exception("La dirección debe tener máximo 30 caracteres");
        }
        return value;
    }

    public Gender validateGender(String value) throws Exception {
        try {
            return Gender.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new Exception("El género debe ser uno de los siguientes: MALE, FEMALE, OTHER");
        }
    }

    public long validateId(String value) throws Exception {
        return longValidator("ID del paciente", value);
    }
}
