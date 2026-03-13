package com.transport.CityPublicTransportManagementSystem.repository;

import com.transport.CityPublicTransportManagementSystem.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}