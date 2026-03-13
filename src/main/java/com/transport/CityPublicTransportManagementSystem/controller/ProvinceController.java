package com.transport.CityPublicTransportManagementSystem.controller;

import com.transport.CityPublicTransportManagementSystem.model.Province;
import com.transport.CityPublicTransportManagementSystem.repository.ProvinceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

    private final ProvinceRepository provinceRepository;

    public ProvinceController(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @PostMapping
    public Province createProvince(@RequestBody Province province) {
        return provinceRepository.save(province);
    }

    @GetMapping
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }
}