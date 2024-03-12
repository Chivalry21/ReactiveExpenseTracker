package com.chivalrycode.expensetracker.service;


import com.chivalrycode.expensetracker.configuration.JwtService;
import com.chivalrycode.expensetracker.dto.AuthResponseDto;
import com.chivalrycode.expensetracker.dto.LoginDto;
import com.chivalrycode.expensetracker.dto.UserDto;
import com.chivalrycode.expensetracker.dto.UserResponseDto;
import com.chivalrycode.expensetracker.enums.Role;
import com.chivalrycode.expensetracker.mapper.UserMapper;
import com.chivalrycode.expensetracker.model.Token;
import com.chivalrycode.expensetracker.model.User;
import com.chivalrycode.expensetracker.repositories.TokenRepository;
import com.chivalrycode.expensetracker.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.chivalrycode.expensetracker.exception.BadRequestException;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j

public class AuthServiceImpl implements UserService  {

    private final UserRepository userRepository;
    private final HttpServletRequest request;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final TokenRepository tokenRepository;

    @Override
    public ResponseEntity<UserResponseDto> signUp(UserDto userDto) throws BadRequestException {

        if (userRepository.findByUsernameIgnoreCase(userDto.getUsername()).isPresent()) {
            throw new BadRequestException("User already exists");
        }
        User user = userMapper.toUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        User user1 = userRepository.save(user);
        UserResponseDto userResponseDto = new UserResponseDto(user1.getName(), "Account success");
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
    @Override
    public AuthResponseDto login(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.username(),
                        loginDto.password()
                )
        );
        User user = userRepository.findByUsernameIgnoreCase(loginDto.username())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + loginDto.username()));
        String jwtToken = jwtService.generateToken(user);
        revokeAllToken(user);

        saveUserToken(user, jwtToken);
        return new AuthResponseDto(user.getName(), jwtToken);
    }

    private void revokeAllToken(User user) {
        List<Token> tokenList = tokenRepository.findAllValidTokenByUser(user.getId());
        if (tokenList.isEmpty()) {
            return;
        }
        for (Token token : tokenList) {
            token.setRevoked(true);
            token.setExpired(true);
            tokenRepository.saveAll(tokenList);
        }
    }

    private void saveUserToken(User savedUser, String jwtToken) {
        Token token = Token.builder()
                .token(jwtToken)
                .users(savedUser)
                .isExpired(false)
                .isRevoked(false)
                .build();
        tokenRepository.save(token);

    }
    @Override
    public void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        revokeAllToken(user);
    }

}