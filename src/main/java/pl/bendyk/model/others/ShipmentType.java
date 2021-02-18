package pl.bendyk.model.others;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipment_types")
public class ShipmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
