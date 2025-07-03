package mk.finki.ukim.mk.swshop.service.application.impl;

import mk.finki.ukim.mk.swshop.dto.CardDto;
import mk.finki.ukim.mk.swshop.dto.DisplayProductDto;
import mk.finki.ukim.mk.swshop.service.application.CardServiceApplication;
import mk.finki.ukim.mk.swshop.service.domain.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceApplicationImpl implements CardServiceApplication {

  private final CardService cardService;

    public CardServiceApplicationImpl(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public List<DisplayProductDto> listAllProductsInShoppingCart(Long cartId) {
        return DisplayProductDto.from(cardService.listAllProductsInShoppingCart(cartId));
    }

    @Override
    public Optional<CardDto> getActiveShoppingCart(String username) {
        return cardService.getActiveShoppingCart(username).map(CardDto::from);
    }

    @Override
    public Optional<CardDto> addProductToShoppingCart(String username, Long productId) {
        return cardService.addProductToShoppingCart(username,productId).map(CardDto::from);
    }
}
