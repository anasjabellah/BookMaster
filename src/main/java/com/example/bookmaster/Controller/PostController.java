package com.example.bookmaster.Controller;


import com.example.bookmaster.Dto.PostDTO;
import com.example.bookmaster.Service.PostService;
import com.example.bookmaster.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService ;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPost(){
        List<PostDTO> postDTOList =  postService.getAllPosts();
        return ResponseEntity.ok(postDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable("id") Long id){
        PostDTO postDTO = postService.getPostById(id);
        return ResponseEntity.ok(postDTO);
    }


    @PostMapping
    public ResponseEntity<PostDTO>  createPost(@RequestBody PostDTO postDTO){
        PostDTO createPost = postService.createPost(postDTO);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(createPost);
    }

    @PutMapping("/{id}")
    private ResponseEntity<PostDTO>  updatedPost(@PathVariable("id") Long id , @RequestBody PostDTO postDTO ){
        PostDTO postDTO1 = postService.updatePost(id, postDTO);
        return ResponseEntity.ok(postDTO1);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<PostDTO> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }


}
