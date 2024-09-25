package org.example.app.service;

import org.example.app.entity.user.User;
import org.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Optional<User> save(User user) {
        return Optional.of(repository.save(user));
    }

    public Optional<List<User>> getAll() {
        return Optional.of(repository.findAll());
    }

    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User update(Long id, User user) {
        String username = user.getUsername();
        String comment = user.getComment();
        String value = user.getValue();
        Optional<User> optional = repository.findById(id);
        if (optional.isPresent()) {
            User userUpdate = optional.get();
            if (username != null)
                userUpdate.setUsername(username);
            if (comment != null)
                userUpdate.setComment(comment);
            if (value != null)
                userUpdate.setValue(value);
            repository.save(userUpdate);
        }
        return repository.findById(id).orElse(null);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else return false;
    }

    public List<User> getByUserName(String username) {
        return repository.findByUserName(username)
                .orElse(Collections.emptyList());
    }

    public List<User> getByComment(String comment) {
        return repository.findByComment(comment)
                .orElse(Collections.emptyList());
    }
}
