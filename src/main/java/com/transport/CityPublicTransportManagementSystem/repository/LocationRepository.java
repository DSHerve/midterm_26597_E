package com.transport.CityPublicTransportManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.transport.CityPublicTransportManagementSystem.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Page<Location> findAll(Pageable pageable);
}