package pl.bendyk.model.coffee;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "volumes")
public class Volume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
}
