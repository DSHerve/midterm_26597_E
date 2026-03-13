package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.Wallet;
import java.util.List;

public interface WalletService {
    Wallet createWallet(Wallet wallet, Long userId);
    List<Wallet> getAllWallets();
}