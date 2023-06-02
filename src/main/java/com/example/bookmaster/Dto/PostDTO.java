package com.example.bookmaster.Dto;

import com.example.bookmaster.model.Category;
import lombok.Data;

@Data
public class PostDTO {

    private Long id;
    private String title ;
    private String description ;
    private Long categoryId;


    public PostDTO() {}

    public PostDTO(Long id, String title, String description, Long categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }

}
