package mk.finki.ukim.mk.swshop.repository;


import mk.finki.ukim.mk.swshop.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

