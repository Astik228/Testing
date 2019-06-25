package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findFirstByEmail(String email);
}
