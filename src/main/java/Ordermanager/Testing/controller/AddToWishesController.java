package Ordermanager.Testing.controller;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.models.AddToWishes;
import Ordermanager.Testing.RequestsService.AddToWishesService;
import Ordermanager.Testing.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/addToWish")
public class AddToWishesController {


    @Autowired
   private AddToWishesService addToWishesService;

@PostMapping
    public Response addToWish(@RequestBody AddToWishes addToWishes) {
        try {
            return new Response("Added!", true, this.addToWishesService.addToWishes(addToWishes));
        } catch (AmountOfProductsBoudException e) {
            return new Response(e.getMessage(), false, null);
        }
    }



}
