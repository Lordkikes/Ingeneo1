package com.ingeneo.app.repositories;

import com.ingeneo.app.entities.MaritimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaritimeRepository extends JpaRepository<MaritimeEntity, Integer> {
}
