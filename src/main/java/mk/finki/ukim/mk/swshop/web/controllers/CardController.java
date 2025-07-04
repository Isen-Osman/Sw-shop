package mk.finki.ukim.mk.swshop.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.swshop.dto.CardDto;
import mk.finki.ukim.mk.swshop.model.domain.User;
import mk.finki.ukim.mk.swshop.service.application.CardServiceApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping-cart")
@Tag(name = "Shopping Cart API", description = "Endpoints for managing the shopping cart")


public class CardController {


    private final CardServiceApplication shoppingCartApplicationService;

    public CardController(CardServiceApplication shoppingCartApplicationService) {
        this.shoppingCartApplicationService = shoppingCartApplicationService;
    }

    @Operation(
            summary = "Get active shopping cart",
            description = "Retrieves the active shopping cart for the logged-in user"
    )
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "Shopping cart retrieved successfully"
            ), @ApiResponse(responseCode = "404", description = "Shopping cart not found")}
    )
    @GetMapping
    public ResponseEntity<CardDto> getActiveShoppingCart(@AuthenticationPrincipal User user) {
        String username = user.getUsername();
        return shoppingCartApplicationService.getActiveShoppingCart(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Add product to shopping cart",
            description = "Adds a product to the shopping cart for the logged-in user"
    )
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200", description = "Product added to shopping cart successfully"
            ), @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ), @ApiResponse(responseCode = "404", description = "Product not found")}
    )
    @PostMapping("/add-product/{id}")
    public ResponseEntity<CardDto> addProductToShoppingCart(
            @PathVariable Long id,
            Authentication authentication
    ) {
        try {
            User user = (User) authentication.getPrincipal();
            return shoppingCartApplicationService.addProductToShoppingCart(user.getUsername(), id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

}

