package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Model.Routes;
import com.UTN.TP_N5.Repository.DaoRoute;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RouteServiceTest {

    private DaoRoute mockDao;
    private RouteService routeService;
    private Routes route;
    private Airport origin;
    private Airport destination;
    private City city;
    private Country pais;

    @Before
    public void config(){
        mockDao = mock(DaoRoute.class);
        when(mockDao.save(this.route)).thenReturn(this.route);
        this.pais = new Country("Argentina","ARG");
        this.city = new City("Mar del plata","MDQ",this.pais);

        this.origin = new Airport("MDQ","Pistarini",this.city,(float)12.11,(float)11.11);
        this.destination= new Airport("EZE","Ezieza",this.city,(float)12.11,(float)11.11);


        this.routeService = new RouteService(mockDao);
        this.route = new Routes(this.origin,this.destination, (float)423.00);
    }
    @Test
    public void goodSaveTest(){
        Boolean res = this.routeService.guardar(this.route);
        assertEquals(Boolean.TRUE,res);
    }
    /*
    @Test
    public void wrongSaveTest(){
        when(mockDao.findById(this.route.getId())).thenReturn(this.route);
        Boolean res = this.routeService.guardar(this.route);
        assertEquals(Boolean.FALSE,res);
    }
    @Test
    public void getByIsoTest() {
        when(mockDao.findById(this.route.getId())).thenReturn(this.route);
        assertNotNull(this.routeService.getById(this.route.getId()));
    }
    @Test
    public void getAllCountryTest(){
        when(mockDao.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(this.routeService.getAllRoutes());
    }*/
}