package uni.sliit.pafproject.controller;


import uni.sliit.pafproject.model.Post;
import uni.sliit.pafproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService post_service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post){
        return post_service.addPosts(post);
    }
    @GetMapping
    public List<Post> getPosts(){
        return post_service.findAllPosts();

    }
    @GetMapping("/{postId}")
    public Post getPost(@PathVariable String postId){
        return post_service.getPostByPostId(postId);
    }
    @GetMapping("/post_user_id/{postUserId}")
    public List<Post> findPostUsingPostUserID(@PathVariable String postUserId){
        return post_service.getPostByPostUserId(postUserId);
    }
    @GetMapping("/post_topic/{postTopic}")
    public List<Post> findPostUsingPostTopic(@PathVariable String postTopic){
        return post_service.getPostByPostTopic(postTopic);
    }
    @GetMapping("/post_like_count/{postLikeCount}")
    public List<Post> findPostUsingPostLikeCount(@PathVariable int postLikeCount){
        return post_service.getPostByPostLikeCount(postLikeCount);
    }
    @GetMapping("/post_dis_like_count/{postDisLikeCount}")
    public List<Post> findPostUsingPostDisLikeCount(@PathVariable int postDisLikeCount){
        return post_service.getPostByPostDisLikeCount(postDisLikeCount);
    }
    @GetMapping("/post_neutral_count/{postNeutralCount}")
    public List<Post> findPostUsingPostNeutralCount(@PathVariable int postNeutralCount){
        return post_service.getPostByPostNeutralCount(postNeutralCount);
    }

    @PutMapping
    public Post modifyPost(@RequestBody Post post){
        return post_service.updatePostTopicAndDescription(post);

    }
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable String postId){
        return post_service.deletePost(postId);
    }
}
