package com.example.bookmaster.Service.Implementation;

import com.example.bookmaster.BookMasterApplication;
import com.example.bookmaster.Dto.BookDTO;
import com.example.bookmaster.Dto.CategoryDTO;
import com.example.bookmaster.Repository.CategoryRepository;
import com.example.bookmaster.Service.CategoryService;
import com.example.bookmaster.model.Book;
import com.example.bookmaster.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return mapCategorysToDTOs(categories);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return mapCategoryToDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category( categoryDTO.getId() , categoryDTO.getName());
        Category categorySave = categoryRepository.save(category);
        return mapCategoryToDTO(categorySave);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new BookMasterApplication.NotFoundException("category not found"));
        category.setName(categoryDTO.getName());
        Category updatedCategory = categoryRepository.save(category);
        return mapCategoryToDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new BookMasterApplication.NotFoundException("category not found"));
        categoryRepository.delete(category);
    }

    private CategoryDTO mapCategoryToDTO(Category category) {
        return new CategoryDTO(category.getId() , category.getName());
    }


    private List<CategoryDTO> mapCategorysToDTOs( List<Category> categories ){
        return categories.stream().map(this::mapCategoryToDTO).collect(Collectors.toList());
    }

}
