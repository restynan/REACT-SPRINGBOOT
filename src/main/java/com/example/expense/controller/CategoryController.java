package com.example.expense.controller;

import com.example.expense.model.Category;
import com.example.expense.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> categories(){
       return categoryService.retrieveCategories();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> category(@PathVariable Long id){
       Optional<Category> category=categoryService.retrieveCategory(id);
       return category.map(response->ResponseEntity.ok().body(response))
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    public ResponseEntity <Category> addcategory(@RequestBody Category category) throws URISyntaxException {
       Category result= categoryService.saveCategory(category);
       return ResponseEntity.created(new URI("/api/category/"+ result.getId())).body(result);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity <Category> updatecategory(@RequestBody Category category)  {
        Category result= categoryService.updateCategory(category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();

    }

}
