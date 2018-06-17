package com.UTN.TP_N5.Services;

import com.ModelsTP5.Model.Routes;
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

    RouteService(DaoRoute daoRoute) {
        this.daoRoute=daoRoute;
    }

    public Boolean guardar(Routes nuevo) {
        Boolean rtn = false;
        try {
                this.daoRoute.save(nuevo);
                rtn = true;

        } catch (Exception e) {

        }
        return rtn;
    }
    public Boolean eliminar(Long Id) {
        Boolean rtn = false;
        try {
            Routes del = this.daoRoute.findById(Id).get();
            this.daoRoute.delete(del);
            rtn = true;
        } catch (Exception e) {

        }
        return rtn;
    }

    public Routes getEspecificRoute (String destino, String origen) {
        Routes rtn = null;
        List<Routes> rutas = this.getAllRoutes();
        for(Routes route :rutas) {
            if ((route.getDestination().getIata().equalsIgnoreCase(destino)) && route.getOrigin().getIata().equalsIgnoreCase(origen)) {
                rtn = route;
                break;
            }
        }
        return rtn;
    }
    public  Routes getById(Long Id) {
        Routes mostrar = null;
        try {
            mostrar = this.daoRoute.findById(Id).get();

        } catch (Exception e) {
        }
        return  mostrar;
    }
    public List getAllRoutes() {
        List<Routes> rutas = null;
        try {
            rutas = this.daoRoute.findAll();
        } catch (Exception e) {

        }
        return rutas;
    }
}
