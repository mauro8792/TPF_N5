package com.UTN.TP_N5.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "routes_x_cabins")
public class RouteXCabin {
    @Id
    @GeneratedValue
    @Column(name = "id_Rxc")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_route")
    private Routes route;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_cabin")
    private Cabin cabin;

    @OneToMany(mappedBy = "routeXCabins", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Price> precios = new ArrayList<>();


    public RouteXCabin(Routes route, Cabin cabin){
        this.cabin = cabin;
        this.route = route;
    }
}
