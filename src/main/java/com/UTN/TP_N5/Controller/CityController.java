package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.Repository.DaoCountry;
import com.UTN.TP_N5.Services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService daocity;

    @PostMapping(value = "/")
    public void create(@RequestBody City nuevo){
        this.daocity.guardar(nuevo);
    }

    @GetMapping(value = "/{iata}", produces = "application/json")
    public City getByName(@PathVariable("iata") String iata){
        City rtn = this.daocity.getByIata(iata);
        return rtn;
    }
    @GetMapping(value = "/", produces = "application/json")
    public List getAllCities(){
        List <City> ciudades = (List<City>) this.daocity.getAllCity();
        return ciudades;
    }
    @DeleteMapping(value = "/{iata}")
    public void deleteCityForIata(@PathVariable("iata") String iata){
      this.daocity.eliminar(iata);
    }
}
