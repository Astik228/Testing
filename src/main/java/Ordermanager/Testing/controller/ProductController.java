package Ordermanager.Testing.controller;

import Ordermanager.Testing.entities.Product;

import Ordermanager.Testing.service.ProductService;
import Ordermanager.Testing.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    ProductService productService;



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer id) {
        try {
            this.productService.deleteProductById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product product1 = this.productService.saveProduct(product);
        try {
            return new ResponseEntity<>(product1, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = this.productService.getProductById(id);
        try {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getByCategory/{category}")
    public Response getProductByCategory(@PathVariable String category) {
        try{
            new Response("Product by Category:",true,productService.findAllByCategoryTitle(category));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
      return   new Response("ERROR",false,null);
    }  @GetMapping("/getFirstByTitle/{title}")
    public Response getFirstByTitle(@PathVariable String title) {
        try{
            new Response("Product by title:",true,productService.getFirstByTitle(title));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
      return   new Response("ERROR",false,null);
    }
//    @GetMapping("/getByName/{name}")
//    public Response getProductByName(@PathVariable String name) {
//        try{
//            new Response("Product by name:",true,productService.findByName(name));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//      return   new Response("ERROR",false,null);
//    }

    @GetMapping("/getAll")
    public List<Product> getProducts() {
        return this.productService.getAllProducts();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        try {
            this.productService.deleteAll();
            return new ResponseEntity<>("All products deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product product1 = this.productService.updateProduct(product);
        try {
            return new ResponseEntity<>(product1, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
