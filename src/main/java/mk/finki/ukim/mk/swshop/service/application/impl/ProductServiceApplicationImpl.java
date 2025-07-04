package mk.finki.ukim.mk.swshop.service.application.impl;


import mk.finki.ukim.mk.swshop.dto.CreateProductDto;
import mk.finki.ukim.mk.swshop.dto.DisplayProductDto;
import mk.finki.ukim.mk.swshop.model.domain.Category;
import mk.finki.ukim.mk.swshop.service.application.ProductServiceApplication;
import mk.finki.ukim.mk.swshop.service.domain.CategoryService;
import mk.finki.ukim.mk.swshop.service.domain.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceApplicationImpl implements ProductServiceApplication {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductServiceApplicationImpl(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public Optional<DisplayProductDto> update(Long id, CreateProductDto productDto) {
        Optional<Category> category = categoryService.findById(productDto.category().getId());

        return productService.update(id,
                productDto.toProduct(
                        category.orElse(null)
                )).map(DisplayProductDto::from);
    }

    @Override
    public Optional<DisplayProductDto> save(CreateProductDto productDto) {
        Optional<Category> category = categoryService.findById(productDto.category().getId());


        return category.flatMap(value -> productService.save(productDto.toProduct(value)).map(DisplayProductDto::from));


    }

    @Override
    public Optional<DisplayProductDto> findById(Long id) {
        return productService.findById(id).map(DisplayProductDto::from);
    }

    @Override
    public List<DisplayProductDto> findAll() {
        return productService.findAll().stream().map(DisplayProductDto::from).collect(Collectors.toList());
    }

    @Override
    public Page<DisplayProductDto> findAll(Pageable pageable) {
        return productService.findAll(pageable).map(DisplayProductDto::from);
    }

    @Override
    public void deleteById(Long id) {

        productService.deleteById(id);
    }
}
