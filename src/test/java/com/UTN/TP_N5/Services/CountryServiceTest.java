package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCountry;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@SpringBootTest
public class CountryServiceTest {

    private CountryService countryService;
    private Country country;
    private  DaoCountry mockDao;

    @Before
    public void config(){
        mockDao = mock(DaoCountry.class);
       when(mockDao.save(this.country)).thenReturn(this.country);

        this.countryService = new CountryService(mockDao);
        this.country = new Country("Argentina","ARG");
    }

    @Test
    public void goodSaveTest(){
        Boolean res = this.countryService.guardar(this.country);
        assertEquals(Boolean.TRUE,res);
    }

    @Test
    public void wrongSaveTest(){
        when(mockDao.findByIso(this.country.getIso())).thenReturn(this.country);
        Boolean res = this.countryService.guardar(this.country);
        assertEquals(Boolean.FALSE,res);
    }
    @Test
    public void deleteTest(){
        assertTrue(this.countryService.eliminar(this.country.getIso()));
    }

    @Test
    public void getByIsoTest() {
        when(mockDao.findByIso("ARG")).thenReturn(this.country);
        assertNotNull(this.countryService.getByIso("ARG"));
    }
    @Test
    public void getAllCountryTest(){
        when(mockDao.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(this.countryService.getAllCountry());
    }


}
