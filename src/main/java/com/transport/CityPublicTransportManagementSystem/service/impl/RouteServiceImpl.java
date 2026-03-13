package com.transport.CityPublicTransportManagementSystem.service.impl;

import com.transport.CityPublicTransportManagementSystem.model.Route;
import com.transport.CityPublicTransportManagementSystem.repository.RouteRepository;
import com.transport.CityPublicTransportManagementSystem.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}