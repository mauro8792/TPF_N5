package com.UTN.TP_N5.Controller;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Services.CountryService;
import com.UTN.TP_N5.dto.CountryDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
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
        when(this.countryService.getAllCountry()).thenReturn(new ArrayList());
        when(this.countryService.getByIso("ARG")).thenReturn(this.country);
    }
    @Test
    public void getAllTest(){
        assertNotNull(this.countryController.getAllCountrie());
    }
    @Test
    public void getByIsoTest(){assertNotNull(this.countryController.getByIso("ARG")); }
}
