package pl.bendyk.model.others;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}



/*
 * czy tutaj powinny być pola takie jak List<Roastery> - czy takie relacje powinny być dwukierunkowe,
 * czy to bez sensu?
 *
 * czy w ogóle ta klasa (encja) jest potrzebna?
 *  */