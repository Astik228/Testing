package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.BuyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("buyProductRepository")
public interface BuyProductRepository extends JpaRepository<BuyProduct,Integer> {
}
