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
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Comment save(Comment comment) {
        Comment c = commentRepository.save(comment);
        return c;
    }

    public Product getProduct(Comment comment) {
        Product product = productRepository.findById(comment.getProduct().getId()).get();
        List<Comment> comments = product.getComments();
        comments.add(comment);
        productRepository.save(product);
        return product;
    }
//Could not beauty

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

