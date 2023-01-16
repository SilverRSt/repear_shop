package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MV {
    @Id
    @Column(name = "vin", nullable = false, length = 17)
    private String vin;

    @NotBlank
    @Size(min = 1, max = 8, message = "Registration plate must have between 1 and 8 characters!")
    private String registrationPlate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date cant be future!")
    private LocalDate yearMade;

    @ManyToOne
    @JoinColumn(name = "model")
    private Model model;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person") //only responsible for database name
    private Person person;

    @OneToMany(mappedBy = "clientId")
    @JsonIgnoreProperties({"visits", "users", "roles", "userId", "roleId", "model", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "person", "visits", "services", "repairShops", "serviceId", "vin"})
    private List<Visit> visitList;

    public MV(String vin) {
        this.vin = vin;
    }
}
