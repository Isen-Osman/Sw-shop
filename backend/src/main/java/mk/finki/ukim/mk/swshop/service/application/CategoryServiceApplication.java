package mk.finki.ukim.mk.swshop.service.application;

import mk.finki.ukim.mk.swshop.dto.CreateCategoryDto;
import mk.finki.ukim.mk.swshop.dto.DisplayCategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceApplication {


    List<DisplayCategoryDto> findAll();

    Optional<DisplayCategoryDto> findById(Long id);

    Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto category);

    void deleteById(Long id);

    Optional<DisplayCategoryDto> save(CreateCategoryDto createCategoryDto);

}
