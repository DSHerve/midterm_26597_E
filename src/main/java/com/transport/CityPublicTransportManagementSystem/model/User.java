package com.transport.CityPublicTransportManagementSystem.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    // Many Users → One Station
    @ManyToOne
    @JoinColumn(name = "station_id") // FIXED: lowercase 's'
    private Station station; // FIXED: Changed from 'Station' to 'station'

    // One User → Many Tickets
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    // One User → One Wallet
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private SmartCard smartCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // FIXED: Updated Getter and Setter to use lowercase 'station'
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public SmartCard getSmartCard() {
        return smartCard;
    }

    public void setSmartCard(SmartCard smartCard) {
        this.smartCard = smartCard;
    }
}