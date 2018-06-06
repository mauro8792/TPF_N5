package com.UTN.TP_N5.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
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

}
