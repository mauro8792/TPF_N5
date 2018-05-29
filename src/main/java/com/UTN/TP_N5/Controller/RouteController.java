package com.UTN.TP_N5.Controller;


import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Routes;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.Repository.DaoRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController  {

    @Autowired
    private DaoRoute daoRoute;
    @Autowired
    private DaoCity daoCity;

    @PostMapping(value = "/")
    public void create(@RequestBody Routes nuevo){ this.daoRoute.save(nuevo); }
    @DeleteMapping(value = "/{id}")
    public void deleteRouteForId(@PathVariable("id") Long id){
        Routes ruta = daoRoute.findById(id).get();
        daoRoute.delete(ruta);
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public Routes getById(@PathVariable("id") Long id){
        Routes ruta = daoRoute.findById(id).get();
        return ruta;
    }
    @GetMapping(value = "/")
    public List getAllRoutes(){
        List <Routes> rutas = (List<Routes>) this.daoRoute.findAll();
        return rutas;
    }

}
