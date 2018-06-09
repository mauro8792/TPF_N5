package com.UTN.TP_N5.Model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class RouteXCabinTest {

    private RouteXCabin rxc;

    @Before
    public void config(){
        this.rxc = mock(RouteXCabin.class);

    }

    @Test
    public void getRoutesIfExists(){

        assertNotNull(this.rxc.getRoute());
    }



}