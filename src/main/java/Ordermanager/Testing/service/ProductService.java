package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Category;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.models.JsonMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProductById(Integer id);

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    void deleteAll();

    void deleteProductById(Integer id);

    //List<Product>findByCategory(String category);
   // List<Product>findByName(String name);
    List<Product>findAllByCategoryTitle(String category);
    Product getFirstByTitle(String title);

}
