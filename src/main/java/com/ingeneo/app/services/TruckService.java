package com.ingeneo.app.services;

import com.ingeneo.app.entities.TruckEntity;
import com.ingeneo.app.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TruckService {

    @Autowired
    TruckRepository truckRepository;

    public List<TruckEntity> listAll(){
        return truckRepository.findAll();
    }

    public Optional<TruckEntity> findById(int id){
        return truckRepository.findById(id);
    }

    public TruckEntity saveTruck(TruckEntity truck){
        return truckRepository.save(truck);
    }

    public void deleteTruck(int id){
        truckRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return truckRepository.existsById(id);
    }

}
