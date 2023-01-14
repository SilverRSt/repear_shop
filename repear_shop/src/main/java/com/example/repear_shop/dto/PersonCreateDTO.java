package com.example.repear_shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonCreateDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
