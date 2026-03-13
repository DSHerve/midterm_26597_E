package com.transport.CityPublicTransportManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transport.CityPublicTransportManagementSystem.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
