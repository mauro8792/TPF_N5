package com.UTN.TP_N5.ServicesTests;

import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCountry;
import com.UTN.TP_N5.Services.CountryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryTest {

    private CountryService countryService;
    private Country country;

    @Before
    public void config(){
        DaoCountry mockDao = mock(DaoCountry.class);
       // when(mockDao.save(this.country));

        this.countryService = new CountryService(mockDao);
        this.country = new Country("Argentina","ARG");
    }

    @Test
    public void saveTest(){
        Boolean res = this.countryService.guardar(this.country);
        assertEquals(java.util.Optional.of(true),res);
    }
    @Test
    public void deleteTest(){
        assertTrue(this.countryService.eliminar(this.country.getIso()));
    }

}
