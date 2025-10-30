package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.domain.ports.UserPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserAdapter implements UserPort {

    private final List<User> database = new ArrayList<>();

    @Override
    public User findByDocument(User user) {
        return database.stream()
                .filter(u -> u.getId() == user.getId())
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByUserName(User user) {
        return database.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(user.getUsername()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(User user) {
        User existing = findByDocument(user);
        if (existing != null) {
            database.remove(existing);
        }
        database.add(user);
    }

    @Override
    public void delete(User user) {
        database.removeIf(u -> u.getId() == user.getId());
    }

    @Override
    public boolean isEmpty() {
        return database.isEmpty(); // ✅ implementación nueva
    }
}
