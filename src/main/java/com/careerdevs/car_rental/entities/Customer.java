package com.careerdevs.car_rental.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String carPurchased;

    public Customer(){}

    public Customer(String name, String carPurchased) {
        this.name = name;
        this.carPurchased = carPurchased;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarPurchased() {
        return carPurchased;
    }

    public void setCarPurchased(String carPurchased) {
        this.carPurchased = carPurchased;
    }

}
