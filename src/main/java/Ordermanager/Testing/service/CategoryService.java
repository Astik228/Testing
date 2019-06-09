package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

    Category updateCategory(Category category);

    void deleteAll();

    void deleteCategoryById(Long id);
}
