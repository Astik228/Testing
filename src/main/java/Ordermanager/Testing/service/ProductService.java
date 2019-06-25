package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProductById(Integer id);

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    void deleteAll();

    Product getByTitle(String title);

    void deleteProductById(Integer id);


}
