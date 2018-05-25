package com.UTN.TP_N5.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Prices")
public class Price {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_price")
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "desde")
    private Date date;
}
