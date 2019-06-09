package Ordermanager.Testing.controller;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.Exceptions.NotEnoughMoneyException;
import Ordermanager.Testing.Exceptions.ProductOutOfStockException;

import Ordermanager.Testing.RequestsService.OrderProductService;
import Ordermanager.Testing.models.BuyProduct;
import Ordermanager.Testing.models.ToOrderProduct;
import Ordermanager.Testing.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderProductService orderProductService;

    @PostMapping
    public Response orderProduct(@RequestBody ToOrderProduct toOrderProduct) throws  AmountOfProductsBoudException, ProductOutOfStockException {
        try {
            return new Response("Ordered!", true, this.orderProductService.order(toOrderProduct));
        } catch (Exception e) {
            return new Response(e.getMessage(), false, null);
        }
    }
}
