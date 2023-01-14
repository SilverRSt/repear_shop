package com.example.repear_shop.dto;

import com.example.repear_shop.data.entity.MV;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonUpdateDTO {
    private long userId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private List<MV> mvList;

    private String username;
    private String password;
}
