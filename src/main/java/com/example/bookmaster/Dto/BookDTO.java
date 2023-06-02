package com.example.bookmaster.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Long categoryId;


    public BookDTO() {
    }

    // Constructor with fields
    public BookDTO(Long id, String title, String author, Long categoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.categoryId = categoryId;
    }
}
