package Clinic.Clinic.adapter.out;

import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.domain.ports.UserPort;
import Clinic.Clinic.infrastructure.persistence.entities.UserEntity;
import Clinic.Clinic.infrastructure.persistence.mapper.UserMapper;
import Clinic.Clinic.infrastructure.persistence.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserAdapter implements UserPort {

    private final UserRepository userRepository;

    public UserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByDocument(User user) {
        if (user == null || user.getDocument() == null) {
            return null;
        }

        UserEntity entity = userRepository.findByDocument(user.getDocument());
        return UserMapper.toDomain(entity);
    }

    @Override
    public User findByUserName(User user) {
        if (user == null || user.getUsername() == null) {
            return null;
        }

        UserEntity entity = userRepository.findByUserName(user.getUsername());
        return UserMapper.toDomain(entity);
    }

    @Override
    public void save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity saved = userRepository.save(entity);
        // Update the domain object with the generated ID
        user.setId(saved.getId());
    }

    @Override
    public void delete(User user) {
        if (user == null || user.getId() == 0) {
            return;
        }

        userRepository.deleteById(user.getId());
    }

    @Override
    public boolean isEmpty() {
        return userRepository.count() == 0;
    }
}
