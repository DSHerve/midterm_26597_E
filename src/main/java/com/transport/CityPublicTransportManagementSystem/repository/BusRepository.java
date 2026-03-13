package com.transport.CityPublicTransportManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transport.CityPublicTransportManagementSystem.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
