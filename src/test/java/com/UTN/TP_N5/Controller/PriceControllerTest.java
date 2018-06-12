package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Price;
import com.UTN.TP_N5.Model.RouteXCabin;
import com.UTN.TP_N5.Services.CabinService;
import com.UTN.TP_N5.Services.PriceService;
import com.UTN.TP_N5.Services.RouteService;
import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceControllerTest {

    private PriceService priceService;
    private PriceController priceController;
    private Price price;

    @Before
    public void setUp(){
        this.price = new Price((long)1,1200,new Date(),new Date(),new RouteXCabin());
        this.priceService = mock(PriceService.class);
        this.priceController = new PriceController(this.priceService);
        when(this.priceService.getAllPrice()).thenReturn(new ArrayList());
        when(this.priceController.getById(this.price.getId())).thenReturn(this.price);
    }
    @Test
    public void getAllTest(){
        assertNotNull(this.priceController.getAll());
    }
    @Test
    public void getByIdTest(){
        assertNotNull(this.priceController.getById((long)1));
    }

}