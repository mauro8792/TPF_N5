package com.UTN.TP_N5.Model;

import com.UTN.TP_N5.dto.PriceDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.*;
@SpringBootTest
public class RouteXCabinTest {

    private RouteXCabin rxc;
    private Country country;
    private City city;
    private Cabin cabin;
    private Airport airport;
    private Price price;
    private Routes route;

    @Before
    public void setUp(){
        this.country = new Country("Argentina","AR");
        this.city = new City("Mardel","MDQ",this.country);
        this.cabin = new Cabin((long)3,"Economica");
        this.airport = new Airport("Pistarini","MDQ",this.city,(float)11.21,(float)23.21);
        this.route = new Routes(this.airport,this.airport,(float)23.24);
        this.rxc = new RouteXCabin(this.route,this.cabin);
        this.price = new Price((long)2,1400,new Date(),new Date(),this.rxc);
    }

    @Test
    public void routeWithNoData(){
        assertNotNull(this.rxc);
    }

    @Test
    public void routeWithData(){
        assertEquals("Economica",this.rxc.getCabin().getNombre());
        assertEquals("MDQ",this.rxc.getRoute().getDestination().getIata());
    }

    @Test
    public void creatingDTO(){
        PriceDTO priceDTO = new PriceDTO(this.price);
        assertEquals(this.cabin.getNombre(),priceDTO.getCabin().getNombre());
        assertEquals(this.airport.getNombre(),priceDTO.getRoute().getDestination().getNombre());
        assertEquals(this.city.getName(),priceDTO.getRoute().getDestination().getCiudad().getName());
    }
}