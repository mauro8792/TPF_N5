package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoAirport;
import com.UTN.TP_N5.dto.AirportDTO;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
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
        this.airport = new Airport("Pistarini","MDQ",this.city,(float)12.11,(float)11.11);
        this.airport.setId((long)12);
        when(mockDao.findByIata(this.airport.getIata())).thenReturn(this.airport);
    }
    @Test
    public void goodSaveTest(){
        Airport airport1 = new Airport("Ezeiza","EZE",this.city,(float)12.11,(float)11.11);
        Boolean res = this.airportService.guardar(airport1);
        assertEquals(Boolean.TRUE,res);
    }
    @Test
    public void wrongSaveTest(){
        Boolean res = this.airportService.guardar(this.airport);
        assertEquals(Boolean.FALSE,res);
    }
    @Test
    public void deleteTest(){
        assertTrue(this.airportService.eliminar(this.airport.getIata()));
    }

    @Test
    public void getByIataTest() {
        when(mockDao.findByIata(this.airport.getIata())).thenReturn(this.airport);
        assertNotNull(this.airportService.getByIata(this.airport.getIata()));
    }
    @Test
    public void getAllAirportTest(){
        when(mockDao.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(this.airportService.getAllAirports());
    }
    @Test
    public void modifyAirportTest(){
        AirportDTO airportD = new AirportDTO(this.airport);
        assertTrue(this.airportService.modifyAirport(airportD));
    }
}