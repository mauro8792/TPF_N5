package com.UTN.TP_N5.Controller;

import com.ModelsTP5.Model.Airport;
import com.ModelsTP5.Model.City;
import com.UTN.TP_N5.Repository.DaoAirport;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.Services.AirportService;
import com.UTN.TP_N5.Services.CityService;
import com.ModelsTP5.dto.AirportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService daoAirport;
    @Autowired
    private CityService daoCity;

    public AirportController(AirportService service, CityService cityService){
        this.daoAirport = service;
        this.daoCity = cityService;
    }
    @GetMapping(value = "/",produces = "application/json")
    public List getAllAirports(){
        List <Airport> airports = this.daoAirport.getAllAirports();
        List <AirportDTO> airportDTOS = new ArrayList<>();
        for (Airport airport: airports) {
            AirportDTO airportDTO = new AirportDTO(airport);
            airportDTOS.add(airportDTO);
        }
        return airportDTOS;
    }
    @GetMapping(value = "/{iata}",produces = "application/json")
    public AirportDTO getByIata(@PathVariable("iata") String iata){
        AirportDTO avion = new AirportDTO(this.daoAirport.getByIata(iata));
        return avion;
    }
    @PostMapping(value = "/")
    public boolean create(@RequestBody AirportDTO airport){
        boolean rtn = false;
        City city = daoCity.getByIata(airport.getCiudad().getIata());
        if(city != null){
            Airport airpor = new Airport(airport.getNombre(),airport.getIata(),city,airport.getLatitude(),airport.getLongitud());
            this.daoAirport.guardar(airpor);
            rtn = true;
        }
        return rtn;
    }
    @DeleteMapping(value = "/{iata}")
    public boolean deleteAirportForIata(String name){

        return this.daoAirport.eliminar(name);
    }

    @PutMapping(value = "/{iata}")
    public boolean modifyAirport(@RequestBody AirportDTO airport, @PathVariable String iata){
        airport.setIata(iata);
        return this.daoAirport.modifyAirport(airport);

    }

}
