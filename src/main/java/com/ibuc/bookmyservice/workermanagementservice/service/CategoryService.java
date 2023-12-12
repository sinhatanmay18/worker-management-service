package com.ibuc.bookmyservice.workermanagementservice.service;


import com.ibuc.bookmyservice.workermanagementservice.dao.CategoryEntityDao;
import com.ibuc.bookmyservice.workermanagementservice.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryEntityDao categoryEntityDao;
    public List<Category> saveCategory(List<Category> categories) throws Exception {
        return this.categoryEntityDao.saveAllCategories(categories);
    }

    public List<Category> showAllCategory() throws Exception {
        return categoryEntityDao.findAllCategories();
    }

    public Category findCategoryById(Long categoryId) throws Exception {
        return categoryEntityDao.findCategoryById(categoryId);
    }

}
