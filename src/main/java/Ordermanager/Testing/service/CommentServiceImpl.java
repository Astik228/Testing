package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Comment;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.repository.CommentRepository;
import Ordermanager.Testing.repository.ProductRepository;
import Ordermanager.Testing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Product save(Comment comment) {
        User user1 = userRepository.findById(comment.getUser().getId()).get();
        Product product1 = productRepository.findById(comment.getProduct().getId()).get();
        List<Comment>comments = product1.getComments();

        comment.setProduct(product1);

        comment.setUser(user1);

        comments.add(comment);

        product1.setComments(comments);

        commentRepository.save(comment);
        productRepository.save(product1);
        userRepository.save(user1);
        return  comment.getProduct();
    }


    public User getUser(Integer userId) {
        User user1 = userRepository.findById(userId).get();
        return user1;
    }

    public Product getProduct(Product product) {
        Product product1 =productRepository.getOne(product.getId());
        return  product1;
    }
    private Product getProduct(Integer productId) {
        Product product = productRepository.findById(productId).get();
        return product;
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        commentRepository.deleteAll();
    }
}

