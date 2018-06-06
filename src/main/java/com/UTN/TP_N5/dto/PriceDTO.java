package com.UTN.TP_N5.dto;

import com.UTN.TP_N5.Model.Price;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PriceDTO {
    private RouteDTO route;
    private CabinDTO cabin;
    private int price;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date desde;

    public PriceDTO(Price price){
        this.price = price.getPrice();
        this.desde = price.getDesde();
        this.addCabinAndRoute(price);
    }
    public void addCabinAndRoute(Price price){
        if(price.getRouteXCabins() != null){
            this.cabin = new CabinDTO(price.getRouteXCabins().getCabin().getNombre());
            this.route = new RouteDTO(price.getRouteXCabins().getRoute());
        }
    }
}
