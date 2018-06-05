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
@Table(name = "Countries")
public class Country {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_country")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "iso", unique = true)
    private String iso; //Ejemplo AR,BR,URU

    public Country(String name,String iso){
        this.name=name;
        this.iso=iso;
    }
    public Country(String name){
        this.name=name;
    }
    public Country(Long id){
        this.id=id;
    }

}
