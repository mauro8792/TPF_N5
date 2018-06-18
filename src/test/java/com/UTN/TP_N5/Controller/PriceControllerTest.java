package com.UTN.TP_N5.Controller;

import com.ModelsTP5.Model.Cabin;
import com.ModelsTP5.Model.Price;
import com.ModelsTP5.Model.RouteXCabin;
import com.ModelsTP5.Model.Routes;
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

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceControllerTest {

    private PriceService priceService;
    private CabinService cabinService;
    private RouteService routeService;
    private PriceController priceController;
    private Price price;

    @Before
    public void setUp(){
        LocalDate fecha = LocalDate.parse("2018-06-02");
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
    public void searchbyRoute(){

    }

}