package Clinic.Clinic.domain.services;

import Clinic.Clinic.domain.model.*;
import Clinic.Clinic.domain.ports.*;

public class CreateUser {

    private final UserPort userPort;

    public CreateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void create(User user) throws Exception {
        if (userPort.findByDocument(user) != null) {
            throw new Exception("Ya existe una persona registrada con esa cédula");
        }

        if (userPort.findByUserName(user) != null) {
            throw new Exception("Ya existe una persona registrada con ese nombre de usuario");
        }

        userPort.save(user);
    }
}
