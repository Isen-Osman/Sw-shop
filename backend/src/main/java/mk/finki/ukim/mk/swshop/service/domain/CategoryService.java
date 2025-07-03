package mk.finki.ukim.mk.swshop.service.domain;

import mk.finki.ukim.mk.swshop.model.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Optional<Category> update(Long id, Category category);

    void delete(Long id);

    Optional<Category> save(Category category);
}
