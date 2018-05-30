package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Repository.DaoCountry;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CountryService {

    @Autowired
    private DaoCountry daoCountry;

    public CountryService(DaoCountry daoCountry){
        this.daoCountry = daoCountry;
    }
    public String guardar(Country nuevo){
        String rtn = "Error en la carga";
        try {
            this.daoCountry.save(nuevo);
            rtn = "Carga exitosa";
        }catch (Exception e){

        }
        return rtn;
    }
}
