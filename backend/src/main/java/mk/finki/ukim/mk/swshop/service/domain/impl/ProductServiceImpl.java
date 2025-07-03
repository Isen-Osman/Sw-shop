package mk.finki.ukim.mk.swshop.service.domain.impl;

import mk.finki.ukim.mk.swshop.model.domain.Product;
import mk.finki.ukim.mk.swshop.repository.ProductRepository;
import mk.finki.ukim.mk.swshop.service.domain.CategoryService;
import mk.finki.ukim.mk.swshop.service.domain.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);

    }


    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return productRepository.findById(id).map(existingProduct -> {
            if (product.getName() != null) {
                existingProduct.setName(product.getName());
            }
            if (product.getPrice() != null) {
                existingProduct.setPrice(product.getPrice());
            }
            if (product.getQuantity() != null) {
                existingProduct.setQuantity(product.getQuantity());
            }
            if (product.getCategory() != null && categoryService.findById(product.getCategory().getId()).isPresent()) {
                existingProduct.setCategory(categoryService.findById(product.getCategory().getId()).get());
            }

            Product updatedProduct = productRepository.save(existingProduct);

            this.refreshMaterializedView();
            //            this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));

            return updatedProduct;
        });

    }

    @Override
    public Optional<Product> save(Product product) {
        Optional<Product> savedProduct = Optional.empty();

        if (product.getCategory() != null && categoryService.findById(product.getCategory().getId())
                .isPresent())
                {
            savedProduct = Optional.of(productRepository.save(new Product(
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getColor(),
                    product.getGenre(),
                    product.getAvailableSizes(),
                    product.getQuantity(),
                    categoryService.findById(product.getCategory().getId()).get()
            )));
            this.refreshMaterializedView();
            //        this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        }
        return savedProduct;


    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public void refreshMaterializedView() {
        productRepository.flush();
    }
}
