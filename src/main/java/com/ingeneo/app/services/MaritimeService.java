package com.ingeneo.app.services;

import com.ingeneo.app.entities.MaritimeEntity;
import com.ingeneo.app.repositories.MaritimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MaritimeService {

    @Autowired
    MaritimeRepository maritimeRepository;

    public List<MaritimeEntity> listAll(){
        return maritimeRepository.findAll();
    }

    public Optional<MaritimeEntity> findById(int id){
        return maritimeRepository.findById(id);
    }

    public MaritimeEntity saveMaritime(MaritimeEntity maritime){
        return maritimeRepository.save(maritime);
    }

    public void deleteMaritime(int id){
        maritimeRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return maritimeRepository.existsById(id);
    }

}