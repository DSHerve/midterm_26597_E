package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.Schedule;
import java.util.List;

public interface ScheduleService {
    // We pass the IDs so the service can securely fetch the real objects
    Schedule createSchedule(Schedule schedule, Long busId, Long routeId);
    List<Schedule> getAllSchedules();
}