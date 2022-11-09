package com.example.repear_shop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Visit {
    @Id
    @Column(name = "visit_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private MV clientId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull
    private Double price;

    public Visit(Long visitId) {
        this.visitId = visitId;
    }

}
