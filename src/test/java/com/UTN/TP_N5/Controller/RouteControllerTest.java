package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.*;
import com.UTN.TP_N5.Services.CabinService;
import com.UTN.TP_N5.Services.RouteService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RouteControllerTest {
    private RouteController routeController;
    private RouteService routeService;
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
        this.routeController= new RouteController(this.routeService);

        this.paisOrigen = new Country("Argentina","ARG");
        this.ciudadOrigen = new City("MDQ","MDQ",this.paisOrigen);
        this.origin = new Airport("Pistarini","MDQ",this.ciudadOrigen,(float)11.11,(float)12.3);

        this.paisDestino = new Country("Brasil","BRA");
        this.ciudadDestino = new City("Rio de Janeiro","RIO",this.paisDestino);
        this.destination = new Airport("Rio Janeiro","RIO",this.ciudadDestino,(float)11.11,(float)12.3);

        this.routes= new Routes(this.origin,this.destination,520);
        when(this.routeService.getAllRoutes()).thenReturn(new ArrayList());
        when(this.routeService.getById((long)1)).thenReturn(this.routes);
    }
    @Test
    public void getAllTest(){
        assertNotNull(this.routeController.getAllRoutes());
    }
    @Test
    public void getByIdTest(){assertNotNull(this.routeController.getById((long)1)); }

}
