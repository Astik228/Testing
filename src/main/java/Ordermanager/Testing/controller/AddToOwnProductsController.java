package Ordermanager.Testing.controller;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.RequestsService.AddToOwnProductsService;
import Ordermanager.Testing.RequestsService.AddToWishesService;
import Ordermanager.Testing.models.AddToOwnProducts;
import Ordermanager.Testing.models.AddToWishes;
import Ordermanager.Testing.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/addToOwnProducts")
public class AddToOwnProductsController {
    @Autowired
    private AddToOwnProductsService  addToOwnProductsService;

    @PostMapping
    public Response addToOwnProducts(@RequestBody AddToOwnProducts addToOwnProducts) {
        try {
                return new Response("Added!", true, addToOwnProductsService.addToOwnProducts(addToOwnProducts));
        } catch (Exception e) {
            return new Response(e.getMessage(), false, null);
        }
    }



}
