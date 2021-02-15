package pl.bendyk.model.coffee;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

/*
 * tu podobny problem jak w Method, będą tu tylko dwie instancje: ARABICA, ROBUSTA
 * ale czasami - w przypadku niektórych blendów - będą występowały naraz, więc problem kolekcji enumów
 * */