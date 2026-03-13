package com.transport.CityPublicTransportManagementSystem.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore; // <-- Added the import!

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketNumber;

    private double price;

    // <-- Added @JsonIgnore to stop the User-Ticket infinite loop
    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // <-- Added @JsonIgnore to stop the Schedule-Ticket infinite loop
    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}