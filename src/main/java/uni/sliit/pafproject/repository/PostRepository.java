package uni.sliit.pafproject.repository;

import uni.sliit.pafproject.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post,String> {

    List<Post> findByPostTopic(String postTopic);

    @Query("{postUserId:?0 }")
    List<Post> getsPostByPostUserId(String postUserId);

    @Query("{postLikeCount:?0 }")
    List<Post> getsPostByLikeCount(int postLikeCount);

    @Query("{postDisLikeCount:?0 }")
    List<Post> getsPostByDisLikeCount(int postDisLikeCount);

    @Query("{postNeutralCount:?0 }")
    List<Post> getsPostByNeutralCount(int postNeutralCount);


}
