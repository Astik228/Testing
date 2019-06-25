package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.Role;
import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.repository.ProductRepository;
import Ordermanager.Testing.repository.RoleRepo;
import Ordermanager.Testing.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImp1 implements UserService1 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User findUserByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }
    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }
    @Override
    public User registration(User user) {
        //Role role2 = roleRepo.findAll().stream().filter(n -> n.getRoleName().equals("ROLE_USER")).findFirst().get();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role role = roleRepo.getFirstByRoleName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);
        return user;
    }

    public User getUser(Integer userId) {
        User user = userRepository.findById(userId).get();
        return user;
    }



    public Product getProduct(Integer productId) {
        Product product = productRepository.findById(productId).get();
        return product;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }


}

    

