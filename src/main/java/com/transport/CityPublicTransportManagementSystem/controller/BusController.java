package com.transport.CityPublicTransportManagementSystem.controller;

import com.transport.CityPublicTransportManagementSystem.model.Bus;
import com.transport.CityPublicTransportManagementSystem.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        return new ResponseEntity<>(busService.createBus(bus), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        return ResponseEntity.ok(busService.getAllBuses());
    }
}