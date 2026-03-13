package com.transport.CityPublicTransportManagementSystem.controller;

import com.transport.CityPublicTransportManagementSystem.model.SmartCard;
import com.transport.CityPublicTransportManagementSystem.service.SmartCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/smartcards")
public class SmartCardController {

    private final SmartCardService smartCardService;

    public SmartCardController(SmartCardService smartCardService) {
        this.smartCardService = smartCardService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<SmartCard> createSmartCard(@RequestBody SmartCard smartCard, @PathVariable Long userId) {
        return new ResponseEntity<>(smartCardService.createSmartCard(smartCard, userId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SmartCard>> getAllSmartCards() {
        return ResponseEntity.ok(smartCardService.getAllSmartCards());
    }
}