package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tax")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "basicSalary")
    private double basicSalary;

    @NotNull
    @Column(name = "houseRent")
    private double houseRent;

    @NotNull
    @Column(name = "medical")
    private double medical;

    @NotNull
    @Column(name = "conveyance")
    private double conveyance;

    @NotNull
    @Column(name = "bonus")
    private double bonus;

    @NotNull
    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = Double.parseDouble(basicSalary);
    }

    public double getHouseRent() {
        return houseRent;
    }

    public void setHouseRent(String houseRent) {
        this.houseRent = Double.parseDouble(houseRent);
    }

    public double getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = Double.parseDouble(medical);
    }

    public double getConveyance() {
        return conveyance;
    }

    public void setConveyance(String conveyance) {
        this.conveyance = Double.parseDouble(conveyance);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = Double.parseDouble(bonus);
    }


}
