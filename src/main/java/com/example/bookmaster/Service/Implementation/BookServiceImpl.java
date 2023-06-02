package com.example.bookmaster.Service.Implementation;

import com.example.bookmaster.BookMasterApplication;
import com.example.bookmaster.Dto.BookDTO;
import com.example.bookmaster.Repository.BookRepository;
import com.example.bookmaster.Repository.CategoryRepository;
import com.example.bookmaster.Service.BookService;
import com.example.bookmaster.model.Book;
import com.example.bookmaster.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;




    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return mapBooksToDTOs(books);
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookMasterApplication.NotFoundException("Book not found"));
        return mapBookToDTO(book);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Category category = categoryRepository.findById(bookDTO.getCategoryId())
                .orElseThrow(() -> new BookMasterApplication.NotFoundException("Category not found"));

        Book book = new Book(bookDTO.getTitle(), bookDTO.getAuthor(), category);
        Book savedBook = bookRepository.save(book);
        return mapBookToDTO(savedBook);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookMasterApplication.NotFoundException("Book not found"));
        Category category = categoryRepository.findById(bookDTO.getCategoryId())
                .orElseThrow(() -> new BookMasterApplication.NotFoundException("Category not found"));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(category);

        Book updatedBook = bookRepository.save(book);
        return mapBookToDTO(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookMasterApplication.NotFoundException("Book not found"));
        bookRepository.delete(book);
    }

    // Helper methods to map entities to DTOs
    private BookDTO mapBookToDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory().getId());
    }

    private List<BookDTO> mapBooksToDTOs(List<Book> books) {
        return books.stream()
                .map(this::mapBookToDTO)
                .collect(Collectors.toList());
    }

}
