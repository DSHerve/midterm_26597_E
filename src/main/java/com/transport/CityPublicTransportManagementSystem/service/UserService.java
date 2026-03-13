package com.transport.CityPublicTransportManagementSystem.service;

import com.transport.CityPublicTransportManagementSystem.model.User;
import org.springframework.data.domain.Page;
import java.util.List;

public interface UserService {

    User saveUser(User user, Long StationId);

    List<User> getAllUsers();

    List<User> getUsersByStationCode(String code);

    List<User> getUsersByStationName(String name);

    // Requirement 3: Pagination and Sorting
    Page<User> getPaginatedAndSortedUsers(int page, int size, String sortBy);

    // Requirement 8: Retrieve Users by Province
    List<User> getUsersByProvinceCodeOrName(String code, String name);
}