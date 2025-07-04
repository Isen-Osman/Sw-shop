package mk.finki.ukim.mk.swshop.service.application;

import mk.finki.ukim.mk.swshop.dto.CreateProductDto;
import mk.finki.ukim.mk.swshop.dto.DisplayProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductServiceApplication {

    Optional<DisplayProductDto> update(Long id, CreateProductDto productDto) ;

    Optional<DisplayProductDto> save(CreateProductDto productDto);

    Optional<DisplayProductDto> findById(Long id);

    List<DisplayProductDto> findAll();
    Page<DisplayProductDto> findAll(Pageable pageable);

    void deleteById(Long id);

}

