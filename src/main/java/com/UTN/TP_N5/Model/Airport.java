package com.UTN.TP_N5.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter @Setter @Entity @NoArgsConstructor
@Table(name = "Airports")
public class Airport {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_airport")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String nombre;

    @NotBlank
    @Column(name = "iata", unique = true)
    private String iata; //Ejemplo MDQ, EZE, MDZ

    @OneToOne
    private City ciudad;

    @Column(name = "lat")
    @JsonProperty(value = "latitude")
    private float latitude;

    @Column(name = "longitud")
    @JsonProperty(value = "longitud")
    private float longitud;

    public Airport(String name, String iata, City ciudad, float latitude, float longitud){
        this.nombre=name;
        this.iata=iata;
        this.ciudad=ciudad;
        this.latitude = latitude;
        this.longitud=longitud;

    }
}
