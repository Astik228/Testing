package Ordermanager.Testing.RequestsService;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.UserWishes;
import Ordermanager.Testing.models.AddToWishes;

import java.util.List;

public interface AddToWishesService {
    List<Product> addToWishes(AddToWishes addToWishes) throws AmountOfProductsBoudException;
}
