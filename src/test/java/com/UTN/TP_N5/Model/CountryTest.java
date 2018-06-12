package com.UTN.TP_N5.Model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CountryTest {

     Country country;

    @Before
    public void setUP(){
        country=new Country("Argentina","Arg");
    }

    @Test
    public void nameTest(){
        assertEquals("Checking name getter", country.getName(), "Argentina");
    }
    @Test
    public void isoTest() {
        assertEquals("Checking Iso getter" , country.getIso(), "Arg" );
    }
}
