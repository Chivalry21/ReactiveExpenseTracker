package com.chivalrycode.expensetracker.repositories;

import com.chivalrycode.expensetracker.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User,Long> {
    Mono<User> findByUsernameIgnoreCase(String username);
}
