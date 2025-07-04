package mk.finki.ukim.mk.swshop.config.init;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.swshop.model.domain.Category;
import mk.finki.ukim.mk.swshop.model.domain.User;
import mk.finki.ukim.mk.swshop.model.enumerations.Role;
import mk.finki.ukim.mk.swshop.repository.CategoryRepository;
import mk.finki.ukim.mk.swshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            CategoryRepository categoryRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


     @PostConstruct
    public void init() {
        categoryRepository.save(new Category("Sports", "Sports categoryId"));
        categoryRepository.save(new Category("Food", "Food categoryId"));
        categoryRepository.save(new Category("Music", "Music categoryId"));



        userRepository.save(new User(
                "is",
                passwordEncoder.encode("at"),
                "Isen",
                "Osman",
                Role.ROLE_ADMIN
        ));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "user",
                "user",
                Role.ROLE_USER
        ));
    }
}

