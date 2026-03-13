package com.transport.CityPublicTransportManagementSystem.service.impl;

import com.transport.CityPublicTransportManagementSystem.model.Bus;
import com.transport.CityPublicTransportManagementSystem.model.Route;
import com.transport.CityPublicTransportManagementSystem.repository.BusRepository;
import com.transport.CityPublicTransportManagementSystem.repository.RouteRepository;
import com.transport.CityPublicTransportManagementSystem.service.BusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;
    private final RouteRepository routeRepository;

    public BusServiceImpl(BusRepository busRepository, RouteRepository routeRepository) {
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public Bus createBus(Bus bus) {
        List<Route> actualRoutes = new ArrayList<>();

        if (bus.getRoutes() != null) {
            for (Route ghostRoute : bus.getRoutes()) {
                Route realRoute = routeRepository.findById(ghostRoute.getId())
                        .orElseThrow(() -> new RuntimeException("Route not found with ID: " + ghostRoute.getId()));
                actualRoutes.add(realRoute);
            }
        }

        bus.setRoutes(actualRoutes);
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
}