package Ordermanager.Testing.service;

import Ordermanager.Testing.Exceptions.NotEnoughMoneyException;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.entities.Wallet;
import Ordermanager.Testing.enums.Wallets;
import Ordermanager.Testing.repository.ProductRepository;
import Ordermanager.Testing.repository.UserRepository;

import Ordermanager.Testing.repository.WalletRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImp1 implements UserService1 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WalletRepository walletRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();

    }





    public User getUser(Integer userId) {
        User user = userRepository.findById(userId).get();
        return user;
    }

    public Wallet getWallet(Integer walletId) {
        Wallet wallet = walletRepository.findById(walletId).get();
        return wallet;
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

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
}

    

