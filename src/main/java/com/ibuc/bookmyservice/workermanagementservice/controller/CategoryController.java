package com.ibuc.bookmyservice.workermanagementservice.controller;


import com.ibuc.bookmyservice.workermanagementservice.model.Category;
import com.ibuc.bookmyservice.workermanagementservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/worker-management/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories() throws Exception {
        return categoryService.showAllCategory();
    }
    @GetMapping("/category/{categoryId}")
    public Category fetchCategoryById(@PathVariable("categoryId") Long categoryId) throws Exception {
        return categoryService.findCategoryById(categoryId);
    }
    @PostMapping("/createCategory")
    public List<Category> createCategory(@RequestBody List<Category> categories) throws Exception {
        return categoryService.saveCategory(categories);
    }
}
