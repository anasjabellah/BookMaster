package com.example.bookmaster.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    


    // Constructors
    public Category() {
    }

    public Category(Long id , String name) {
        this.id = id ;
        this.name = name;
    }


}
