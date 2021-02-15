package pl.bendyk.model.others;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne      //jednokierunkowa
    private City city;
    private String street;
    private String number;
    private String postalCode;
}
