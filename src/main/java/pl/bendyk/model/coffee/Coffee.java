package pl.bendyk.model.coffee;

import lombok.Data;
import pl.bendyk.model.others.Country;
import pl.bendyk.model.others.Roastery;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
@Table(name = "coffees")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Min(0)
    private Double price;
    @Column(length = 2000)
    private String description;
    @NotBlank
    private String imageSrc;
    @NotNull
    private Composition composition;
    @NotNull
    @ManyToOne
    private DepulpingProcess depulpingProcess;
    @NotNull
    private Roast roast;
    @NotNull
    @ManyToOne
    private Volume volume;
    @NotEmpty
    @ManyToMany
    private List<Species> species;
    @NotEmpty
    @ManyToMany
    private List<Method> methods;
    @NotNull
    @ManyToOne
    private Roastery roastery;
    @NotNull
    @ManyToOne
    private Country country;
    private boolean active;
    @NotBlank
    private String link;
}