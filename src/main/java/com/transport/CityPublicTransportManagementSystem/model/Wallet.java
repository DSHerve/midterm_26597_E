package com.transport.CityPublicTransportManagementSystem.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore; // <-- Added import

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double balance;

    @JsonIgnore // <-- Added to prevent the 500 Error infinite loop!
    @OneToOne(mappedBy = "wallet")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}