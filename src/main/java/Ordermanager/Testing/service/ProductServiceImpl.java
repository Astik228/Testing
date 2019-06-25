package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

@Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
           return productRepository.save(product);
        }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Integer id) {
      return   productRepository.findById(id).get();

    }
    public Product getByTitle(String title){
        return productRepository.getFirstByTitle(title);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public void deleteAll(){
        productRepository.deleteAll();
    }


}
