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
    @GetMapping(value = "/{iata}",produces = "application/json")
    public Airport getByIata(@PathVariable("iata") String iata){
        Airport avion = daoAirport.findByIata(iata);
        return avion;
    }
    @PostMapping(value = "/")
    public void create(@RequestBody Airport airport){
        this.daoAirport.save(airport);
    }
    @DeleteMapping(value = "/{iata}")
    public void deleteAirportForIata(String name){
        Airport airport = this.daoAirport.findByIata(name);
        this.daoAirport.delete(airport);
    }
}
