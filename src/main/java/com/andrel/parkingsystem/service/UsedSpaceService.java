package com.andrel.parkingsystem.service;

import com.andrel.parkingsystem.model.ParkingSpace;
import com.andrel.parkingsystem.model.UsedSpace;
import com.andrel.parkingsystem.repository.ParkingSpaceRepository;
import com.andrel.parkingsystem.repository.UsedSpaceRepository;
import com.andrel.parkingsystem.service.support.IUsedSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsedSpaceService implements IUsedSpaceService {

    private UsedSpaceRepository usedSpaceRepository;
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    public UsedSpaceService(UsedSpaceRepository usedSpaceRepository, ParkingSpaceRepository parkingSpaceRepository) {
        this.usedSpaceRepository = usedSpaceRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    @Override
    public List<UsedSpace> findAll() {
        return this.usedSpaceRepository.findAll();
    }

    @Override
    public Optional<UsedSpace> findById(Long id) {
        return this.usedSpaceRepository.findById(id);
    }

    @Override
    public UsedSpace create(UsedSpace usedSpace) {
        return this.usedSpaceRepository.save(usedSpace);
    }

    @Override
    public UsedSpace createByParkingSpace(ParkingSpace parkingSpace) {
        UsedSpace usedSpace = new UsedSpace(LocalDateTime.now(), parkingSpace);
        return this.usedSpaceRepository.save(usedSpace);
    }

    @Override
    public Optional<UsedSpace> updateById(Long id, UsedSpace usedSpace) {
        return this.usedSpaceRepository.findById(id).map(record -> {
            record.setCheckin(usedSpace.getCheckin());
            record.setCheckout(usedSpace.getCheckout());
            record.setParkingSpace(usedSpace.getParkingSpace());
            record.setValue(usedSpace.getValue());
            record.setUpdatedAt(LocalDateTime.now());
            return this.usedSpaceRepository.save(record);
        });
    }

    @Override
    public void deleteById(Long id) {
        this.usedSpaceRepository.deleteById(id);
    }

    @Override
    public void removeById(Long id) {
        this.usedSpaceRepository.findById(id).map(record -> {
            record.setDeletedAt(LocalDateTime.now());
            return this.usedSpaceRepository.save(record);
        });
    }
}
