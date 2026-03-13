package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.Ticket;
import java.util.List;

public interface TicketService {
    Ticket bookTicket(Ticket ticket, Long userId, Long scheduleId);
    List<Ticket> getAllTickets();
}