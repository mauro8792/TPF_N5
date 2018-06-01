package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Model.Routes;
import com.UTN.TP_N5.Repository.DaoPrice;
import com.UTN.TP_N5.Repository.DaoRoute;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class RouteService {

    @Autowired
    private DaoRoute daoRoute;

    private RouteService (DaoRoute daoRoute){
        this.daoRoute=daoRoute;
    }

    public Boolean guardar(Routes nuevo){
        Boolean rtn = false;
        try {
            if (this.daoRoute.save(nuevo)!=null){
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
            Routes del = this.daoRoute.findByIdd(Id);
            this.daoRoute.delete(del);
            rtn = true;
        }catch (Exception e){

        }
        return rtn;
    }

    public  Routes getById(Long Id){
        Routes mostrar = null;
        try{
            mostrar = this.daoRoute.findByIdd(Id);

        }catch (Exception e){
        }
        return  mostrar;
    }
    public List getAllRoutes (){
        List<Routes> rutas=null;
        try {
            rutas=this.daoRoute.findAll();
        }catch (Exception e){

        }
        return rutas;
    }
}
