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
    public void create(String name, String iso){
        Country nuevo = new Country(name,iso);
        this.daoCountry.save(nuevo);
    }

    @DeleteMapping (value = "/getById/{id}")
    public void deleteCountryForName(@PathVariable("id") Long id){
        Country pais = daoCountry.findById(id).get();
        daoCountry.delete(pais);
    }

    @GetMapping(value = "/delete/{id}",produces = "application/json")
    public Country getById(@PathVariable("id") Long id){
        Country pais = new Country();
        pais = daoCountry.findById(id).get();
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
