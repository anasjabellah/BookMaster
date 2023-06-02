package com.example.bookmaster.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title ;
    private String description ;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;

    public Post(){}

    public Post(Long id, String title, String description, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
    }
}
