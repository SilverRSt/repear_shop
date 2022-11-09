package com.example.repear_shop.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qualificationId;

    private String qualification;

    @ManyToMany
    private List<Employee> employees;

    public Qualification() {
    }
}
