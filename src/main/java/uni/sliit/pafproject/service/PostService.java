package uni.sliit.pafproject.service;


import uni.sliit.pafproject.externalfunctionalities.RandomIdGenerator;
import uni.sliit.pafproject.model.Post;
import uni.sliit.pafproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository post_repository;
    //CRUD CREATE READ UPDATE DELETE

    public Post addPosts(Post post){

        RandomIdGenerator obj = new RandomIdGenerator();
        String generatedPostId = obj.getGeneratedId("post").toString();

        post.setPostId(generatedPostId);

        if(post.getPostTopic() == null)
            post.setPostTopic("mention your topic..");

        if(post.getPostDescription() == null)
            post.setPostDescription("mention your description..");



        post.setPostLikeCount(0);
        post.setPostDisLikeCount(0);
        post.setPostNeutralCount(0);

        post.setPostHref("http://localhost:8080/posts");
        post.setPostSelf("http://localhost:8080/posts/" + generatedPostId);

        return post_repository.save(post);
    }
    public List<Post> findAllPosts(){
        return post_repository.findAll();

    }

    public Post getPostByPostId(String postId){
        return post_repository.findById(postId).get();
    }

    public List<Post> getPostByPostUserId(String postUserId){ return post_repository.getsPostByPostUserId(postUserId);}
    public List<Post> getPostByPostTopic(String postTopic){
        return post_repository.findByPostTopic(postTopic);
    }

    public List<Post> getPostByPostLikeCount(int postLikeCount){
        return post_repository.getsPostByLikeCount(postLikeCount);
    }

    public List<Post> getPostByPostDisLikeCount(int postDisLikeCount){
        return post_repository.getsPostByDisLikeCount(postDisLikeCount);
    }

    public List<Post> getPostByPostNeutralCount(int postNeutralCount){
        return post_repository.getsPostByNeutralCount(postNeutralCount);
    }

    public Post updatePostTopicAndDescription(Post postRequest){
        Post existingPost = post_repository.findById(postRequest.getPostId()).get();
        existingPost.setPostTopic(postRequest.getPostTopic());
        existingPost.setPostDescription(postRequest.getPostDescription());
        existingPost.setPostLikeCount(postRequest.getPostLikeCount());
        existingPost.setPostDisLikeCount(postRequest.getPostDisLikeCount());
        existingPost.setPostNeutralCount(postRequest.getPostNeutralCount());
        return post_repository.save(existingPost);
    }

    public String deletePost(String postId){
        post_repository.deleteById(postId);
        return postId + " deleted from database";
    }


}
