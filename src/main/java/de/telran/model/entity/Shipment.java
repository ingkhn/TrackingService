package de.telran.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;

    private String title;

    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "shipmentId")
    private List<Status> statuses;
}
