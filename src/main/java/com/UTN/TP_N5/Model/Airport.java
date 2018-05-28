package com.UTN.TP_N5.Model;

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
    @Column(name = "iata")
    private String iata; //Ejemplo MDQ, EZE, MDZ

    @OneToOne
    //@JoinColumn(name = "id_city", foreignKey = @ForeignKey(name = "fk_id_city"))
    private City fk;

    @NotBlank
    @Column(name = "lat")
    private float lat;

    @NotBlank
    @Column(name = "longitud")
    private float longitud;




    public Airport(String name, String iata, City fk, float lat, float longitud){
        this.nombre=name;
        this.iata=iata;
        this.fk=fk;
        this.lat=lat;
        this.longitud=longitud;

    }
    public Airport(String name){
        this.nombre=name;
    }
}
