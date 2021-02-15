package pl.bendyk.model.coffee;

import lombok.Data;
import pl.bendyk.model.others.Country;
import pl.bendyk.model.others.Producer;
import pl.bendyk.model.others.Roastery;
import pl.bendyk.model.others.Shipment;

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
    @ManyToMany     //jednokierunkowa
    private List<Species> species;
    @ManyToMany     //jednokierunkowa
    private List<Method> methods;
    @ManyToMany     //jednokierunkowa
    private List<Flavour> flavours;
    @ManyToOne      //dwukierunkowa
    private Roastery roastery;
    @ManyToOne      //jednokierunkowa
    private Country country;
    @ManyToOne      //jednokierunkowa
    private Producer producer;
}

/*
 * Producer zawiera w sobie pole Country, więc jest to pewne powielenie, jednak nie zawsze Producer będzie znany,
 * natomiast Country będzie zawsze
 * */