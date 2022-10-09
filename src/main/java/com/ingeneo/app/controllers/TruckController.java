package com.ingeneo.app.controllers;


import com.ingeneo.app.dto.Message;
import com.ingeneo.app.entities.TruckEntity;
import com.ingeneo.app.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/truck")
public class TruckController {
    
    @Autowired
    TruckService truckService;

    @GetMapping
    public ResponseEntity<List<TruckEntity>> getAll() {
        List<TruckEntity> client = truckService.listAll();
        if(client.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruckEntity> getById(@PathVariable("id") int id) {
        if(!truckService.existsById(id))
            return new ResponseEntity(new Message("This Truck not exists"), HttpStatus.NOT_FOUND);
        TruckEntity client = truckService.findById(id).get();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody TruckEntity truck){
        truckService.saveTruck(truck);
        return new ResponseEntity(new Message("truck is created"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!truckService.existsById(id))
            return new ResponseEntity(new Message("This Client not exists"), HttpStatus.NOT_FOUND);
        truckService.deleteTruck(id);
        return new ResponseEntity(new Message("truck is deleted"), HttpStatus.OK);
    }
}
