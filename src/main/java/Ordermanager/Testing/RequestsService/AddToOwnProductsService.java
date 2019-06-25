package Ordermanager.Testing.RequestsService;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.models.AddToOwnProducts;
import Ordermanager.Testing.models.AddToWishes;

import java.util.List;

public interface AddToOwnProductsService {
    List<Product> addToOwnProducts(AddToOwnProducts addToOwnProducts);

}
