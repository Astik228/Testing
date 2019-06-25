package Ordermanager.Testing.bootstrap;

import Ordermanager.Testing.entities.*;
import Ordermanager.Testing.enums.*;
import Ordermanager.Testing.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserBootstrap implements CommandLineRunner {

    @Autowired
   private CommentRepository commentRepository;

    @Autowired
   private ProductRepository productRepository;

    @Autowired
   private UserRepository userRepository;
    @Autowired
    private RoleRepo roleRepo;

    @Autowired
   private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Role userRole = new Role();
        userRole.setRoleName("ROLE_USER");
        Role adminRole = new Role();
        adminRole.setRoleName("ROLE_ADMIN");
        roleRepo.save(adminRole);
        roleRepo.save(userRole);



        Category category = new Category();
        category.setTitle("SPIRITS");
        categoryRepository.save(category);


    }
}

