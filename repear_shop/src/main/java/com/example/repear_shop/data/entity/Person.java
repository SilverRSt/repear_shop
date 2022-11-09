package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 4, max = 16, message = "Phone number must be 4 to 16 length!")
    private String phoneNumber;

    @OneToMany(mappedBy = "person")
    @JsonIgnoreProperties({"model", "person", "brand", "clientId", "qualificationId", "visitId", "clientId", "visitId"})
    private List<MV> mvList;

    public Person(long id) {
        this.id = id;
    }
}
