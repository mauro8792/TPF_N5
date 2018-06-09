package com.UTN.TP_N5.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Prices")
public class Price {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_price")
    private Long id;

    @Column(name = "price")
    private int price;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date desde;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date hasta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Rxc")
    private RouteXCabin routeXCabins;

    public Price(int price, Date desde, Date hasta, RouteXCabin rxc){
        this.price = price;
        this.desde = desde;
        this.hasta = hasta;
        this.routeXCabins = rxc;
    }
}
