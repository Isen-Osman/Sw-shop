package mk.finki.ukim.mk.swshop.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private String genre;

    private String color;

    @ElementCollection
    private List<String> availableSizes;

    private Integer quantity;

    @ManyToOne
    private Category category;


    public Product() {
    }

    public Product(
            String name,
            Double price,
            String description,
            String color,
            String genre,
            List<String> availableSizes,
            Integer quantity,
            Category category
            ) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.color = color;
        this.genre = genre;
        this.availableSizes = availableSizes;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(
            Long id,
            String name,
            Double price,
            String description,
            String color,
            String genre,
            List<String> availableSizes,
            Integer quantity,
            Category category
            ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.genre = genre;
        this.availableSizes = availableSizes;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(List<String> availableSizes) {
        this.availableSizes = availableSizes;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

