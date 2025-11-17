package Clinic.Clinic.infrastructure.persistence.mapper;

import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.domain.model.enums.Role;
import Clinic.Clinic.infrastructure.persistence.entities.UserEntity;

public final class UserMapper {

    private UserMapper() {
    }

    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUserName(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        if (user.getRole() != null) {
            entity.setRole(user.getRole().name());
        }
        entity.setDateOfBirth(user.getDateOfBirth());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        User user = new User();
        user.setId(entity.getId());
        user.setUsername(entity.getUserName());
        user.setPassword(entity.getPassword());
        user.setEmail(entity.getEmail());
        if (entity.getRole() != null) {
            user.setRole(Role.valueOf(entity.getRole()));
        }
        user.setDateOfBirth(entity.getDateOfBirth());
        return user;
    }
}
