package kz.iitu.library.services;

import kz.iitu.library.classes.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
}
