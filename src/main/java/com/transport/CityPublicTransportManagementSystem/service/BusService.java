package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.Bus;
import java.util.List;

public interface BusService {
    Bus createBus(Bus bus);
    List<Bus> getAllBuses();
}