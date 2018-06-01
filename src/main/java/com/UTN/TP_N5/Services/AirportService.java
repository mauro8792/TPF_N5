package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Repository.DaoAirport;
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
            if (this.daoAirport.save(nuevo)!=null){
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
        List<Airport> aeropuertos=null;
        try {
            aeropuertos=this.daoAirport.findAll();
        }catch (Exception e){

        }
        return aeropuertos;
    }
}
