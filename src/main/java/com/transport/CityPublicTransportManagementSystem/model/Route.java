package com.transport.CityPublicTransportManagementSystem.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore; // <-- Added this import!
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeName;

    private String startPoint;

    private String endPoint;

    // <-- Added @JsonIgnore to break the infinite loop!
    @JsonIgnore 
    @ManyToMany(mappedBy = "routes")
    private List<Bus> buses;

    public Route() {}

    public Long getId() {
        return id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}