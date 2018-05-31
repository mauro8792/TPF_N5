package com.UTN.TP_N5.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Airports")
public class Airport {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_airport")
    private int id;

    @NotBlank
    @Column(name = "name")
    private String nombre;

    @NotBlank
    @Column(name = "iata", unique = true)
    private String iata; //Ejemplo MDQ, EZE, MDZ

    @OneToOne
    private City ciudad;

    @Column(name = "lat")
    @JsonProperty(value = "lat")
    private float lat;

    @Column(name = "longitud")
    @JsonProperty(value = "longitud")
    private float longitud;

    public Airport(String name, String iata, City ciudad, float lat, float longitud){
        this.nombre=name;
        this.iata=iata;
        this.ciudad=ciudad;
        this.lat=lat;
        this.longitud=longitud;

    }
    public Airport(String iata,String name){
        this.nombre=name;
        this.iata = iata;
    }
}
