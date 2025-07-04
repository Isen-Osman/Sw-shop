package mk.finki.ukim.mk.swshop.dto;

import mk.finki.ukim.mk.swshop.model.domain.Card;
import mk.finki.ukim.mk.swshop.model.enumerations.CardStatus;

import java.time.LocalDateTime;
import java.util.List;

public record CardDto(
        Long id,
        LocalDateTime dateCreated,
        DisplayUserDto user,
        List<DisplayProductDto> products,
        CardStatus status
) {

    public static CardDto from(Card shoppingCart) {
        return new CardDto(
                shoppingCart.getId(),
                shoppingCart.getDateCreated(),
                DisplayUserDto.from(shoppingCart.getUser()),
                DisplayProductDto.from(shoppingCart.getProducts()),
                shoppingCart.getStatus()
        );
    }

}

