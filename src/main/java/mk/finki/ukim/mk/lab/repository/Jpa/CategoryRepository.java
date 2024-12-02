package mk.finki.ukim.mk.lab.repository.Jpa;

import mk.finki.ukim.mk.lab.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    Optional<Category> findCategoriesByName(String name);
}
