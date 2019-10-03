package com.andrel.parkingsystem.controller;

import com.andrel.parkingsystem.model.ParkingSpace;
import com.andrel.parkingsystem.service.support.IParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parking")
public class ParkingSpaceController {

    private IParkingSpaceService parkingSpaceService;

    @Autowired
    public ParkingSpaceController(IParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping("busyFalse/count")
    public Integer countAllByBusyFalse() {
        return this.parkingSpaceService.countAllByBusyFalse();
    }

    @ResponseBody
    @GetMapping("busyFalse/positions")
    public List<String> findAllPositionsByBusyFalse() {
        return this.parkingSpaceService.findAllPositionsByBusyFalse();
    }

    @GetMapping
    public List<ParkingSpace> findAll() {
        return this.parkingSpaceService.findAll();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Optional<ParkingSpace> findById(@PathVariable("id") Long id) {
        return this.parkingSpaceService.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public ParkingSpace create(@RequestBody ParkingSpace parkingSpace) {
        return this.parkingSpaceService.create(parkingSpace);
    }

    @PutMapping("{id}")
    @ResponseBody
    public Optional<ParkingSpace> updateById(@PathVariable("id") Long id, @RequestBody ParkingSpace parkingSpace) {
        return this.parkingSpaceService.updateById(id, parkingSpace);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.parkingSpaceService.deleteById(id);
    }

    @PutMapping("remove/{id}")
    public void removeById(@PathVariable("id") Long id) {
        this.parkingSpaceService.removeById(id);
    }

    @PutMapping("busy-space/{id}")
    @ResponseBody
    public Optional<ParkingSpace> busySpace(@PathVariable("id") Long id) {
        return this.parkingSpaceService.busySpaceById(id);
    }
}
