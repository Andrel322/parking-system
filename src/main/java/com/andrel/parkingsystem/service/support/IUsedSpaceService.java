package com.andrel.parkingsystem.service.support;

import com.andrel.parkingsystem.model.UsedSpace;

import java.util.List;

public interface IUsedSpaceService {

    List<UsedSpace> findAll();
}
