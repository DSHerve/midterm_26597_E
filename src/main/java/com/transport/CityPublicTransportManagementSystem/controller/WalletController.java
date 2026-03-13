package com.transport.CityPublicTransportManagementSystem.controller;

import com.transport.CityPublicTransportManagementSystem.model.Wallet;
import com.transport.CityPublicTransportManagementSystem.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet, @PathVariable Long userId) {
        return new ResponseEntity<>(walletService.createWallet(wallet, userId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Wallet>> getAllWallets() {
        return ResponseEntity.ok(walletService.getAllWallets());
    }
}