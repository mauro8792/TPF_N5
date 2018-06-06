package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Cabin;
import com.UTN.TP_N5.Repository.DaoCabin;
import com.UTN.TP_N5.dto.CabinDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CabinService {

    @Autowired
    private DaoCabin daoCabin;

    public  CabinService(DaoCabin daocabin){
        this.daoCabin=daocabin;
    }

    public Boolean guardar(Cabin nuevo){
        Boolean rtn = false;
        try {
            if (this.daoCabin.save(nuevo)!=null){
                rtn = true;
            }
        }catch (Exception e){

        }
        return rtn;
    }
    public Boolean eliminar (String eliminar){
        Boolean rtn = false;
        try {
            Cabin del = this.daoCabin.findByNombre(eliminar);
            this.daoCabin.delete(del);
            rtn = true;
        }catch (Exception e){

        }
        return rtn;
    }

    public  Cabin getByNombre(String nombre){
        Cabin mostrar = null;
        try{
            mostrar = this.daoCabin.findByNombre(nombre);

        }catch (Exception e){
        }
        return  mostrar;
    }
    public List getAllCabins (){
        List<Cabin> cabinas=null;
        try {
            cabinas=this.daoCabin.findAll();
        }catch (Exception e){

        }
        return cabinas;
    }
    public Cabin getCabinID(Long id){
        Cabin cabin = this.daoCabin.findById(id).get();
        return cabin;
    }
    public boolean modifyCabin(CabinDTO cabin, Long id){
        boolean rtn = false;
        Cabin cabina = this.getCabinID(id);
        if(cabina != null){
            cabina.setNombre(cabin.getNombre());
            this.guardar(cabina);
            rtn = true;
        }
        return rtn;
    }
}
