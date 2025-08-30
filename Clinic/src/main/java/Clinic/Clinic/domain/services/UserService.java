package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.domain.model.enums.Role;
import Clinic.Clinic.domain.ports.UserPort;

import java.time.LocalDate;
import java.time.Period;

public class UserService {

    private final UserPort userPort;

    public UserService(UserPort userPort) {
        this.userPort = userPort;
    }

    public void create(User user) throws Exception {
        validateUserData(user);

        User existingByUsername = userPort.findByUserName(user);
        if (existingByUsername != null) {
            throw new Exception("Ya existe un usuario con ese nombre de usuario");
        }

        User existingByDocument = userPort.findByDocument(user);
        if (existingByDocument != null) {
            throw new Exception("Ya existe un usuario con ese documento");
        }

        userPort.save(user);
    }

    public void delete(User user) throws Exception {
        User existing = userPort.findByDocument(user);
        if (existing == null) {
            throw new Exception("No se encontró el usuario para eliminar");
        }

        userPort.delete(existing);
    }

    public User findByUsername(String username) throws Exception {
        User temp = new User();
        temp.setUsername(username);

        User found = userPort.findByUserName(temp);
        if (found == null) {
            throw new Exception("No se encontró usuario con ese nombre");
        }

        return found;
    }

    public User findByDocument(String document) throws Exception {
        User temp = new User();
        temp.setId(Long.parseLong(document));

        User found = userPort.findByDocument(temp);
        if (found == null) {
            throw new Exception("No se encontró usuario con ese documento");
        }

        return found;
    }

    public void updatePassword(User user, String newPassword) throws Exception {
        User existing = userPort.findByDocument(user);
        if (existing == null) {
            throw new Exception("No se encontró usuario para actualizar contraseña");
        }

        if (!isValidPassword(newPassword)) {
            throw new Exception("La nueva contraseña no cumple con los requisitos");
        }

        existing.setPassword(newPassword);
        userPort.save(existing);
    }

    public void assignRole(User user, Role role) throws Exception {
        User existing = userPort.findByDocument(user);
        if (existing == null) {
            throw new Exception("No se encontró usuario para asignar rol");
        }

        existing.setRole(role);
        userPort.save(existing);
    }

    private void validateUserData(User user) throws Exception {
        if (user.getUsername() == null || !user.getUsername().matches("^[a-zA-Z0-9]{1,15}$")) {
            throw new Exception("El nombre de usuario debe tener máximo 15 caracteres, solo letras y números");
        }

        if (!isValidPassword(user.getPassword())) {
            throw new Exception("La contraseña debe tener al menos 8 caracteres, una mayúscula, un número y un carácter especial");
        }

        if (user.getEmail() == null || !user.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new Exception("El correo electrónico no es válido");
        }

        if (user.getDateOfBirth() == null || calculateAge(user.getDateOfBirth()) > 150) {
            throw new Exception("La fecha de nacimiento no puede superar los 150 años");
        }

        if (user.getRole() == null) {
            throw new Exception("El rol del usuario es obligatorio");
        }
    }


    private boolean isValidPassword(String password) {
        return password != null &&
               password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");
    }

    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
