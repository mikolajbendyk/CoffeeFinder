package pl.bendyk.model.others;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private ShipmentType shipmentType;
}
