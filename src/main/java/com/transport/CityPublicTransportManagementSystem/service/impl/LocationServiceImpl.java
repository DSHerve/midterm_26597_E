package com.transport.CityPublicTransportManagementSystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.transport.CityPublicTransportManagementSystem.model.Location;
import com.transport.CityPublicTransportManagementSystem.model.Province;
import com.transport.CityPublicTransportManagementSystem.repository.LocationRepository;
import com.transport.CityPublicTransportManagementSystem.repository.ProvinceRepository;
import com.transport.CityPublicTransportManagementSystem.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final ProvinceRepository provinceRepository;

    public LocationServiceImpl(LocationRepository locationRepository,
                               ProvinceRepository provinceRepository) {
        this.locationRepository = locationRepository;
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Location saveLocation(Location location, Long provinceId) {

        // REQUIREMENT 2: Fetch the Province (e.g., Kigali City)
        Province province = provinceRepository.findById(provinceId)
                .orElseThrow(() -> new RuntimeException("Province not found"));

        // Link the Location (e.g., Gasabo) to the Province
        location.setProvince(province);

        return locationRepository.save(location);
    }

    @Override
    public Page<Location> getAllLocations(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return locationRepository.findAll(pageable);
    }
}