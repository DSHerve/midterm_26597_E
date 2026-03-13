package com.transport.CityPublicTransportManagementSystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import com.transport.CityPublicTransportManagementSystem.model.Location;
import com.transport.CityPublicTransportManagementSystem.service.LocationService;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/province/{provinceId}")
    public Location createLocation(@RequestBody Location location, @PathVariable Long provinceId) {
        return locationService.saveLocation(location, provinceId);
    }

    @GetMapping("/paged")
    public Page<Location> getAllLocations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "locationName") String sortBy) {
        return locationService.getAllLocations(page, size, sortBy);
    }
}