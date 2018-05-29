package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private DaoCountry daoCountry;
    private Country country;

    @PostMapping(value = "/")
    public void create(@RequestBody Country nuevo){
        this.daoCountry.save(nuevo);
    }
    @DeleteMapping (value = "/{iso}")
    public void deleteCountryForIso(@PathVariable("iso") String iso){
        Country pais = daoCountry.findByIso(iso);
        daoCountry.delete(pais);
    }
    @GetMapping(value = "/{iso}",produces = "application/json")
    public Country getById(@PathVariable("iso") String iso){
        Country pais = daoCountry.findByIso(iso);
        return pais;
    }
    @GetMapping(value = "/")
    public List getAllCountrie(){
        List <Country> ciudades = (List<Country>) this.daoCountry.findAll();
        return ciudades;
    }

    /*
        falta ahcer el @PutMapping

     */















    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List getAllCountries() {
        List<Country> countries = (List<Country>) this.daoCountry.findAll();
        return countries;
    }
    /*

    */
}
