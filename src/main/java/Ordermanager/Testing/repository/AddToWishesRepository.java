package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.UserWishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("addToWishesRepository")
public interface AddToWishesRepository extends JpaRepository<UserWishes,Integer> {
}
