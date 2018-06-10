package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Model.Price;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.Repository.DaoPrice;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceServiceTest {

    private DaoPrice mockDao;
    private Price price;
    private PriceService priceService;

    @Before
    public void config(){
        mockDao = mock(DaoPrice.class);
        when(mockDao.save(this.price)).thenReturn(this.price);
        this.priceService = new PriceService(mockDao);
        this.price = new Price("500","","")
    }



}