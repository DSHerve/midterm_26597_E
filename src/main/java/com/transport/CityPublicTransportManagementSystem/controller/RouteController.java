package com.transport.CityPublicTransportManagementSystem.controller;

import com.transport.CityPublicTransportManagementSystem.model.Route;
import com.transport.CityPublicTransportManagementSystem.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        return new ResponseEntity<>(routeService.createRoute(route), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }
}