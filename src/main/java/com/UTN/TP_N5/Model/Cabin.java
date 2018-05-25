package com.UTN.TP_N5.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "Cabins")
public class Cabin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_cabin")
    private int id;

    @NotBlank
    @Column(name = "name")
    private String nombre;
}
