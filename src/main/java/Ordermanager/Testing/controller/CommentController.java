package Ordermanager.Testing.controller;

import Ordermanager.Testing.entities.Comment;
import Ordermanager.Testing.entities.Product;
import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.service.CommentService;
import Ordermanager.Testing.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Response saveComment(@RequestBody Comment c) {
        Response response = new Response();
        try {
            response.setObject(commentService.save(c));
            response.setMessage("Commented");
            response.setSuccess(true);
        } catch (Exception e) {
            System.out.println(e.toString());
            response.setMessage("Not commented");
            response.setSuccess(false);
        }
        return response;
    }

    @GetMapping("/getAll")
    public List<Comment> getCommentaries() {
        return this.commentService.getAllComments();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        Comment comment = this.commentService.getCommentById(id);
        try {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Comment> updteComment(@RequestBody Comment c) {
        Comment comment = this.commentService.updateComment(c);
        try {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer id) {
        try {
            this.commentService.deleteCommentById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCommentaries() {
        try {
            this.commentService.deleteAll();
            return new ResponseEntity<>("All commentaries deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }
}
