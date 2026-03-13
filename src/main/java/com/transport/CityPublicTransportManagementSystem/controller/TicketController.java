package com.transport.CityPublicTransportManagementSystem.controller;

import com.transport.CityPublicTransportManagementSystem.model.Ticket;
import com.transport.CityPublicTransportManagementSystem.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/user/{userId}/schedule/{scheduleId}")
    public ResponseEntity<Ticket> bookTicket(
            @RequestBody Ticket ticket, 
            @PathVariable Long userId, 
            @PathVariable Long scheduleId) {
            
        Ticket savedTicket = ticketService.bookTicket(ticket, userId, scheduleId);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }
}