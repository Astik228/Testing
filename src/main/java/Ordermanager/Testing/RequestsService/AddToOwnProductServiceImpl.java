package Ordermanager.Testing.RequestsService;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.models.AddToOwnProducts;
import Ordermanager.Testing.models.AddToWishes;
import Ordermanager.Testing.repository.ProductRepository;
import Ordermanager.Testing.repository.UserRepository;
import Ordermanager.Testing.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddToOwnProductServiceImpl implements AddToOwnProductsService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Helper helper;
    @Override
    public List<Product> addToOwnProducts(AddToOwnProducts addToOwnProducts)  {
        User user = userRepository.findById(helper.getUser().getId()).get();
        Product product = productRepository.findById(addToOwnProducts.getProductId()).get();
        List<Product> products = user.getProducts();
        product.setAmount(addToOwnProducts.getAmountOfProducts());
            products.add(product);
            user.setProducts(products);
            userRepository.save(user);
            productRepository.save(product);
        return user.getProducts();
    }
}
