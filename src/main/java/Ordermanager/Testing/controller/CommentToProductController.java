//package Ordermanager.Testing.controller;
//
//import Ordermanager.Testing.models.CommentToProduct;
//import Ordermanager.Testing.RequestsService.CommentToProductService;
//import Ordermanager.Testing.utils.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/commentTo")
//public class CommentToProductController {
//    @Autowired
//    private CommentToProductService commentToProductService;
//
//    @PostMapping()
// //   @ResponseStatus(HttpStatus.CREATED)
//    public Response commentToProduct(@RequestBody CommentToProduct commentToProduct){
//        try {
//            return new Response("Commented!",true, commentToProductService.addCommentToProduct(commentToProduct));
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            return new Response("Error",false,null);
//        }
//    }
//}
