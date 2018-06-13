package com.UTN.TP_N5.Model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class RouteTest {
    private Routes routes;
    private Airport origin;
    private Airport destination;
    private Country paisOrigen;
    private City ciudadOrigen;
    private Country paisDestino;
    private City ciudadDestino;

    @Before
    public void setUp(){
        this.paisOrigen = new Country("Argentina","ARG");
        this.paisOrigen.setId((long)1);
        this.ciudadOrigen = new City("MDQ","MDQ",this.paisOrigen);
        this.ciudadOrigen.setId((long)1);
        this.origin = new Airport("Pistarini","MDQ",this.ciudadOrigen,(float)11.11,(float)12.3);
        this.origin.setId((long)1);

        this.paisDestino = new Country("Brasil","BRA");
        this.paisDestino.setId((long)2);
        this.ciudadDestino = new City("Rio de Janeiro","RIO",this.paisDestino);
        this.ciudadDestino.setId((long)2);
        this.destination = new Airport("Rio Janeiro","RIO",this.ciudadDestino,(float)11.11,(float)12.3);
        this.destination.setId((long)2);

        this.routes= new Routes(this.origin,this.destination,520);
        this.routes.setId((long)1);
    }

    @Test
    public void originNameTest(){
        assertEquals("Checking Airport Origin Name getter",this.origin.getNombre(), "Pistarini");
    }
    @Test
    public void originIataTest(){
        assertEquals("Checking Airport Origin Iata getter",this.origin.getIata(), "MDQ");
    }



}
