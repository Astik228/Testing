package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.UserOwnProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddToOwnProductsRepository extends JpaRepository<UserOwnProducts,Long> {
}
