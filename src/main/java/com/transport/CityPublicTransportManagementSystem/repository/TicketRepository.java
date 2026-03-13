package com.transport.CityPublicTransportManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transport.CityPublicTransportManagementSystem.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    boolean existsByTicketNumber(String ticketNumber);
}