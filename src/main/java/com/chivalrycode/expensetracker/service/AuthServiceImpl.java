package com.chivalrycode.expensetracker.service;


import com.chivalrycode.expensetracker.dto.UserDto;
import com.chivalrycode.expensetracker.dto.RegUserDto;
import com.chivalrycode.expensetracker.dto.UserResponseDto;
import com.chivalrycode.expensetracker.enums.Role;
import com.chivalrycode.expensetracker.exception.BadRequestException;
import com.chivalrycode.expensetracker.mapper.UserMapper;
import com.chivalrycode.expensetracker.model.User;
import com.chivalrycode.expensetracker.repositories.TokenRepository;
import com.chivalrycode.expensetracker.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
@Slf4j

public class AuthServiceImpl implements UserService  {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public Mono<UserResponseDto> signUp(RegUserDto userDto) throws BadRequestException {

        Mono<User> userExist = userRepository.findByUsernameIgnoreCase(userDto.getUsername());
        userExist.flatMap(existingUser-> Mono.error(new BadRequestException("User already exists")))
                .switchIfEmpty(createUser(userDto));


        UserResponseDto userResponseDto = new UserResponseDto(userDto.getName(), "Account success");
        return Mono.just(userResponseDto);
    }

    @Override
    public User getUser(UserDto userDto) {
        Mono<User> user = userRepository.findByUsernameIgnoreCase(userDto.username());
        return user.block();

    }
   /* @Override
    public Mono<AuthResponseDto> login(LoginDto loginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.username(),
                            loginDto.password()
                    )
            );
            Mono<User> user = userRepository.findByUsernameIgnoreCase(loginDto.username());
            Optional<User> userOptional = user.blockOptional();
            User u = userOptional.get();
            String jwtToken = jwtService.generateToken(u);
            revokeAllToken(u);
            saveUserToken(u, jwtToken);
            AuthResponseDto authResponseDto = new AuthResponseDto(u.getName(),jwtToken);
            return Mono.just(authResponseDto);

        }catch (AuthenticationException e){
            throw new RuntimeException("User not found with email: " + loginDto.username());
        }
    }

    private Mono<Void> revokeAllToken(User user) {
        List<Token> tokenList = tokenRepository.findAllValidTokenByUser(user.getId());
        if (tokenList.isEmpty()) {
            return Mono.empty();
        }
        for (Token token : tokenList) {
            token.setRevoked(true);
            token.setExpired(true);
            tokenRepository.saveAll(tokenList);
        }
        return Mono.empty();
    }

    private Mono<Token> saveUserToken(User savedUser, String jwtToken) {
        Token token = Token.builder()
                .token(jwtToken)
                .user_id(savedUser.getId())
                .isExpired(false)
                .isRevoked(false)
                .build();
        return tokenRepository.save(token);
    }
    @Override
    public Mono<Void> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return revokeAllToken(user);
    }*/

    public Mono<User> createUser(RegUserDto userDto){
        User user = userMapper.toUser(userDto);
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }
}