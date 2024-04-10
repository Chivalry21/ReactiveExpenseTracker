package com.chivalrycode.expensetracker.model;

import com.chivalrycode.expensetracker.enums.Role;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User extends BaseEntity {

    private String name;
    private String username;
    private String password;
    private Role role = Role.ROLE_USER;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }


}