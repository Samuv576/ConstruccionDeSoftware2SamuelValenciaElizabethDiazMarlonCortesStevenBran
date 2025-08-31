package Clinic.Clinic.application.usecases;

import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.domain.model.enums.Role;
import Clinic.Clinic.domain.services.UserService;

public class UserUseCase {

    private final UserService userService;

    public UserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void createUser(User user) throws Exception {
        userService.create(user);
    }

    public void deleteUser(User user) throws Exception {
        userService.delete(user);
    }

    public User findUserByUsername(String username) throws Exception {
        return userService.findByUsername(username);
    }

    public User findUserByDocument(String document) throws Exception {
        return userService.findByDocument(document);
    }

    public void updateUserPassword(User user, String newPassword) throws Exception {
        userService.updatePassword(user, newPassword);
    }

    public void assignUserRole(User user, Role role) throws Exception {
        userService.assignRole(user, role);
    }
}