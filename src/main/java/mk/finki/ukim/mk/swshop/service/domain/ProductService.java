package mk.finki.ukim.mk.swshop.service.domain;

import mk.finki.ukim.mk.swshop.model.domain.Card;
import mk.finki.ukim.mk.swshop.model.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long id);

    Optional<Product> update(Long id, Product product);

    Optional<Product> save(Product product);

    void deleteById(Long id);

    void refreshMaterializedView();

}

