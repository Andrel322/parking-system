package com.andrel.parkingsystem.controller;

import com.andrel.parkingsystem.model.UsedSpace;
import com.andrel.parkingsystem.service.support.IUsedSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/used-space")
public class UsedSpaceController {

    private IUsedSpaceService usedSpaceService;

    @Autowired
    public UsedSpaceController(IUsedSpaceService usedSpaceService) {
        this.usedSpaceService = usedSpaceService;
    }

    @GetMapping
    public List<UsedSpace> findAll() {
        return this.usedSpaceService.findAll();
    }
}
