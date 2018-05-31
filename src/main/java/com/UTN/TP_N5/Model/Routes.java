package com.UTN.TP_N5.Model;

import com.UTN.TP_N5.dto.RouteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Routes")
public class Routes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Airport origin;

    @OneToOne
    private Airport destination;

    @Column(name = "distance")
    private float distance;

    public Routes(Airport origin, Airport destination,float distance){
        this.destination = destination;
        this.distance = distance;
        this.origin = origin;
    }
    public Routes(Long id){
        this.id=id;
    }
}
