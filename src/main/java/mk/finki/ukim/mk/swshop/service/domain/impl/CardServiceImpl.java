package mk.finki.ukim.mk.swshop.service.domain.impl;

import mk.finki.ukim.mk.swshop.model.domain.Card;
import mk.finki.ukim.mk.swshop.model.domain.Product;
import mk.finki.ukim.mk.swshop.model.domain.User;
import mk.finki.ukim.mk.swshop.model.enumerations.CardStatus;
import mk.finki.ukim.mk.swshop.repository.CardRepository;
import mk.finki.ukim.mk.swshop.service.domain.CardService;
import mk.finki.ukim.mk.swshop.service.domain.ProductService;
import mk.finki.ukim.mk.swshop.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository shoppingCartRepository;
    private final UserService userService;
    private final ProductService productService;

    public CardServiceImpl(CardRepository shoppingCartRepository, UserService userService, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userService = userService;
        this.productService = productService;
    }


    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if (shoppingCartRepository.findById(cartId).isEmpty())
            throw new IllegalArgumentException();
        return shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public Optional<Card> getActiveShoppingCart(String username) {
        User user = userService.findByUsername(username);

        return Optional.of(shoppingCartRepository.findByUserAndStatus(
                user,
                CardStatus.CREATED
        ).orElseGet(() -> shoppingCartRepository.save(new Card(user))));

    }

    @Override
    public Optional<Card> addProductToShoppingCart(String username, Long productId) {
        if (getActiveShoppingCart(username).isPresent()) {
            Card shoppingCart = getActiveShoppingCart(username).get();

            Product product = productService.findById(productId)
                    .orElseThrow(() -> new IllegalArgumentException());
            if (!shoppingCart.getProducts().stream().filter(i -> i.getId().equals(productId)).toList().isEmpty())
                throw new IllegalArgumentException();
            shoppingCart.getProducts().add(product);
            return Optional.of(shoppingCartRepository.save(shoppingCart));
        }
        return Optional.empty();
    }

}
