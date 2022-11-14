package com.example.repear_shop.web.view.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PersonCreateViewModel {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 4, max = 16, message = "Phone number must be 4 to 16 length!")
    private String phoneNumber;
}
