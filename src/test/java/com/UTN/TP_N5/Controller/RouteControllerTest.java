package com.UTN.TP_N5.Controller;

import com.ModelsTP5.Model.*;
import com.ModelsTP5.dto.RouteDTO;
import com.UTN.TP_N5.Services.AirportService;
import com.UTN.TP_N5.Services.CabinService;
import com.UTN.TP_N5.Services.RouteService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RouteControllerTest {
    private RouteController routeController;
    private RouteService routeService;
    private AirportService airportService;
    private Routes routes;
    private Airport origin;
    private Airport destination;
    private Country paisOrigen;
    private City ciudadOrigen;
    private Country paisDestino;
    private City ciudadDestino;


    @Before
    public void setUp(){
        this.routeService= mock(RouteService.class);
        this.airportService = mock(AirportService.class);
        this.routeController= new RouteController(this.routeService, this.airportService);

        this.paisOrigen = new Country("Argentina","ARG");
        this.ciudadOrigen = new City("MDQ","MDQ",this.paisOrigen);
        this.origin = new Airport("Pistarini","MDQ",this.ciudadOrigen,(float)11.11,(float)12.3);

        this.paisDestino = new Country("Brasil","BRA");
        this.ciudadDestino = new City("Rio de Janeiro","RIO",this.paisDestino);
        this.destination = new Airport("Rio Janeiro","RIO",this.ciudadDestino,(float)11.11,(float)12.3);

        this.routes= new Routes(this.origin,this.destination,520);
        when(this.routeService.getById((long)1)).thenReturn(this.routes);
        when(this.routeService.eliminar((long)1)).thenReturn(true);
        when(this.routeService.guardar(this.routes)).thenReturn(true);
        when(this.airportService.getByIata("MDQ")).thenReturn(this.origin);
        when(this.airportService.getByIata("RIO")).thenReturn(this.destination);
    }
    @Test
    public void getAllTest(){
        List a = new ArrayList();
        a.add(this.routes);
        when(this.routeService.getAllRoutes()).thenReturn(a);
        assertNotNull(this.routeController.getAllRoutes());
    }
    @Test
    public void getByIdTest(){assertNotNull(this.routeController.getById((long)1)); }
    @Test
    public void deleteTest(){assertTrue(this.routeController.deleteRouteForId((long) 1));}
    @Test
    public void saveTest(){assertFalse(this.routeController.create(new RouteDTO(this.routes)));}
}
