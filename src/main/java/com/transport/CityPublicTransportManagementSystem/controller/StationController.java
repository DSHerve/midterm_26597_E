package com.transport.CityPublicTransportManagementSystem.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.transport.CityPublicTransportManagementSystem.model.Station;
import com.transport.CityPublicTransportManagementSystem.service.StationService;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    // <-- Updated the URL mapping and parameters!
    @PostMapping("/location/{locationId}")
    public Station createStation(@RequestBody Station station, @PathVariable Long locationId){
        return stationService.saveStation(station, locationId);
    }

    @GetMapping
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/{id}")
    public Station getStationById(@PathVariable Long id) {
        return stationService.getStationById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
        return "Station deleted successfully";
    }
}