package mk.finki.ukim.mk.swshop.service.application.impl;

import mk.finki.ukim.mk.swshop.dto.CreateCategoryDto;
import mk.finki.ukim.mk.swshop.dto.DisplayCategoryDto;
import mk.finki.ukim.mk.swshop.service.application.CategoryServiceApplication;
import mk.finki.ukim.mk.swshop.service.domain.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceApplicationImpl implements CategoryServiceApplication {

    private final CategoryService categoryService;

    public CategoryServiceApplicationImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public List<DisplayCategoryDto> findAll() {
        return DisplayCategoryDto.from(categoryService.findAll());
    }

    @Override
    public Optional<DisplayCategoryDto> findById(Long id) {
        return categoryService.findById(id).map(DisplayCategoryDto::from);
    }

    @Override
    public Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto category) {
        return categoryService.update(id,category.toCategory()).map(DisplayCategoryDto::from);
    }

    @Override
    public void deleteById(Long id) {
        categoryService.delete(id);
    }

    @Override
    public Optional<DisplayCategoryDto> save(CreateCategoryDto createCategoryDto) {
        return categoryService.save(createCategoryDto.toCategory()).map(DisplayCategoryDto::from);
    }
}
