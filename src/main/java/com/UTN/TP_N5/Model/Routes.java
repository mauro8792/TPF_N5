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
@Table(name = "Routes")
public class Routes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_route")
    private Long id;

    @OneToOne
    private City origin;

    @OneToOne
    private City destination;

    @NotBlank
    @Column(name = "distance")
    private  float distance;

    public Routes (City origin, City destination, float distance){
        this.origin=origin;
        this.destination=destination;
        this.distance=distance;
    }
    public  Routes (Long id){
        this.id=id;
    }
}
