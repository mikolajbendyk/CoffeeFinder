package pl.bendyk.model.coffee;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "processes")
public class DepulpingProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
