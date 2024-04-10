package com.chivalrycode.expensetracker.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class Token {
    private Long id;
    private String token;
    private boolean isRevoked;
    private boolean isExpired;
    private Long user_id;
}
