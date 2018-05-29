package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Repository.DaoAirport;
import com.UTN.TP_N5.Repository.DaoCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private DaoAirport daoAirport;

    @Autowired
    private DaoCity daoCity;


    @GetMapping(value = "/",produces = "application/json")
    public List getAllAirports(){
        List <Airport> airports = (List<Airport>) this.daoAirport.findAll();
        return airports;
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public Airport getById(@PathVariable("id") Long id){
        Airport avion = new Airport();
        avion = daoAirport.findById(id).get();
        return avion;
    }


    @PostMapping(value = "/")
    public void create(@RequestBody Airport airport){
        /*City aeroCity = this.daoCity.findById(fk).get();
        Float lati = Float.parseFloat(lat);
        Float longi = Float.parseFloat(longitud);
        Airport nuevo = new Airport(name,iata,aeroCity,lati,longi);*/
        this.daoAirport.save(airport);
    }
    @DeleteMapping(value = "/{name}")
    public void deleteAirportForName(String name){
        Airport airport = new Airport(name);
        this.daoAirport.delete(airport);
    }






}
