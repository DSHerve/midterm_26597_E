package com.transport.CityPublicTransportManagementSystem.service.impl;

import com.transport.CityPublicTransportManagementSystem.model.SmartCard;
import com.transport.CityPublicTransportManagementSystem.model.User;
import com.transport.CityPublicTransportManagementSystem.repository.SmartCardRepository;
import com.transport.CityPublicTransportManagementSystem.repository.UserRepository;
import com.transport.CityPublicTransportManagementSystem.service.SmartCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartCardServiceImpl implements SmartCardService {

    private final SmartCardRepository smartCardRepository;
    private final UserRepository userRepository;

    public SmartCardServiceImpl(SmartCardRepository smartCardRepository, UserRepository userRepository) {
        this.smartCardRepository = smartCardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SmartCard createSmartCard(SmartCard smartCard, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Note: Assuming your SmartCard.java has a 'setUser' method!
        smartCard.setUser(user); 
        return smartCardRepository.save(smartCard);
    }

    @Override
    public List<SmartCard> getAllSmartCards() {
        return smartCardRepository.findAll();
    }
}