package com.UTN.TP_N5.Services;

import com.ModelsTP5.Model.Airport;
import com.ModelsTP5.Model.City;
import com.ModelsTP5.Model.Country;
import com.ModelsTP5.Model.Routes;
import com.UTN.TP_N5.Repository.DaoRoute;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        this.origin = new Airport("Pistarini","MDQ",this.city,(float)12.11,(float)11.11);
        this.destination= new Airport("Ezeiza","EZE",this.city,(float)12.11,(float)11.11);


        this.routeService = new RouteService(mockDao);
        this.route = new Routes(this.origin,this.destination, (float)423.00);
        this.route.setId((long)1);
        when(mockDao.findById(this.route.getId())).thenReturn((Optional.of(this.route)));


    }
    @Test
    public void goodSaveTest(){
         Boolean res = this.routeService.guardar(this.route);
        assertEquals(Boolean.TRUE,res);
    }

    @Test
    public void wrongSaveTest(){
        Boolean res = this.routeService.guardar(this.route);
        assertEquals(Boolean.TRUE,res);
    }
    @Test
    public void getByIdTest() {
        assertNotNull(this.routeService.getById(this.route.getId()));
    }
    @Test
    public void getAllIdTest(){
        List a = new ArrayList();
        a.add(this.route);
        when(this.mockDao.findAll()).thenReturn(a);
        assertNotNull(this.routeService.getAllRoutes());
    }
    @Test
    public void goodGetEspecific() {
        List a = new ArrayList();
        a.add(this.route);
        when(this.mockDao.findAll()).thenReturn(a);
        assertNotNull(this.routeService.getEspecificRoute("MDQ","EZE"));
    }
    @Test
        public void delete(){
        assertTrue(this.routeService.eliminar((long)1));
    }
}