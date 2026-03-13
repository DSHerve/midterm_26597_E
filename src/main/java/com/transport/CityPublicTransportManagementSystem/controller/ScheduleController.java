package com.transport.CityPublicTransportManagementSystem.controller;

import com.transport.CityPublicTransportManagementSystem.model.Schedule;
import com.transport.CityPublicTransportManagementSystem.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // Example URL: POST /api/schedules/bus/1/route/2
    @PostMapping("/bus/{busId}/route/{routeId}")
    public ResponseEntity<Schedule> createSchedule(
            @RequestBody Schedule schedule, 
            @PathVariable Long busId, 
            @PathVariable Long routeId) {
            
        Schedule savedSchedule = scheduleService.createSchedule(schedule, busId, routeId);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }
}