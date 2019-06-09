//package Ordermanager.Testing.RequestsService;
//
//import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
//import Ordermanager.Testing.Exceptions.NotEnoughMoneyException;
//import Ordermanager.Testing.Exceptions.ProductOutOfStockException;
//import Ordermanager.Testing.entities.Product;
//
//import Ordermanager.Testing.entities.User;
//
//import Ordermanager.Testing.enums.AvailableStatuses;
//import Ordermanager.Testing.models.BuyProduct;
//import Ordermanager.Testing.repository.AddToWishesRepository;
//import Ordermanager.Testing.repository.ProductRepository;
//
//import Ordermanager.Testing.repository.UserRepository;
//import Ordermanager.Testing.repository.WalletRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BuyProductServiceImpl1 implements BuyProductService {
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    ProductRepository productRepository;
//    @Autowired
//    WalletRepository walletRepository;
//    @Autowired
//    AddToWishesRepository addToWishesRepository;
//
//    @Override
//    public Product buyProduct(BuyProduct buyProduct) throws NotEnoughMoneyException, ProductOutOfStockException, AmountOfProductsBoudException {
//        User user = userRepository.findById(buyProduct.getUserId()).get();
//        Product product = productRepository.findById(buyProduct.getProductId()).get();
//        double currentBalance = user.getWallet().getBalance();
//        double productPrice = product.getPrice();
//    //    buy(user, product, currentBalance, productPrice, buyProduct);
//        if (product.getAvailableStatuses().equals(AvailableStatuses.INSTOCK)) {
//            if (currentBalance < productPrice) {
//                //  double  desiredPrise=product.getPrice()-user.getWallet().getBalance();
//                throw new NotEnoughMoneyException("You don't have enough money to buy! Your balance: " + user.getWallet().getBalance());
//            } else if (currentBalance >= productPrice) {
//                int productAmount = product.getAmount();
//                int amount = buyProduct.getAmountOfProducts();
//                if (amount <= productAmount) {
//                    productPrice = productPrice * amount;
//                    double balanceAfterBuy = currentBalance - productPrice;
//                    System.out.println(productPrice);
//                    System.out.println("Счет: " + currentBalance + " - " + productPrice + " = " + balanceAfterBuy);
//                    user.getWallet().setBalance(balanceAfterBuy);
//                    System.out.println("Вы купили : " + product);
//                    //  products.add(product);
//                    System.out.println("Текущий баланс: " + balanceAfterBuy);
//                    user.getProducts().remove(product);
//                    System.out.println("Куплено: " + user.getProducts().toString());
//                    userRepository.save(user);
//                } else
//                    throw new AmountOfProductsBoudException("Вы не можете купить больше чем есть! \nКоличество которое вы хотите купить: " + amount + "\nКоличество которое есть: " + productAmount);
//            }
//        } else throw new ProductOutOfStockException("Product is out of Stock");
//
//        return product;
//    }
//
//    private User getUser(BuyProduct buyProduct) {
//        User user = userRepository.findById(buyProduct.getAmountOfProducts()).get();
//        return user;
//    }
//
//    private Product getProduct(BuyProduct buyProduct) {
//        Product product = productRepository.findById(buyProduct.getProductId()).get();
//        return product;
//    }
//
//    private void buy(User user, Product product, double currentBalance, double productPrice, BuyProduct buyProduct) throws NotEnoughMoneyException, AmountOfProductsBoudException, ProductOutOfStockException {
//        if (product.getAvailableStatuses().equals(AvailableStatuses.INSTOCK)) {
//            if (currentBalance < productPrice) {
//                //  double  desiredPrise=product.getPrice()-user.getWallet().getBalance();
//                throw new NotEnoughMoneyException("You don't have enough money to buy! \nYour balance: " + user.getWallet().getBalance());
//            } else if (currentBalance >= productPrice) {
//                int productAmount = product.getAmount();
//                int amount = buyProduct.getAmountOfProducts();
//                if (amount <= productAmount) {
//                    productPrice = productPrice * amount;
//                    double balanceAfterBuy = currentBalance - productPrice;
//                    System.out.println(productPrice);
//                    System.out.println("Счет: " + currentBalance + " - " + productPrice + " = " + balanceAfterBuy);
//                    user.getWallet().setBalance(balanceAfterBuy);
//                    System.out.println("Вы купили : " + product);
//                    //  products.add(product);
//                    System.out.println("Текущий баланс: " + balanceAfterBuy);
//                    user.getProducts().remove(product);
//                    System.out.println("Куплено: " + user.getProducts().toString());
//                    userRepository.save(user);
//                } else
//                    throw new AmountOfProductsBoudException("Вы не можете купить больше чем есть! \nКоличество которое вы хотите купить: " + amount + "\nКоличество которое есть: " + productAmount);
//            }
//        } else throw new ProductOutOfStockException("Product is out of Stock");
//
//    }
//}
//
//
