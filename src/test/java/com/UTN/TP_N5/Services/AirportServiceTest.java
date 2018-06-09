package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoAirport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AirportServiceTest {
    private Airport airport;
    private City city;
    private Country country;
    private AirportService airportService;
    private DaoAirport mockDao;

    @Before
    public void config(){
        this.mockDao = mock(DaoAirport.class);
        when(mockDao.save(this.airport)).thenReturn(this.airport);
        this.airportService = new AirportService(mockDao);
        this.country = new Country("Argentina","ARG");
        this.city = new City("Mar del plata","MDQ",this.country);
        this.airport = new Airport("MDQ","Pistarini",this.city,(float)12.11,(float)11.11);
    }
    @Test
    public void goodSaveTest(){
        Boolean res = this.airportService.guardar(this.airport);
        assertEquals(Boolean.TRUE,res);
    }
    @Test
    public void wrongSaveTest(){
        when(mockDao.findByIata(this.airport.getIata())).thenReturn(this.airport);
        Boolean res = this.airportService.guardar(this.airport);
        assertEquals(Boolean.FALSE,res);
    }
    @Test
    public void deleteTest(){
        assertTrue(this.airportService.eliminar(this.airport.getIata()));
    }

    @Test
    public void getByIataTest() {
        when(mockDao.findByIata("EZE")).thenReturn(this.airport);
        assertNotNull(this.airportService.getByIata("EZE"));
    }
    @Test
    public void getAllAirportTest(){
        when(mockDao.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(this.airportService.getAllAirports());
    }
}