package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCountry;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class CountryService {

    @Autowired
    private DaoCountry daoCountry;

    public CountryService(DaoCountry daoCountry){
        this.daoCountry = daoCountry;
    }

    public Boolean guardar(Country nuevo){
        Boolean rtn = false;
        try {
            if (this.daoCountry.findByIso(nuevo.getIso())==null){
                this.daoCountry.save(nuevo);
                rtn = true;
            }
        }catch (Exception e){

        }
        return rtn;
    }

    public Boolean eliminar (String eliminar){
        Boolean rtn = false;
        try {
            Country del = this.daoCountry.findByIso(eliminar);
            this.daoCountry.delete(del);
            rtn = true;
        }catch (Exception e){

        }
        return rtn;
     }

    public  Country getByIso(String iso){
        Country mostrar = null;
        try{
             mostrar = this.daoCountry.findByIso(iso);

        }catch (Exception e){
        }
        return  mostrar;
    }
    public List getAllCountry (){
        List<Country> countries=null;
        try {
            countries=this.daoCountry.findAll();
        }catch (Exception e){

        }
        return countries;
    }

}
