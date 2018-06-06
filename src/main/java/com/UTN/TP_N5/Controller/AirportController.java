package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Repository.DaoAirport;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.Services.AirportService;
import com.UTN.TP_N5.Services.CityService;
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
    private AirportService daoAirport;
    @Autowired
    private CityService daoCity;

    @GetMapping(value = "/",produces = "application/json")
    public List getAllAirports(){
        List <Airport> airports = this.daoAirport.getAllAirports();
        List <AirportDTO> airportDTOS = new ArrayList<>();
        for (Airport airport: airports) {
            AirportDTO airportDTO = new AirportDTO();
            modelMapper.map(airport,airportDTO);
            airportDTOS.add(airportDTO);
        }
        return airportDTOS;
    }
    @GetMapping(value = "/{iata}",produces = "application/json")
    public AirportDTO getByIata(@PathVariable("iata") String iata){
        AirportDTO avion = new AirportDTO();
        modelMapper.map(this.daoAirport.getByIata(iata),avion);
        return avion;
    }
    @PostMapping(value = "/")
    public void create(@RequestBody AirportDTO airport){
        City city = daoCity.getByIata(airport.getCiudad().getIata());
        if(city != null){
            Airport airpor = new Airport(airport.getNombre(),airport.getIata(),city,airport.getLatitude(),airport.getLongitud());
            this.daoAirport.guardar(airpor);
        }
    }
    @DeleteMapping(value = "/{iata}")
    public void deleteAirportForIata(String name){
        this.daoAirport.eliminar(name);
    }

    @PutMapping(value = "/{id}")
    public void modifyAirport(@RequestBody Airport airport){
        this.daoAirport.modifyAirport(airport);

    }

}
