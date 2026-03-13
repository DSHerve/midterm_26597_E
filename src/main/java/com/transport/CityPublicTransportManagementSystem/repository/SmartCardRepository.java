package com.transport.CityPublicTransportManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transport.CityPublicTransportManagementSystem.model.SmartCard;

public interface SmartCardRepository extends JpaRepository<SmartCard, Long> {
}
