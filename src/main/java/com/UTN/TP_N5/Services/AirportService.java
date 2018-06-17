package com.UTN.TP_N5.Services;

import com.ModelsTP5.Model.Airport;
import com.UTN.TP_N5.Repository.DaoAirport;
import com.ModelsTP5.dto.AirportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private DaoAirport daoAirport;

    public AirportService (DaoAirport daoAirport){

        this.daoAirport=daoAirport;
    }
    public Boolean guardar(Airport nuevo){
        Boolean rtn=false;
        try {
            if (this.daoAirport.findByIata(nuevo.getIata())==null){
                this.daoAirport.save(nuevo);
                rtn = true;
            }
        }catch (Exception e){

        }
        return rtn;
    }
    public Boolean eliminar(String iata){
        Boolean rtn=false;
        try{
            Airport del = this.daoAirport.findByIata(iata);
            this.daoAirport.delete(del);
            rtn = true;
        }catch (Exception e){

        }
        return rtn;
    }
    public Airport getByIata (String iata){
        Airport mostrar = null;
        try {
            mostrar=this.daoAirport.findByIata(iata);
        }catch (Exception e){

        }
        return mostrar;
    }
    public List getAllAirports(){
        List<Airport> aeropuertos = null;
        try {
            aeropuertos=this.daoAirport.findAll();
        }catch (Exception e){

        }
        return aeropuertos;
    }
    public boolean modifyAirport(AirportDTO airport){
        boolean rtn = false;
        Airport airpor = this.getByIata(airport.getIata());
        if(airport != null) {
            airpor.setLatitude(airport.getLatitude());
            airpor.setLongitud(airport.getLongitud());
            airpor.setNombre(airport.getNombre());
            this.guardar(airpor);
            rtn = true;
        }
        return rtn;
    }
}
