package com.transport.CityPublicTransportManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transport.CityPublicTransportManagementSystem.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}