package com.UTN.TP_N5.Controller;

import com.ModelsTP5.Model.Country;
import com.UTN.TP_N5.Services.CountryService;
import com.ModelsTP5.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService daoCountry;

    public CountryController(CountryService countryService) {
        this.daoCountry = countryService;
    }

    @PostMapping(value = "/")
    public boolean create(@RequestBody Country nuevo) {
         return this.daoCountry.guardar(nuevo);
    }

    @DeleteMapping (value = "/{iso}")
    public boolean deleteCountryForIso(@PathVariable("iso") String iso) {
        return this.daoCountry.eliminar(iso);
    }

    @GetMapping(value = "/{iso}",produces = "application/json")
    public CountryDTO getByIso(@PathVariable("iso") String iso) {
        CountryDTO pais = new CountryDTO(this.daoCountry.getByIso(iso));
        return pais;
    }

    @GetMapping(value = "/")
    public List getAllCountrie() {
        List<Country> countries = this.daoCountry.getAllCountry();
        List<CountryDTO> countryDTOS = new ArrayList<>();
        for (Country country : countries) {
            CountryDTO countryDTO = new CountryDTO(country);
            countryDTOS.add(countryDTO);
        }
        return countryDTOS;
    }
}