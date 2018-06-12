package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Services.CityService;
import com.UTN.TP_N5.Services.CountryService;
import com.UTN.TP_N5.dto.CityDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CityControllerTest {
    private CityService cityService;
    private CountryService countryService;
    private CityController cityController;
    private City city;
    private Country country;

    @Before
    public void setUp(){
        this.cityService = mock(CityService.class);
        this.countryService = mock(CountryService.class);
        this.cityController = new CityController(this.cityService,this.countryService);
        this.country = new Country("Argentina","ARG");
        this.city = new City("Mar del Plata","MDP",this.country);
        when(this.cityService.getByIata("MDP")).thenReturn(this.city);
        when(this.countryService.getByIso(this.country.getIso())).thenReturn(this.country);
        when(this.cityService.eliminar("MDP")).thenReturn(true);
    }
    @Test
    public void saveTest(){
        CityDTO city1 = new CityDTO(this.city);
        this.cityController.create(city1);
    }
    @Test
    public void deleteTest(){this.cityController.deleteCityForIata("MDP");}
    @Test
    public void getAllTest(){
        List a = new ArrayList();
        a.add(this.city);
        when(this.cityService.getAllCity()).thenReturn(a);
        assertNotNull(this.cityController.getAllCities());
    }
    @Test
    public void getByIataTest(){assertNotNull(this.cityController.getByIata("MDP")); }
}
