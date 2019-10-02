package com.andrel.parkingsystem.repository;

import com.andrel.parkingsystem.model.UsedSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedSpaceRepository extends JpaRepository<UsedSpace, Long> {
}
