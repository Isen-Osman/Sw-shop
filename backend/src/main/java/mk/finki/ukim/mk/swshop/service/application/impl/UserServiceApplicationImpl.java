package mk.finki.ukim.mk.swshop.service.application.impl;

import mk.finki.ukim.mk.swshop.dto.CreateUserDto;
import mk.finki.ukim.mk.swshop.dto.DisplayUserDto;
import mk.finki.ukim.mk.swshop.dto.LoginResponseDto;
import mk.finki.ukim.mk.swshop.dto.LoginUserDto;
import mk.finki.ukim.mk.swshop.helpers.JwtHelper;
import mk.finki.ukim.mk.swshop.model.domain.User;
import mk.finki.ukim.mk.swshop.service.application.UserServiceApplication;
import mk.finki.ukim.mk.swshop.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceApplicationImpl implements UserServiceApplication {

    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserServiceApplicationImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }


    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));
    }

    @Override
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        );

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginResponseDto(token));
    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }

}
