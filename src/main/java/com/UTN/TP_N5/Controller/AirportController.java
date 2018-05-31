package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Repository.DaoAirport;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.dto.AirportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.UTN.TP_N5.TpN5Application.modelMapper;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private DaoAirport daoAirport;
    @Autowired
    private DaoCity daoCity;

    @GetMapping(value = "/",produces = "application/json")
    public List getAllAirports(){
        List <AirportDTO> airports = null;//this.daoAirport.findAll();
        return airports;
    }
    @GetMapping(value = "/{iata}",produces = "application/json")
    public AirportDTO getByIata(@PathVariable("iata") String iata){
        AirportDTO avion = new AirportDTO();
        modelMapper.map(this.daoAirport.findByIata(iata),avion);
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
