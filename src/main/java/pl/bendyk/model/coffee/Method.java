package pl.bendyk.model.coffee;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "methods")
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

/*
najpierw myślałem, żeby zrobić to enumem, bo będzie tylko kilka konkretnych instancji, ale nie wiedziałem,
jak to pogodzić z relacją do wielu, żeby przy jednej kawie mogło być kilka metod

instancje:
DRIP_COFFEE_MAKER
DRIP
AEROPRESS
FRENCHPRESS
MOKKA_POT
ESPRESSO

ewentualnie mogłyby być jeszcze: CHEMEX, V60, DRIP_COFFEE_MAKER, ale zawierają się w POUR_OVER, więc może
bez sensu powielać

* */