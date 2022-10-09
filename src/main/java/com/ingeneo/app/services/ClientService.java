package com.ingeneo.app.services;

import com.ingeneo.app.entities.ClientEntity;
import com.ingeneo.app.entities.MaritimeEntity;
import com.ingeneo.app.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientEntity> listAll(){
        return clientRepository.findAll();
    }

    public Optional<ClientEntity> findById(int id){
        return clientRepository.findById(id);
    }

    public ClientEntity saveClient(ClientEntity clientEntity){
        return clientRepository.save(clientEntity);
    }

    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return clientRepository.existsById(id);
    }
}
