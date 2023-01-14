package com.example.repear_shop.web.view.model;

import com.example.repear_shop.data.entity.MV;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonUpdateViewModel {
    //NEED IT FOR THE DAMN MAPPER TO KNOW THAT THE ENTITY EXISTS WITH THIS ID
    private long userId;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 4, max = 16, message = "Phone number must be 4 to 16 length!")
    private String phoneNumber;
    private List<MV> mvList;
}
