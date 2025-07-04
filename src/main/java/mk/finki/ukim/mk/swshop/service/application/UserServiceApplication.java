package mk.finki.ukim.mk.swshop.service.application;

import mk.finki.ukim.mk.swshop.dto.CreateUserDto;
import mk.finki.ukim.mk.swshop.dto.DisplayUserDto;
import mk.finki.ukim.mk.swshop.dto.LoginResponseDto;
import mk.finki.ukim.mk.swshop.dto.LoginUserDto;

import java.util.Optional;

public interface UserServiceApplication {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);

}
