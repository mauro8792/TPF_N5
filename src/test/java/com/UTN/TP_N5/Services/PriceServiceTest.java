package com.UTN.TP_N5.Services;

import com.ModelsTP5.Model.City;
import com.ModelsTP5.Model.Country;
import com.ModelsTP5.Model.Price;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.Repository.DaoPrice;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceServiceTest {

    private DaoPrice mockDao;
    private Price price;
    private PriceService priceService;
    private Date desde;
    private Date hasta;


    @Before
    public void config() throws ParseException {
        mockDao = mock(DaoPrice.class);
        when(mockDao.save(this.price)).thenReturn(this.price);

        String fecha="20-05-2018";
        DateFormat fechita= new SimpleDateFormat("dd-MM-yyyy");
        Date inputDate= fechita.parse(fecha);
        this.desde= inputDate;

        String fecha2="20-05-2018";
        DateFormat fechita2= new SimpleDateFormat("dd-MM-yyyy");
        Date inputDate2= fechita2.parse(fecha2);
        this.hasta=inputDate2;

        this.priceService = new PriceService(mockDao);
        this.price = new Price(500,this.desde,this.hasta);
        this.price.setId((long)1);
        when(mockDao.findById((long) 1)).thenReturn(Optional.of(this.price));

    }

    @Test
    public void goodSaveTest(){
        Boolean res = this.priceService.guardar(this.price);
        assertTrue(res);
    }
    @Test
    public void wrongSaveTest(){
        when(mockDao.findById(this.price.getId())).thenReturn(Optional.of(this.price));
        Boolean res = this.priceService.guardar(this.price);
        assertEquals(Boolean.TRUE,res);
    }
    @Test
    public void deleteTest(){
        assertTrue(this.priceService.eliminar(this.price.getId()));
    }
    @Test
    public void getByIdTest() {
        assertNotNull(this.priceService.getById((long) 1));
    }

    @Test
    public void getAllPriceTest(){
        when(mockDao.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(this.priceService.getAllPrice());
    }

}