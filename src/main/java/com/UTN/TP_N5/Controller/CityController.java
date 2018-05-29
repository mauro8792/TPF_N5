package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.Repository.DaoCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private DaoCity daocity;
    @Autowired
    private DaoCountry daoCountry;

    @PostMapping(value = "/")
    public void create(@RequestBody City nuevo){
        this.daocity.save(nuevo);
    }
    @GetMapping(value = "/{iata}", produces = "application/json")
    public City getByName(@PathVariable("iata") String iata){
        City rtn = this.daocity.findByIata(iata);
        //City rtn = daocity.findById(id).get();
        return rtn;
    }
    @GetMapping(value = "/", produces = "application/json")
    public List getAllCities(){
        List <City> ciudades = (List<City>) this.daocity.findAll();
        return ciudades;
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCityId(@PathVariable("id") Long id){
        City ciudad = daocity.findById(id).get();
        daocity.delete(ciudad);
    }
}
