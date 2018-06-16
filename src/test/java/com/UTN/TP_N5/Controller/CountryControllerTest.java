package com.UTN.TP_N5.Controller;
import com.ModelsTP5.Model.Country;
import com.UTN.TP_N5.Services.CountryService;
import com.ModelsTP5.dto.CountryDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CountryControllerTest {
    private CountryService countryService;
    private CountryController countryController;
    private Country country;
    private CountryDTO countryDTO;
    @Before
    public void setUp(){
        this.countryService=mock (CountryService.class);
        this.countryController= new CountryController(this.countryService);
        this.country = new Country("Argentina","ARG");
        when(this.countryService.getByIso("ARG")).thenReturn(this.country);
        when(this.countryService.guardar(this.country)).thenReturn(true);
        when(this.countryService.eliminar("ARG")).thenReturn(true);
    }
    @Test
    public void getAllTest(){
        List a = new ArrayList();
        a.add(this.country);
        when(this.countryService.getAllCountry()).thenReturn(a);
        assertNotNull(this.countryController.getAllCountrie());
    }
    @Test
    public void getByIsoTest(){assertNotNull(this.countryController.getByIso("ARG")); }
    @Test
    public void saveTest(){assertTrue(this.countryController.create(this.country));}
    @Test
    public void deleteTest(){assertTrue(this.countryController.deleteCountryForIso("ARG"));}
}
