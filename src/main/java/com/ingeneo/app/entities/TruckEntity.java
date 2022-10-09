package com.ingeneo.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Truck")
public class TruckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productType;

    private String productQuantity;
    private Date dateOfRegistration;
    private Date deliveryDate;
    private String deliveryWarehouse;
    private Long shippingPrice;
    private String vehiclePlate;
    private String trackingNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private ClientEntity client;

}
