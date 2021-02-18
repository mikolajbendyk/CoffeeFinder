package pl.bendyk.model.others;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

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
    @ManyToOne
    private ShipmentType shipmentType;
}
