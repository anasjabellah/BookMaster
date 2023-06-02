package com.example.bookmaster.Service.Implementation;

import com.example.bookmaster.Dto.PostDTO;
import com.example.bookmaster.Repository.CategoryRepository;
import com.example.bookmaster.Repository.PostRepository;
import com.example.bookmaster.Service.PostService;
import com.example.bookmaster.model.Category;
import com.example.bookmaster.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository ;

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> postDTOList = postRepository.findAll();
        return mapPostToDTOs(postDTOList);
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return mapPostToDTO(post);
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Category category = categoryRepository.findById(postDTO.getCategoryId()).orElseThrow();
        Post post = new Post(postDTO.getId(),postDTO.getTitle(), postDTO.getDescription(), category);
        Post createPost = postRepository.save(post);
        return mapPostToDTO(createPost);
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        Post post = postRepository.findById(id).orElseThrow();
        Category category = categoryRepository.findById(postDTO.getCategoryId()).orElseThrow();

        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setCategory(category);

        Post updatedBook = postRepository.save(post);
        return mapPostToDTO(updatedBook);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
    }

    public PostDTO mapPostToDTO(Post post){
        return new PostDTO(post.getId() , post.getTitle() , post.getDescription() , post.getCategory().getId());
    }

    public  List<PostDTO> mapPostToDTOs(List<Post> posts){
        return  posts.stream().map(this::mapPostToDTO).collect(Collectors.toList());
    }
}
