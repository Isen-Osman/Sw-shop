package mk.finki.ukim.mk.swshop.service.application;

import mk.finki.ukim.mk.swshop.dto.CardDto;
import mk.finki.ukim.mk.swshop.dto.DisplayProductDto;
import mk.finki.ukim.mk.swshop.model.domain.Card;

import java.util.List;
import java.util.Optional;

public interface CardServiceApplication {

    List<DisplayProductDto> listAllProductsInShoppingCart(Long cartId);

    Optional<CardDto> getActiveShoppingCart(String username);

    Optional<CardDto> addProductToShoppingCart(String username, Long productId);
}


