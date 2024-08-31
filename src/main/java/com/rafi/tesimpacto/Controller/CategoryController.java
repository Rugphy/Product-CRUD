package com.rafi.tesimpacto.Controller;



import com.rafi.tesimpacto.Entity.Category;
import com.rafi.tesimpacto.Models.CategoryRequest;
import com.rafi.tesimpacto.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> listCategories() {
        return categoryService.listAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return categoryService.saveCategory(category);
    }
}