package Ordermanager.Testing.RequestsService;

import Ordermanager.Testing.Exceptions.AmountOfProductsBoudException;
import Ordermanager.Testing.Exceptions.NotEnoughMoneyException;
import Ordermanager.Testing.Exceptions.ProductOutOfStockException;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.models.ToOrderProduct;

public interface OrderProductService {
    Product order(ToOrderProduct toOrderProduct) throws ProductOutOfStockException, AmountOfProductsBoudException;


}
