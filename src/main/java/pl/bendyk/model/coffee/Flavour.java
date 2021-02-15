package pl.bendyk.model.coffee;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "flavours")
public class Flavour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
