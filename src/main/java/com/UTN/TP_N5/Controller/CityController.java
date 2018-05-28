package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/City")
public class CityController {

    @Autowired
    private DaoCity daocity;
    private City ciudad;

    @PostMapping(value = "/")
    public void create(String name, String iata, Country fk){
        City nuevo = new City(name,iata, fk);
        this.daocity.save(nuevo);
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public City getById(@PathVariable("id") Long id){
        City ciu = this.daocity.findById(id).get();
        return ciu;
    }
    @GetMapping(value = "/")
    public List getAllAirports(){
        List <City> ciudades = (List<City>) this.daocity.findAll();
        return ciudades;
    }
    @DeleteMapping (value = "/{id}")
    public void deleteCountryForName(@PathVariable("id") Long id){
        City pais = daocity.findById(id).get();
        daocity.delete(pais);
    }
}
