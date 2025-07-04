package mk.finki.ukim.mk.swshop.dto;


import mk.finki.ukim.mk.swshop.model.domain.Category;
import mk.finki.ukim.mk.swshop.model.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayProductDto(
        String name,
        Double price,
        String description,
        String color,
        String genre,
        List<String> availableSizes,
        Integer quantity,
        Category category
) {

    public static DisplayProductDto from(Product product) {
        return new DisplayProductDto(
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getColor(),
                product.getGenre(),
                product.getAvailableSizes(),
                product.getQuantity(),
                product.getCategory()
        );
    }

    public static List<DisplayProductDto> from(List<Product> products) {
        return products.stream().map(DisplayProductDto::from).collect(Collectors.toList());
    }

    public Product toProduct(Category category) {
        return new Product(name, price, description, color, genre, availableSizes, quantity, category);
    }
}
