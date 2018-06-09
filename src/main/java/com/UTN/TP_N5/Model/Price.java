package com.UTN.TP_N5.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@RequiredArgsConstructor

@Table(name = "Prices")
public class Price {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_price")
    private Long id;

    @Column(name = "price")
    private int price;

    @Column(name = "desde")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date desde;

    @OneToOne
    private RouteXCabin routeXCabins;
}
