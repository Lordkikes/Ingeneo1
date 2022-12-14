package com.ingeneo.app.repositories;

import com.ingeneo.app.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
