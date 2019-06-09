//package Ordermanager.Testing.controller;
//
//import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
//import Ordermanager.Testing.Exceptions.NotEnoughMoneyException;
//import Ordermanager.Testing.Exceptions.ProductOutOfStockException;
//import Ordermanager.Testing.models.BuyProduct;
//import Ordermanager.Testing.RequestsService.BuyProductService;
//import Ordermanager.Testing.utils.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/buyProduct")
//public class BuyProductController {
//    @Autowired
//    BuyProductService buyProductService;
//
//@PostMapping
//    public Response buyProduct(@RequestBody BuyProduct buyProduct) throws NotEnoughMoneyException, AmountOfProductsBoudException, ProductOutOfStockException {
//        try {
//            return new Response("Bought!", true, this.buyProductService.buyProduct(buyProduct));
//        } catch (NotEnoughMoneyException e) {
//            return new Response(e.getMessage(), false, null);
//        }
//    }
//    }
//
