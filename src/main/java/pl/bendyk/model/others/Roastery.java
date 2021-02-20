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
    private String city;
}
