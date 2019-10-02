package com.andrel.parkingsystem.service;

import com.andrel.parkingsystem.model.UsedSpace;
import com.andrel.parkingsystem.repository.UsedSpaceRepository;
import com.andrel.parkingsystem.service.support.IUsedSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsedSpaceService implements IUsedSpaceService {

    private UsedSpaceRepository usedSpaceRepository;

    @Autowired
    public UsedSpaceService(UsedSpaceRepository usedSpaceRepository) {
        this.usedSpaceRepository = usedSpaceRepository;
    }

    @Override
    public List<UsedSpace> findAll() {
        return this.usedSpaceRepository.findAll();
    }
}
