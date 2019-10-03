package com.andrel.parkingsystem.service.support;

import com.andrel.parkingsystem.model.ParkingSpace;

import java.util.List;
import java.util.Optional;

public interface IParkingSpaceService {

    List<ParkingSpace> findAll();

    Optional<ParkingSpace> findById(Long id);

    List<ParkingSpace> findAllByBusyFalse();

    ParkingSpace create(ParkingSpace parkingSpace);

    Optional<ParkingSpace> updateById(Long id, ParkingSpace parkingSpace);

    void deleteById(Long id);

    void removeById(Long id);

    Integer countAllByBusyFalse();

    List<String> findAllPositionsByBusyFalse();

    Optional<ParkingSpace> busySpaceById(Long id);
}
