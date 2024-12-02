package mk.finki.ukim.mk.lab.repository.inMemory;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryCategoryRepository {

    public Category save(Category category) {
        DataHolder.categories.removeIf(e -> e.getName().equals(category.getName()));
        DataHolder.categories.add(category);
        return category;
    }

    public List<Category> findAll() {
        return DataHolder.categories;
    }

    public List<Category> searchCategories(String text){
        return DataHolder.categories.stream()
                .filter(e -> e.getName().contains(text))
                .toList();
    }
}
