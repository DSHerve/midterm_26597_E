package com.transport.CityPublicTransportManagementSystem.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.transport.CityPublicTransportManagementSystem.model.Station;
import com.transport.CityPublicTransportManagementSystem.model.Location;
import com.transport.CityPublicTransportManagementSystem.repository.StationRepository;
import com.transport.CityPublicTransportManagementSystem.repository.LocationRepository;
import com.transport.CityPublicTransportManagementSystem.service.StationService;

@Service
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;
    private final LocationRepository locationRepository; // <-- Added this!

    public StationServiceImpl(StationRepository stationRepository, 
                              LocationRepository locationRepository) {
        this.stationRepository = stationRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Station saveStation(Station station, Long locationId) {
        // Fetch the Location (e.g., Nyarugenge)
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        // Link the Station to the Location
        station.setLocation(location);

        return stationRepository.save(station);
    }

    @Override
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @Override
    public Station getStationById(Long id) {
        return stationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found"));
    }

    @Override
    public void deleteStation(Long id) {
        stationRepository.deleteById(id);
    }
}