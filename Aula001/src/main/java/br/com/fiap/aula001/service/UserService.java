package br.com.fiap.aula001.service;

import br.com.fiap.aula001.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId) throws ChangeSetPersister.NotFoundException;

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}