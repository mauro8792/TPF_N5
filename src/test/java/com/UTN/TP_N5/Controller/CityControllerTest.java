package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Services.CityService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CityControllerTest {
    private CityService cityService;
    private CityController cityController;
    private City city;
    private Country country;

    @Before
    public void setUp(){
        this.cityService=mock(CityService.class);
        this.cityController= new CityController(this.cityService);
        this.country = new Country("Argentina","ARG");
        this.city= new City("Mar del Plata","MDP",this.country);
        when(this.cityService.getAllCity()).thenReturn(new ArrayList());
        when(this.cityService.getByIata("MDP")).thenReturn(this.city);
    }
    @Test
    public void getAllTest(){
        assertNotNull(this.cityController.getAllCities());
    }
    @Test
    public void getByIataTest(){assertNotNull(this.cityController.getByIata("MDP")); }
}
