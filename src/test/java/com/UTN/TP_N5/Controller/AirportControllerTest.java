package com.UTN.TP_N5.Controller;


import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Services.AirportService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AirportControllerTest {
    private AirportService airportService;
    private Airport airport;
    private City city;
    private Country country;
    private AirportController airportController;

    @Before
    public void setUp(){
        this.airportService = mock(AirportService.class);
        this.airportController = new AirportController(this.airportService);
        this.country = new Country("Argentina","ARG");
        this.city = new City("MDQ","MDQ",this.country);
        this.airport = new Airport("Pistarini","MDQ",this.city,(float)11.11,(float)12.3);
        when(this.airportService.getByIata("MDQ")).thenReturn(this.airport);
    }

    @Test
    public void getAllTest(){
        List<Airport> a = new ArrayList();
        a.add(this.airport);
        when(this.airportService.getAllAirports()).thenReturn(a);
        assertNotNull(this.airportController.getAllAirports());
    }
    @Test
    public void getByIataTest(){
        assertNotNull(this.airportController.getByIata("MDQ"));
    }
}
