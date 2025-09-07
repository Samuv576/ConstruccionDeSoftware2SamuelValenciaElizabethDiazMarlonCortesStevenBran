package Clinic.Clinic.adapter.in.builder;

import Clinic.Clinic.adapter.in.validators.UserValidator;
import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.domain.model.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserBuilder {

    private final UserValidator validator;

    public UserBuilder(UserValidator validator) {
        this.validator = validator;
    }

    public User build(String idStr, String usernameStr, String passwordStr, String emailStr, String roleStr, String birthDateStr) throws Exception {
        long id = validator.validateId(idStr);
        String username = validator.validateUsername(usernameStr);
        String password = validator.validatePassword(passwordStr);
        String email = validator.validateEmail(emailStr);
        Role role = validator.validateRole(roleStr);
        LocalDate birthDate = validator.validateDateOfBirth(birthDateStr);

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        user.setDateOfBirth(birthDate);

        return user;
    }
}
