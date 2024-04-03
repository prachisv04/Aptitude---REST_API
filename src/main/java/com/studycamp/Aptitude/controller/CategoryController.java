package com.studycamp.Aptitude.controller;

import com.studycamp.Aptitude.entity.Category;
import com.studycamp.Aptitude.entity.Tag;
import com.studycamp.Aptitude.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/cat")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PostMapping("/saveM")
    public String saveMultipleCategory(@RequestBody List<Category> category){
       category.forEach(cat->categoryService.saveCategory(cat));
        return "Categories added";
    }

    @GetMapping("/tag={tag}")
    public List<String> getCategoriesByTag(@PathVariable Tag tag){
        return categoryService.getCategoriesByTag(tag);
    }

    @GetMapping("/tags")
    public List<String> getAllTags(){
        return Stream.of(Tag.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
