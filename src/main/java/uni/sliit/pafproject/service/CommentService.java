package uni.sliit.pafproject.service;


import uni.sliit.pafproject.externalfunctionalities.RandomIdGenerator;
import uni.sliit.pafproject.model.Comment;
import uni.sliit.pafproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository comment_repository;
    //CRUD CREATE READ UPDATE DELETE

    public Comment addComment(Comment comment){

        RandomIdGenerator obj = new RandomIdGenerator();
        String generatedCommentId = obj.getGeneratedId("comment").toString();

        comment.setCommentId(generatedCommentId);

        comment.setCommentHref("http://localhost:8080/comments");
        comment.setCommentSelf("http://localhost:8080/comments/" + generatedCommentId);

        return comment_repository.save(comment);
    }

    public List<Comment> findAllComments(){
        return comment_repository.findAll();
    }

    public Comment getCommentByCommentId(String commentId){
        return comment_repository.findById(commentId).get();
    }

    public List<Comment> getCommentByDescription(String commentDescription){
        return comment_repository.getsCommentByDescription(commentDescription);
    }

    public List<Comment> getCommentByUserId(String commentUserId){
        return comment_repository.getCommentByUserId(commentUserId);
    }

    public List<Comment> getCommentByPostId(String commentPostId){
        return comment_repository.getsCommentByPostId(commentPostId);
    }
    public Comment updateCommentDetails(Comment commentRequest){
        Comment existingComment = comment_repository.findById(commentRequest.getCommentId()).get();
        existingComment.setCommentDescription(commentRequest.getCommentDescription());
        return comment_repository.save(existingComment);
    }

    public String deleteComment(String commentUserId){
        comment_repository.deleteById(commentUserId);
        return commentUserId + " comment deleted from database";
    }


}
