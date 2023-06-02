package com.example.bookmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMasterApplication.class, args);
    }

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }

}
