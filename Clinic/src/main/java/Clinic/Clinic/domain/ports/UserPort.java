package Clinic.Clinic.domain.ports;

import Clinic.Clinic.domain.model.User;

public interface UserPort {
    User findByDocument(User user) throws Exception;
    User findByUserName(User user) throws Exception;
    void save(User user) throws Exception;
}
