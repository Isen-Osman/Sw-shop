package mk.finki.ukim.mk.swshop.service.domain;

import mk.finki.ukim.mk.swshop.model.domain.Card;
import mk.finki.ukim.mk.swshop.model.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CardService {


    List<Product> listAllProductsInShoppingCart(Long cartId);

    Optional<Card> getActiveShoppingCart(String username);

    Optional<Card> addProductToShoppingCart(String username, Long productId);
}

