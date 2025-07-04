package mk.finki.ukim.mk.swshop.repository;

import mk.finki.ukim.mk.swshop.model.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
