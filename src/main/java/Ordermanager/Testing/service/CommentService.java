package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Comment;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.User;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);

    Comment getCommentById(Integer id);

    List<Comment> getAllComments();

    Comment updateComment(Comment comment);

    void deleteAll();

    void deleteCommentById(Integer id);

}
