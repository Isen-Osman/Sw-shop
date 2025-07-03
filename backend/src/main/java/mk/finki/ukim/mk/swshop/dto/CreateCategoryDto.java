package mk.finki.ukim.mk.swshop.dto;


import mk.finki.ukim.mk.swshop.model.domain.Category;

public record CreateCategoryDto(String name, String description) {

    public Category toCategory() {
        return new Category(name, description);
    }
}
