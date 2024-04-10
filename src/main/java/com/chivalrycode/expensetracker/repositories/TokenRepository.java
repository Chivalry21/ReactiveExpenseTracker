package com.chivalrycode.expensetracker.repositories;

import com.chivalrycode.expensetracker.model.Token;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TokenRepository extends ReactiveCrudRepository<Token, Long> {

}
