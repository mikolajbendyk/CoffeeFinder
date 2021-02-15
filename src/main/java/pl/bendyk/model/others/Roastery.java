package pl.bendyk.model.others;

import lombok.Data;
import pl.bendyk.model.coffee.Coffee;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "roasteries")
public class Roastery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "roastery")
    private List<Coffee> coffees;
    @ManyToMany
    private List<Shipment> shipments;
}
