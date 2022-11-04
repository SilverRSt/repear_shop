package com.example.repear_shop.data.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Visit {
    @Id
    @Column(name = "visit_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long visitId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private MV clientId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    private LocalDate date;

    private Double price;


    public Visit() {
    }

    public Visit(Long visitId) {
        this.visitId = visitId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public MV getClientId() {
        return clientId;
    }

    public void setClientId(MV clientId) {
        this.clientId = clientId;
    }
}
