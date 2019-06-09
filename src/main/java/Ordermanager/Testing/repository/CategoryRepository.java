package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
