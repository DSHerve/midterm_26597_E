package com.transport.CityPublicTransportManagementSystem.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore; // <-- Added import

@Entity
@Table(name = "smart_cards") // <-- Added to keep your database clean!
public class SmartCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;

    private double balance;

    @JsonIgnore // <-- Added to prevent the 500 Error infinite loop!
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SmartCard() {}

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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