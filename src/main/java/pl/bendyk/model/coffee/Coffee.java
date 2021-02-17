package pl.bendyk.model.coffee;

import lombok.Data;
import pl.bendyk.model.others.Country;
import pl.bendyk.model.others.Roastery;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "coffees")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Column(length = 2000)
    private String description;
    private String imagePath;
    private Composition composition;
    private Process process;
    private Double points;
    private Roast roast;
    @ManyToMany
    private List<Volume> volume;
    @ManyToMany
    private List<Species> species;
    @ManyToMany
    private List<Method> methods;
    @ManyToMany
    private List<Flavour> flavours;
    @ManyToOne
    private Roastery roastery;
    @ManyToOne
    private Country country;
    private boolean active;
}
