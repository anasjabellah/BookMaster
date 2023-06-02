package com.example.bookmaster.Service;

import com.example.bookmaster.Dto.BookDTO;
import com.example.bookmaster.Dto.CategoryDTO;
import com.example.bookmaster.model.Category;

import java.util.List;

public interface CategoryService {


    List<CategoryDTO> getAllCategory();

    CategoryDTO getCategoryById(Long id);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    void deleteCategory(Long id);

}
