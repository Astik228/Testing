package Ordermanager.Testing.RequestsService;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.models.AddToWishes;
import Ordermanager.Testing.repository.ProductRepository;
import Ordermanager.Testing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddToWishesServiceImpl1 implements AddToWishesService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> addToWishes(AddToWishes addToWishes) throws AmountOfProductsBoudException {
        User user = userRepository.findById(addToWishes.getUserId()).get();
        Product product = productRepository.findById(addToWishes.getProductId()).get();
       List<Product> userWish=user.getProducts();
        Integer wishesAmount=addToWishes.getAmountOfProducts();
        Integer amount=product.getAmount();
        if(wishesAmount<=amount){
            product.setAmount(wishesAmount);
            userWish.add(product);
            user.setProducts(userWish);
            userRepository.save(user);
        }
        else throw new AmountOfProductsBoudException("Вы не можете заказать больше чем есть!");
        return user.getProducts();
    }
}
