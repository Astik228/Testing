package Ordermanager.Testing.RequestsService;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.Exceptions.NotEnoughMoneyException;
import Ordermanager.Testing.Exceptions.ProductOutOfStockException;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.enums.AvailableStatuses;
import Ordermanager.Testing.enums.MethodsOfPay;
import Ordermanager.Testing.enums.OrderStatuses;
import Ordermanager.Testing.models.BuyProduct;
import Ordermanager.Testing.models.ToOrderProduct;
import Ordermanager.Testing.repository.AddToWishesRepository;
import Ordermanager.Testing.repository.ProductRepository;
import Ordermanager.Testing.repository.UserRepository;
import Ordermanager.Testing.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductServiceImpl1 implements OrderProductService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private AddToWishesRepository addToWishesRepository;

    @Override
    public Product order(ToOrderProduct toOrderProduct) throws ProductOutOfStockException, AmountOfProductsBoudException {
        User user = userRepository.findById(toOrderProduct.getUserId()).get();
        Product product = productRepository.findById(toOrderProduct.getProductId()).get();
        double productPrice = product.getPrice();
        if (product.getAvailableStatuses().equals(AvailableStatuses.INSTOCK)) {
            int productAmount = product.getAmount();
            int wishAmount = toOrderProduct.getAmountOfProducts();
            if (wishAmount <= productAmount && wishAmount != 0) {
                productPrice = productPrice * wishAmount;
                System.out.println("Цена продукта: " + productPrice);
            } else throw new AmountOfProductsBoudException("Вы не можете заказать больше чем есть в наличии");
            if (toOrderProduct.getMethodsOfPay().equals(MethodsOfPay.GOTOSELLER)) {
                double priceWithSale = productPrice - (productPrice / 10);
                System.out.println("Цена со скидкой :" + priceWithSale);
                product.setPrice(priceWithSale);
                productRepository.save(product);
            }
            user.getProducts().remove(product);
            userRepository.save(user);
            System.out.println("Заказано: " + product);
        } else {
            product.setAmount(0);
            productRepository.save(product);
            throw new ProductOutOfStockException("Продукт не в наличии.");
        }
        return product;


    }
}
