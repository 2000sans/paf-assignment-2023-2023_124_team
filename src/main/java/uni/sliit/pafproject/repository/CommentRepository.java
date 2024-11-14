package uni.sliit.pafproject.repository;

import uni.sliit.pafproject.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,String> {

    @Query("{commentDescription:?0 }")
    List<Comment> getsCommentByDescription(String commentDescription);

    @Query("{commentUserId:?0 }")
    List<Comment> getCommentByUserId(String commentUserId);

    @Query("{commentPostId:?0 }")
    List<Comment> getsCommentByPostId(String commentPostId);

}
