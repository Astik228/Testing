package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.User;

import java.util.List;

public interface UserService1 {
    User saveUser(User user);

    User getUserById(Integer id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteAll();

    void deleteUserById(Integer id);

    User registration(User u);



}
