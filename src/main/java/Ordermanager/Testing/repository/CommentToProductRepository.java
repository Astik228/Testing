package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("commentToProductRepository")
public  interface CommentToProductRepository extends JpaRepository<Comment,Integer> {

}
