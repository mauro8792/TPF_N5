package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CityServiceTest {

    private DaoCity mockDao;
    private CityService cityService;
    private City ciudad;
    private Country country;

    @Before

    public void config(){
        mockDao = mock(DaoCity.class);
        when(mockDao.save(this.ciudad)).thenReturn(this.ciudad);
        this.country = new Country("Argentina","ARG");
        this.cityService = new CityService(mockDao);
        this.ciudad = new City("Mar del plata","MDQ",this.country);
    }

    @Test
    public void goodSaveTest(){
        Boolean res = this.cityService.guardar(this.ciudad);
        assertEquals(Boolean.TRUE,res);
    }

    @Test
    public void wrongSaveTest(){
        when(mockDao.findByIata(this.ciudad.getIata())).thenReturn(this.ciudad);
        Boolean res = this.cityService.guardar(this.ciudad);
        assertEquals(Boolean.FALSE,res);
    }
    @Test
    public void deleteTest(){
        assertTrue(this.cityService.eliminar(this.ciudad.getIata()));
    }
    @Test
    public void getByIataTest() {
        when(mockDao.findByIata("MDQ")).thenReturn(this.ciudad);
        assertNotNull(this.cityService.getByIata("MDQ"));
    }

    @Test
    public void getAllCityTest(){
        when(mockDao.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(this.cityService.getAllCity());
    }
}