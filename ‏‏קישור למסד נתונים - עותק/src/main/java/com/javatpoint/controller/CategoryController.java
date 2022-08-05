package com.javatpoint.controller;

import com.javatpoint.dao.CategoryRepository;
import com.javatpoint.dao.MapStructMapper;
import com.javatpoint.dto.BorrowerDTO;
import com.javatpoint.dto.CategoryDTO;
import com.javatpoint.model.Borrower;
import com.javatpoint.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/category") //חלק מהמרכיב של הכתובת
@RestController//מגדיר את המחלקה להיות קונטרולר
@CrossOrigin
public class CategoryController {

    public final CategoryRepository repository;
    private MapStructMapper mapStructMapper;

    @Autowired//יוצר את התלות- מכניס אובייקט חדש
    public CategoryController(CategoryRepository repository,MapStructMapper mapStructMapper)
    {
        this.repository = repository;
        this.mapStructMapper=mapStructMapper;
    }

    @GetMapping ("/categories/{id}")
    public CategoryDTO getCategoryById(@PathVariable long id)
    {
        return mapStructMapper.categoryToCategoryDto(repository.findById(id).orElse(null));
    }

    @GetMapping("/categories")
    public List<CategoryDTO> all(){

        return mapStructMapper.categoriesToCategoryDtos(repository.findAll());
    }

    @PostMapping("/categories")
    public CategoryDTO addCategory(@RequestBody CategoryDTO c)
    {
        return mapStructMapper.categoryToCategoryDto(repository.save(mapStructMapper.categoryDtoToCategory(c)));
    }

    @PutMapping("/categories/{id}")
    public CategoryDTO updateCategory(@PathVariable long id, @RequestBody CategoryDTO newCategory) {
//        Optional<Category> category = repository.findById(id);
////        if (category.isPresent())//לבדוק אם יש ערך באובייקט
////            category.map(c -> {
////                c.setName(newCategory.getName());
////                c.setDescription(newCategory.getDescription());
////                c.setColor(newCategory.getColor());
////                return repository.save(c);
////            });
////        return null;



        CategoryDTO categoryDTO=repository.findById(id).map(
                cat->{
                    Category c=mapStructMapper.categoryDtoToCategory(newCategory);
                    cat.setId(c.getId());
                    cat.setName(c.getName());
                    cat.setDescription(c.getDescription());
                    cat.setColor(c.getColor());
                    cat.setBooks(c.getBooks());
                    cat.setBorrowers(c.getBorrowers());
                    return  mapStructMapper.categoryToCategoryDto(repository.save(cat));
                }).orElse(null);
        return categoryDTO;
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable long id)
    {
        repository.deleteById(id);
    }
}
