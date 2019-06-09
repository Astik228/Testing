package Ordermanager.Testing.bootstrap;

import Ordermanager.Testing.entities.*;
import Ordermanager.Testing.enums.*;
import Ordermanager.Testing.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserBootstrap implements CommandLineRunner {

@Autowired
CommentRepository commentRepository;
//@Autowired
//CommentToProductRepository commentToProduct;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BuyProductRepository buyProductRepository;
@Autowired
CategoryRepository categoryRepository;
//    @Autowired
//    CommentToProductService commentToProductservice;

    @Override
    public void run(String... args) throws Exception {




            Wallet wallet =new Wallet();
            wallet.setBalance(15.00000000);
            wallet.setWallets(Wallets.QIWI);
            walletRepository.save(wallet);



            User user=new User();
    user.setName("User"); //8 полей
    user.setEmail("serikovastik@gmail.com");
    user.setPassword("121115113");
    user.setActive(1);
 //   user.setWallet(wallet);
    user.setLastName("Serikov");
    userRepository.save(user);



            Category category= new Category();
            category.setTitle("SPIRITS");
            categoryRepository.save(category);

            Category category1= new Category();
            category.setTitle("TOYS");
            categoryRepository.save(category1);


            Product product =new Product();
            product.setTitle("Essens spirits ");
            product.setPrice(15.5);
            product.setDescription("Very good smell");
            product.setCountry(Country.KYRGYZSTAN);
            product.setCategory(category);
            product.setAddress("Baytik Baatyra");
            product.setAvailableStatuses(AvailableStatuses.INSTOCK);
            product.setAmount(5);
            productRepository.save(product);

        Comment comment1 = new Comment();
        comment1.setText("Gooood");
        comment1.setUser(user);
        comment1.setProduct(product);
        commentRepository.save(comment1);

        ArrayList<Comment>comments=new ArrayList<>();
        comments.add(comment1);



        Product product2 =new Product();
            product2.setTitle("LEGO AVENGERS");
            product2.setPrice((double)9000);
            product2.setDescription("Very smart TOY for your Baby");
            product2.setCountry(Country.KYRGYZSTAN);
            product2.setCategory(category1);
            product2.setAddress("OSH");
            product2.setAvailableStatuses(AvailableStatuses.INSTOCK);
            product2.setAmount(5);
            product.setComments(comments);
            productRepository.save(product2);

        System.out.println(product);
        System.out.println(product2);










    }
    }

