package com.andrel.parkingsystem.service.support;

import com.andrel.parkingsystem.model.ParkingSpace;
import com.andrel.parkingsystem.model.UsedSpace;

import java.util.List;
import java.util.Optional;

public interface IUsedSpaceService {

    List<UsedSpace> findAll();

    Optional<UsedSpace> findById(Long id);

    UsedSpace create(UsedSpace usedSpace);

    UsedSpace createByParkingSpace(ParkingSpace parkingSpace);

    Optional<UsedSpace> updateById(Long id, UsedSpace usedSpace);

    void deleteById(Long id);

    void removeById(Long id);
}
