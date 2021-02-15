package pl.bendyk.model.others;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "producers")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne      //jednokierunkowa
    private Country country;
}
