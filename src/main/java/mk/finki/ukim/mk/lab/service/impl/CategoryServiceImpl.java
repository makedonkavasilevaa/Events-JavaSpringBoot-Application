package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.repository.Jpa.CategoryRepository;
import mk.finki.ukim.mk.lab.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl  implements CategoryService {

     private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> listAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> searchEvents(String text) {
        return this.categoryRepository.findCategoriesByName(text);
    }

    @Override
    public Category save(String name) {
//        Category category = this.categoryRepository.findById(id).orElse(null);
        Category category = new Category(name);
        return this.categoryRepository.save(category);
    }
}
