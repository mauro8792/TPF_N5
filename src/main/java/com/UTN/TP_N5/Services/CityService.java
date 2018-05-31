package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Repository.DaoCity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CityService {
    @Autowired
    private DaoCity daoCity;

    public CityService(DaoCity daoCity){
        this.daoCity = daoCity;
    }

    public Boolean guardar(City nuevo){
        Boolean rtn=false;
        try {
            if (this.daoCity.save(nuevo)!=null){
                rtn = true;
            }
        }catch (Exception e){

        }
        return rtn;
    }
    public Boolean eliminar(String iata){
        Boolean rtn=false;
        try{
            City del = this.daoCity.findByIata(iata);
            this.daoCity.delete(del);
            rtn = true;
        }catch (Exception e){

        }
        return rtn;
    }
    public City getByIata (String iata){
        City mostrar=null;
        try {
            mostrar=this.daoCity.findByIata(iata);
        }catch (Exception e){

        }
        return mostrar;
    }
    public List getAllCity(){
        List<City> ciudades=null;
        try {
            ciudades=this.daoCity.findAll();
        }catch (Exception e){

        }
        return ciudades;
    }

}