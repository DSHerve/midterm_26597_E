package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.Location;
import org.springframework.data.domain.Page;

public interface LocationService {

    // Linking Location up to Province!
    Location saveLocation(Location location, Long provinceId);

    Page<Location> getAllLocations(int page, int size, String sortBy);
}