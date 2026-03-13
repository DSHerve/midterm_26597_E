package com.transport.CityPublicTransportManagementSystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;

import com.transport.CityPublicTransportManagementSystem.model.User;
import com.transport.CityPublicTransportManagementSystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{StationId}")
    public User createUser(@RequestBody User user, @PathVariable Long StationId) {
        return userService.saveUser(user, StationId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/Station/code/{code}")
    public List<User> getUsersByStationCode(@PathVariable String code) {
        return userService.getUsersByStationCode(code);
    }

    @GetMapping("/Station/name/{name}")
    public List<User> getUsersByStationName(@PathVariable String name) {
        return userService.getUsersByStationName(name);
    }

    // Requirement 3: Pagination and Sorting Endpoint
    @GetMapping("/paged")
    public Page<User> getUsersPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "fullName") String sortBy) {
            
        return userService.getPaginatedAndSortedUsers(page, size, sortBy);
    }

    // Requirement 8: Retrieve Users by Province Endpoint
    @GetMapping("/province/search")
    public List<User> getUsersByProvince(
            @RequestParam(required = false) String code, 
            @RequestParam(required = false) String name) {
        return userService.getUsersByProvinceCodeOrName(code, name);
    }
}