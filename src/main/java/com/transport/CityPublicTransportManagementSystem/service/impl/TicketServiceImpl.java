package com.transport.CityPublicTransportManagementSystem.service.impl;

import com.transport.CityPublicTransportManagementSystem.model.Schedule;
import com.transport.CityPublicTransportManagementSystem.model.Ticket;
import com.transport.CityPublicTransportManagementSystem.model.User;
import com.transport.CityPublicTransportManagementSystem.repository.ScheduleRepository;
import com.transport.CityPublicTransportManagementSystem.repository.TicketRepository;
import com.transport.CityPublicTransportManagementSystem.repository.UserRepository;
import com.transport.CityPublicTransportManagementSystem.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, 
                             UserRepository userRepository, 
                             ScheduleRepository scheduleRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Ticket bookTicket(Ticket ticket, Long userId, Long scheduleId) {
        // 1. Fetch the User
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // 2. Fetch the Schedule
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found with ID: " + scheduleId));

        // 3. Attach them to the Ticket (Assuming your Ticket.java has setUser and setSchedule)
        ticket.setUser(user);
        ticket.setSchedule(schedule);

        // 4. Save the completed ticket
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}