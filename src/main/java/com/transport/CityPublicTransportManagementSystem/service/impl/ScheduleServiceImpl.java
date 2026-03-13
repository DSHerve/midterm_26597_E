package com.transport.CityPublicTransportManagementSystem.service.impl;

import com.transport.CityPublicTransportManagementSystem.model.Bus;
import com.transport.CityPublicTransportManagementSystem.model.Route;
import com.transport.CityPublicTransportManagementSystem.model.Schedule;
import com.transport.CityPublicTransportManagementSystem.repository.BusRepository;
import com.transport.CityPublicTransportManagementSystem.repository.RouteRepository;
import com.transport.CityPublicTransportManagementSystem.repository.ScheduleRepository;
import com.transport.CityPublicTransportManagementSystem.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final BusRepository busRepository;
    private final RouteRepository routeRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, 
                               BusRepository busRepository, 
                               RouteRepository routeRepository) {
        this.scheduleRepository = scheduleRepository;
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public Schedule createSchedule(Schedule schedule, Long busId, Long routeId) {
        // 1. Fetch the real Bus
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found with ID: " + busId));

        // 2. Fetch the real Route
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Route not found with ID: " + routeId));

        // 3. Attach them to the Schedule
        schedule.setBus(bus);
        schedule.setRoute(route);

        // 4. Save to the database
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
}