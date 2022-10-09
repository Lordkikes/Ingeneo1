package com.ingeneo.app.repositories;

import com.ingeneo.app.entities.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<TruckEntity, Integer> {

}
