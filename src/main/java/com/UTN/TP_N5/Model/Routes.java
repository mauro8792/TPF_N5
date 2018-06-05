package com.UTN.TP_N5.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Routes")
public class Routes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_route")
    private Long id;

    @OneToOne
    private Airport origin;

    @OneToOne
    private Airport destination;

    @Column(name = "distance")
    private float distance;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "route")
    private List<RouteXCabin> cabinas= new ArrayList<>();

    public Routes(Airport origin, Airport destination,float distance){
        this.destination = destination;
        this.distance = distance;
        this.origin = origin;
    }
}
