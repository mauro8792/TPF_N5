package com.UTN.TP_N5.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Cities")
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_city")
    private Long id;

    @NotBlank
    @Column(name = "iata", unique = true)
    private String iata; //Ejemplo MDQ, EZE,

    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_id_country")
    private Country fk;

    public City(String Name, String Iata, Country fk){
        this.name=Name;
        this.iata=Iata;
        this.fk=fk;
    }
    public City(Long Id){
        this.id=Id;
    }
}
