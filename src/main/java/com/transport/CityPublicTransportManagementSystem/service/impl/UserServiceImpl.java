package com.transport.CityPublicTransportManagementSystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

import com.transport.CityPublicTransportManagementSystem.model.User;
import com.transport.CityPublicTransportManagementSystem.model.Station;
import com.transport.CityPublicTransportManagementSystem.repository.UserRepository;
import com.transport.CityPublicTransportManagementSystem.repository.StationRepository;
import com.transport.CityPublicTransportManagementSystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StationRepository StationRepository;

    // Constructor Injection 
    public UserServiceImpl(UserRepository userRepository,
                           StationRepository StationRepository) {
        this.userRepository = userRepository;
        this.StationRepository = StationRepository;
    }

    @Override
    public User saveUser(User user, Long StationId) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Station Station = StationRepository.findById(StationId)
                .orElseThrow(() -> new RuntimeException("Station not found"));

        user.setStation(Station);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByStationCode(String code) {
        return userRepository.findByStation_StationCode(code);
    }

    @Override
    public List<User> getUsersByStationName(String name) {
        return userRepository.findByStation_StationName(name);
    }

    // Requirement 3: Pagination and Sorting Implementation
    @Override
    public Page<User> getPaginatedAndSortedUsers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return userRepository.findAll(pageable);
    }

    // Requirement 8: Search by Province Implementation
    @Override
    public List<User> getUsersByProvinceCodeOrName(String code, String name) {
        return userRepository.findUsersByProvinceCodeOrName(code, name);
    }
}