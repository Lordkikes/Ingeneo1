package com.ingeneo.app.controllers;

import com.ingeneo.app.dto.Message;
import com.ingeneo.app.entities.MaritimeEntity;
import com.ingeneo.app.services.MaritimeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maritime")
public class MaritimeController {
    
    @Autowired
    MaritimeService maritimeService;

    @GetMapping
    public ResponseEntity<List<MaritimeEntity>> getAll() {
        List<MaritimeEntity> client = maritimeService.listAll();
        if(client.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaritimeEntity> getById(@PathVariable("id") int id) {
        if(!maritimeService.existsById(id))
            return new ResponseEntity(new Message("This Client not exists"), HttpStatus.NOT_FOUND);
        MaritimeEntity client = maritimeService.findById(id).get();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody MaritimeEntity maritime){
        maritimeService.saveMaritime(maritime);
        return new ResponseEntity(new Message("Maritime is created"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!maritimeService.existsById(id))
            return new ResponseEntity(new Message("This Client not exists"), HttpStatus.NOT_FOUND);
        maritimeService.deleteMaritime(id);
        return new ResponseEntity(new Message("Maritime is deleted"), HttpStatus.OK);
    }
}
