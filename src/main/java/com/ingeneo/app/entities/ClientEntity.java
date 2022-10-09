package com.ingeneo.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch =FetchType.LAZY, mappedBy = "client")
    private List<MaritimeEntity> maritime;

    @OneToMany(cascade = CascadeType.ALL, fetch =FetchType.LAZY, mappedBy = "client")
    private List<TruckEntity> truck;

    public ClientEntity(String name) {
        this.name = name;
    }
}
