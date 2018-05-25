package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Repository.DaoAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private DaoAirport daoAirport;


    private Airport airport;


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
    public void create(String name, String iata, City fk, float lat, float longitud){
        Airport nuevo = new Airport(name,iata,fk,lat,longitud);
        this.daoAirport.save(nuevo);
    }
    @DeleteMapping(value = "/{name}")
    public void deleteAirportForName(String name){
        Airport airport = new Airport(name);
        this.daoAirport.delete(airport);
    }






}
