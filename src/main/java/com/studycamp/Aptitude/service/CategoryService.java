package com.studycamp.Aptitude.service;

import com.studycamp.Aptitude.entity.Category;
import com.studycamp.Aptitude.entity.Tag;
import com.studycamp.Aptitude.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<String> getCategoriesByTag(Tag tag) {
        List<Category> categories =  categoryRepository.findAllByTag(tag);
        List<String> categoryNames = new ArrayList<>();
        categories.forEach(category -> {categoryNames.add(category.getName());});
        return categoryNames;
    }


}
