package uni.sliit.pafproject.controller;


import uni.sliit.pafproject.model.Comment;
import uni.sliit.pafproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService comment_service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment){
        return comment_service.addComment(comment);
    }
    @GetMapping
    public List<Comment> getComments(){
        return comment_service.findAllComments();

    }
    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable String commentId){
        return comment_service.getCommentByCommentId(commentId);
    }

    @GetMapping("/comment_description/{commentDescription}")
    public List<Comment> findCommentUsingCommentDescription(@PathVariable String commentDescription){
        return comment_service.getCommentByDescription(commentDescription);
    }

    @GetMapping("/comment_user_id/{commentUserId}")
    public List<Comment> findCommentUsingUserId(@PathVariable String commentUserId){
        return comment_service.getCommentByUserId(commentUserId);
    }

    @GetMapping("/comment_post_id/{commentPostId}")
    public List<Comment> findCommentUsingPostId(@PathVariable String commentPostId){
        return comment_service.getCommentByPostId(commentPostId);
    }
    @PutMapping
    public Comment modifyComment(@RequestBody Comment comment){
        return comment_service.updateCommentDetails(comment);

    }
    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable String commentId){
        return comment_service.deleteComment(commentId);
    }
}
