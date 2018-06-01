package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Price;
import com.UTN.TP_N5.Repository.DaoPrice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
@NoArgsConstructor
public class PriceService {

    @Autowired
    private DaoPrice daoPrice;

    public PriceService (DaoPrice daoPrice){
        this.daoPrice=daoPrice;
    }
    public Boolean guardar(Price nuevo){
        Boolean rtn = false;
        try {
            if (this.daoPrice.save(nuevo)!=null){
                rtn = true;
            }
        }catch (Exception e){

        }
        return rtn;
    }
    public Boolean eliminar (Long Id){
        Boolean rtn = false;
        try {
            //probar si anda OJOOOO!!!
            Price del = this.daoPrice.findByIdd(Id);
            this.daoPrice.delete(del);
            rtn = true;
        }catch (Exception e){

        }
        return rtn;
    }

    public  Price getById(Long Id){
        Price mostrar = null;
        try{
            mostrar = this.daoPrice.findByIdd(Id);

        }catch (Exception e){
        }
        return  mostrar;
    }
    public List getAllPrice (){
        List<Price> precios=null;
        try {
            precios=this.daoPrice.findAll();
        }catch (Exception e){

        }
        return precios;
    }
}
