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
    public void create(String name, String iata, Long idP){
        Country pais = this.daoCountry.findById(idP).get();
        City nuevo = new City(name,iata, pais);
        this.daocity.save(nuevo);
    }
    @GetMapping(value = "/getById/{id}", produces = "application/json")
    public City getById(@PathVariable("id") Long id){
        City ciu = this.daocity.findById(id).get();
        return ciu;
    }
    @GetMapping(value = "/getByName/{name}", produces = "aplication/json")
    public City getByName(@PathVariable("name") String name){
        City rtn = daocity.getByName(name);
        //City rtn = daocity.findById(id).get();
        return rtn;
    }
    @GetMapping(value = "/", produces = "application/json")
    public List getAllCities(){
        List <City> ciudades = (List<City>) this.daocity.findAll();
        return ciudades;
    }
    @DeleteMapping (value = "/delete/{id}")
    public void deleteCityId(@PathVariable("id") Long id){
        City ciudad = daocity.findById(id).get();
        daocity.delete(ciudad);
    }
}
