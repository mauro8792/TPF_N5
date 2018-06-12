package com.UTN.TP_N5.Model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CityTest {

    private City city;
    private Country country;


    @Before
    public void setUP(){
        this.country= new Country("Argentina","Arg");
        this.country.setId((long)1);
        city=new City("Mar del Plata","Mdq",this.country);
    }
    @Test
    public void nameTest(){
        assertEquals("Checking name getter", this.city.getName(), "Mar del Plata");
    }
    @Test
    public void iataTest(){
        assertEquals("Checking iata getter", this.city.getIata(), "Mdq");
    }
}
