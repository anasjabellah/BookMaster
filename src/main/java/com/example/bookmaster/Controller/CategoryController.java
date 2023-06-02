package com.example.bookmaster.Controller;

import com.example.bookmaster.Dto.CategoryDTO;
import com.example.bookmaster.Service.CategoryService;
import com.example.bookmaster.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Categories")
public class CategoryController {

    private final CategoryService categoryService ;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>>  getAllCategories(){
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategory();
        return  ResponseEntity.ok(categoryDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("id") Long id){
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO>  createCategories(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO createCategories = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategories);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CategoryDTO>  updateCategories(@PathVariable("id") Long id ,@RequestBody CategoryDTO categoryDTO){
        CategoryDTO updateCategories = categoryService.updateCategory(id,categoryDTO);
        return ResponseEntity.ok(updateCategories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategories(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
