package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.Route;
import java.util.List;

public interface RouteService {
    Route createRoute(Route route);
    List<Route> getAllRoutes();
}