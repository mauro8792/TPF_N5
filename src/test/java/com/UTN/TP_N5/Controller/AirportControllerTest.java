package com.UTN.TP_N5.Controller;
import com.ModelsTP5.Model.Airport;
import com.ModelsTP5.Model.City;
import com.ModelsTP5.Model.Country;
import com.ModelsTP5.dto.AirportDTO;
import com.UTN.TP_N5.Services.AirportService;
import com.UTN.TP_N5.Services.CityService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AirportControllerTest {
    private AirportService airportService;
    private CityService cityService;
    private Airport airport;
    private City city;
    private Country country;
    private AirportController airportController;

    @Before
    public void setUp(){
        this.airportService = mock(AirportService.class);
        this.cityService = mock(CityService.class);
        this.airportController = new AirportController(this.airportService, this.cityService);
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

    @Test
    public void createdTest(){
        when(this.cityService.getByIata(this.city.getIata())).thenReturn(this.city);
        boolean rtn = this.airportController.create(new AirportDTO(this.airport));
        assertTrue(rtn);
    }

    @Test
    public void deleteTest(){
        when(this.airportService.eliminar(this.airport.getIata())).thenReturn(true);
        assertTrue(this.airportController.deleteAirportForIata(this.airport.getIata()));
    }

    /*@Test
    public void modifyTest(){
        when(this.airportService.getByIata("MDQ")).thenReturn(this.airport);
        when(this.airportService.modifyAirport(new AirportDTO())).thenReturn(true);
        assertTrue(this.airportController.modifyAirport(new AirportDTO(this.airport),"MDQ"));
    }*/
}
