package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.SmartCard;
import java.util.List;

public interface SmartCardService {
    SmartCard createSmartCard(SmartCard smartCard, Long userId);
    List<SmartCard> getAllSmartCards();
}