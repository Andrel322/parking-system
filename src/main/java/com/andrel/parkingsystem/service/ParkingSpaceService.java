package com.andrel.parkingsystem.service;

import com.andrel.parkingsystem.model.ParkingSpace;
import com.andrel.parkingsystem.repository.ParkingSpaceRepository;
import com.andrel.parkingsystem.service.support.IParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingSpaceService implements IParkingSpaceService {

    private ParkingSpaceRepository parkingSpaceRepository;
    private UsedSpaceService usedSpaceService;

    @Autowired
    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository, UsedSpaceService usedSpaceService) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.usedSpaceService = usedSpaceService;
    }

    @Override
    public List<ParkingSpace> findAll() {
        return this.parkingSpaceRepository.findAll();
    }

    @Override
    public Optional<ParkingSpace> findById(Long id) {
        return this.parkingSpaceRepository.findById(id);
    }

    @Override
    public List<ParkingSpace> findAllByBusyFalse() {
        return this.parkingSpaceRepository.findAllByBusyFalse();
    }

    @Override
    public ParkingSpace create(ParkingSpace parkingSpace) {
        return this.parkingSpaceRepository.save(parkingSpace);
    }

    @Override
    public Optional<ParkingSpace> updateById(Long id, ParkingSpace parkingSpace) {
        return this.parkingSpaceRepository.findById(id).map(record -> {
            record.setPosition(parkingSpace.getPosition());
            record.setBusy(parkingSpace.getBusy());
            record.setUpdatedAt(LocalDateTime.now());
            return this.parkingSpaceRepository.save(record);
        });
    }

    @Override
    public void deleteById(Long id) {
        this.parkingSpaceRepository.deleteById(id);
    }

    @Override
    public void removeById(Long id) {
        this.parkingSpaceRepository.findById(id).map(record -> {
            record.setDeletedAt(LocalDateTime.now());
            return this.parkingSpaceRepository.save(record);
        });
    }

    @Override
    public Integer countAllByBusyFalse() {
        return this.parkingSpaceRepository.findAllByBusyFalse().size();
    }

    @Override
    public List<String> findAllPositionsByBusyFalse() {
        return this.parkingSpaceRepository.findAllByBusyFalse().stream().map(ParkingSpace::getPosition).collect(Collectors.toList());
    }

    public Optional<ParkingSpace> busySpaceById(Long id) {
        Optional<ParkingSpace> parkingSpace = this.parkingSpaceRepository.findById(id).map(record -> {
            record.setBusy(true);
            return this.parkingSpaceRepository.save(record);
        });

        parkingSpace.ifPresent(space -> this.usedSpaceService.createByParkingSpace(space));

        return parkingSpace;
    }
}
