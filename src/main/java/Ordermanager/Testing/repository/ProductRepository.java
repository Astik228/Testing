package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.Category;
import Ordermanager.Testing.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product,Integer> {
//    //coalesce
//    @Query("from Product  p  where p.category  = :category ")
//
//    List<Product> findByCategory(@Param("category")String category);
////    @Query("from Product  p "+ "where concat(p.title,' ',p.price,' ',p.description,' ',p.amount,' ',p.category) " +
////            "like concat('%', :category ,'%') ")
////    List<Product> findByCategory(@Param("category")String category);
//@Query("    from Product  p "+ "where concat(p.title,' ',p.price,' ',p.description,' ',p.amount) " +
//        "like concat('%', :name ,'%') ")
//List<Product> findByName(@Param("name")String name);

List<Product> findAllByCategoryTitle(String category);
Product getFirstByTitle(String title);
}
