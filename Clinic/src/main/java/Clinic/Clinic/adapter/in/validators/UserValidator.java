package Clinic.Clinic.adapter.in.validators;

import Clinic.Clinic.domain.model.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class UserValidator extends SimpleValidator {

    public long validateId(String value) throws Exception {
        return longValidator("ID del usuario", value);
    }

    public String validateUsername(String value) throws Exception {
        if (value == null || !value.matches("^[a-zA-Z0-9]{1,15}$")) {
            throw new Exception("El nombre de usuario debe tener máximo 15 caracteres, solo letras y números");
        }
        return value;
    }

    public String validatePassword(String value) throws Exception {
        if (value == null ||
            value.length() < 8 ||
            !value.matches(".*[A-Z].*") ||
            !value.matches(".*\\d.*") ||
            !value.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
            throw new Exception("La contraseña debe tener al menos 8 caracteres, una mayúscula, un número y un carácter especial");
        }
        return value;
    }

    public String validateEmail(String value) throws Exception {
        if (value == null || !value.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new Exception("El correo electrónico no es válido");
        }
        return value;
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

    public Role validateRole(String value) throws Exception {
        try {
            return Role.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new Exception("El rol debe ser uno de los siguientes: ADMIN, DOCTOR, NURSE, SUPPORT, HRSTAFF, PATIENT");
        }
    }
}
