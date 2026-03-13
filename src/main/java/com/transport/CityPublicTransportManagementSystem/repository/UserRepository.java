package com.transport.CityPublicTransportManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.transport.CityPublicTransportManagementSystem.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Requirement 7: The existsBy method!
    boolean existsByEmail(String email);
    
    List<User> findByStation_StationCode(String code);

    List<User> findByStation_StationName(String name);
    
    List<User> findByStation_StationCodeOrStation_StationName(String code, String name);

    // Requirement 8: Custom JPQL Query across 4 tables!
    @Query("SELECT u FROM User u WHERE u.station.location.province.provinceCode = :code OR u.station.location.province.provinceName = :name")
    List<User> findUsersByProvinceCodeOrName(@Param("code") String code, @Param("name") String name);
}