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
@Table(name = "Maritime")
public class MaritimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productType;

    private String productQuantity;
    private Date dateOfRegistration;
    private Date deliveryDate;
    private String deliveryPort;
    private Long shippingPrice;
    private String fleetNumber;
    private String trackingNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private ClientEntity client;
}
