//package Ordermanager.Testing.RequestsService;
//
//import Ordermanager.Testing.entities.Comment;
//import Ordermanager.Testing.entities.Product;
//import Ordermanager.Testing.entities.User;
//import Ordermanager.Testing.models.CommentToProduct;
//import Ordermanager.Testing.repository.CommentRepository;
//import Ordermanager.Testing.repository.ProductRepository;
//import Ordermanager.Testing.repository.UserRepository;
//import Ordermanager.Testing.utils.Helper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class CommentToProductServiceImpl1 implements CommentToProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//@Autowired
//private Helper helper;
//
//
//    @Override
//    public Product addCommentToProduct(CommentToProduct commentToProduct) {
//       // Comment comment1=getComment(commentToProduct);
//        Product product=getProduct(commentToProduct.getProductId());
//        String text=commentToProduct.getComment();
//        User user = getUser(commentToProduct.getUserId());
//        Comment c = new Comment();
//        c.setUser(user);
//        c.setText(commentToProduct.getComment());
//        c.setProduct(product);
//        List<Comment>comments = product.getComments();
//        comments.add(c);
//        productRepository.save(product);
//        return product;
//    }
//
//private User getUser(Integer userId){
//        User user = userRepository.findById(helper.getUser().getId()).get();
//return user;
//}
////    private Product getProduct(Integer productId,Comment comment) {
////        Product product = productRepository.findById(productId).get();
////        List<Comment>comments=product.getComments();
////        comments.add(comment);
////        productRepository.save(product);
////        return product;
////    }
//private Product getProduct(Integer productId) {
//    Product product = productRepository.findById(productId).get();
//    productRepository.save(product);
//    return product;
//}
////    private Comment getComment(CommentToProduct commentToProduct){
////        Comment comment = commentRepository.save(commentToProduct.getComment());
////        return comment;
////    }
//
//}
