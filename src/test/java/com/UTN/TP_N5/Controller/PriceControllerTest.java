package com.UTN.TP_N5.Controller;

import com.ModelsTP5.Model.*;
import com.UTN.TP_N5.Services.CabinService;
import com.UTN.TP_N5.Services.PriceService;
import com.UTN.TP_N5.Services.RouteService;
import static org.mockito.Mockito.mock;

import com.ModelsTP5.dto.PriceInDTO;
import org.apache.tomcat.jni.Local;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceControllerTest {

    private PriceService priceService;
    private CabinService cabinService;
    private RouteService routeService;
    private PriceController priceController;
    private Price price;
    private Routes route;
    private Country pais;
    private City city;
    private Airport origin;
    private Airport destination;
    private RouteXCabin rxc;
    private Cabin cabin;

    @Before
    public void setUp(){
        LocalDate fecha = LocalDate.parse("2018-06-01");
        this.pais = new Country("Argentina","ARG");
        this.city = new City("Mar del plata","MDQ",this.pais);
        this.origin = new Airport("Pistarini","MDQ",this.city,(float)12.11,(float)11.11);
        this.destination= new Airport("Ezeiza","EZE",this.city,(float)12.11,(float)11.11);
        this.route = new Routes(this.origin,this.destination, (float)423.00);
        this.cabin = new Cabin((long)1,"Eco");
        this.rxc = new RouteXCabin(this.route,this.cabin);
        this.price = new Price((long)1,1200,fecha,fecha,new RouteXCabin());
        this.priceService = mock(PriceService.class);
        this.cabinService = mock(CabinService.class);
        this.routeService = mock(RouteService.class);
        this.priceController = new PriceController(this.priceService,this.routeService,this.cabinService);
        when(this.priceService.getAllPrice()).thenReturn(new ArrayList());
        when(this.priceController.getById(this.price.getId())).thenReturn(this.price);
        when(this.cabinService.getCabinID((long)2)).thenReturn(new Cabin());
        when(this.routeService.getById((long)1)).thenReturn(new Routes());
        when(this.priceService.guardar(this.price)).thenReturn(true);
        when(this.routeService.getEspecificRoute("MDQ","EZE")).thenReturn(this.route);
    }
    @Test
    public void saveTest(){
        PriceInDTO priceIn = new PriceInDTO((long)1,(long)2,1200,this.price.getDesde(),this.price.getHasta());
        this.priceController.newPrice(priceIn);
    }
    @Test
    public void getAllTest(){
        assertNotNull(this.priceController.getAll());
    }
    @Test
    public void getByIdTest(){
        assertNotNull(this.priceController.getById((long)1));
    }
    @Test
    public void searchbyRoute() throws ParseException {
        List<Price> b = new ArrayList();
        b.add(this.price);
        this.rxc.setPrecios(b);
        List<RouteXCabin> a =new ArrayList();
        a.add(this.rxc);
        this.route.setCabinas(a);
        assertNotNull(this.priceController.especificRouteandDate("EZE","MDQ","2018-06-02"));
    }

}