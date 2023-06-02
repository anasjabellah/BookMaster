package com.example.bookmaster.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Constructors, getters, and setters

    // Constructors
    public Book() {
    }

    public Book(String title, String author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }


}
