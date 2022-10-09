package com.ingeneo.app.controllers;

import com.ingeneo.app.dto.Message;
import com.ingeneo.app.entities.ClientEntity;
import com.ingeneo.app.services.ClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientEntity>> getAll() {
        List<ClientEntity> client = clientService.listAll();
        if(client.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getById(@PathVariable("id") int id) {
        if(!clientService.existsById(id))
            return new ResponseEntity(new Message("This Client not exists"), HttpStatus.NOT_FOUND);
        ClientEntity client = clientService.findById(id).get();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody ClientEntity client){
        if(StringUtils.isBlank(client.getName()))
            return new ResponseEntity(new Message("The Name is required"), HttpStatus.BAD_REQUEST);
        ClientEntity clienNew = new ClientEntity(client.getName());
        clientService.saveClient(client);
        return new ResponseEntity(new Message("Client is created"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!clientService.existsById(id))
            return new ResponseEntity(new Message("This Client not exists"), HttpStatus.NOT_FOUND);
        clientService.deleteClient(id);
        return new ResponseEntity(new Message("Client is deleted"), HttpStatus.OK);
    }

}
