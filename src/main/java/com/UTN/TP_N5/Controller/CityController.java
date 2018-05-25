package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/City")
public class CityController {

    @Autowired
    private DaoCity daocity;
    private City ciudad;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public void create(String name, String iata, Country fk){
        City nuevo = new City(name,iata, fk);
        this.daocity.save(nuevo);
    }
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = "application/json")
    public City getById(@PathVariable("id") Long id){
        City ciu = new City();
        ciu = this.daocity.findById(id).get();
        return ciu;
    }
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List getAllAirports(){
        List <City> ciudades = (List<City>) this.daocity.findAll();
        return ciudades;
    }
    @RequestMapping (value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCountryForName(@PathVariable("id") Long id){
        City pais = daocity.findById(id).get();
        daocity.delete(pais);
    }
}
