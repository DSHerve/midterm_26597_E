package com.transport.CityPublicTransportManagementSystem.service.impl;

import com.transport.CityPublicTransportManagementSystem.model.User;
import com.transport.CityPublicTransportManagementSystem.model.Wallet;
import com.transport.CityPublicTransportManagementSystem.repository.UserRepository;
import com.transport.CityPublicTransportManagementSystem.repository.WalletRepository;
import com.transport.CityPublicTransportManagementSystem.service.WalletService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    public WalletServiceImpl(WalletRepository walletRepository, UserRepository userRepository) {
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Wallet createWallet(Wallet wallet, Long userId) {
        // 1. Save the wallet first to generate its ID
        Wallet savedWallet = walletRepository.save(wallet);

        // 2. Fetch the user and assign the new wallet to them
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        
        user.setWallet(savedWallet);
        userRepository.save(user); // Update the user table with the wallet_id

        return savedWallet;
    }

    @Override
    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }
}