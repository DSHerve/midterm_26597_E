package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.Station;
import java.util.List;

public interface StationService {

    // <-- Updated to require locationId
    Station saveStation(Station station, Long locationId); 

    List<Station> getAllStations();

    Station getStationById(Long id);

    void deleteStation(Long id);
}