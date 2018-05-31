package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCountry;
import com.UTN.TP_N5.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService daoCountry;

    @PostMapping(value = "/")
    public void create(@RequestBody Country nuevo){
        this.daoCountry.guardar(nuevo);
    }

    @DeleteMapping (value = "/{iso}")
    public void deleteCountryForIso(@PathVariable("iso") String iso){
        this.daoCountry.eliminar(iso);
    }

    @GetMapping(value = "/{iso}",produces = "application/json")
    public Country getById(@PathVariable("iso") String iso){
        Country pais = this.daoCountry.getByIso(iso);
        return pais;
    }

    @GetMapping(value = "/")
    public List getAllCountrie(){
        List<Country> countries = this.daoCountry.getAllCountry();
        return countries;
    }
}