package com.UTN.TP_N5.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Routes")
public class Routes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne
    private City origin;

    @OneToOne
    private City destination;
    private  float distance;
}
