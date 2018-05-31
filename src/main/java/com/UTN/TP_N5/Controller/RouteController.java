package com.UTN.TP_N5.Controller;


import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Model.Routes;
import com.UTN.TP_N5.Repository.DaoAirport;
import com.UTN.TP_N5.Repository.DaoCity;
import com.UTN.TP_N5.Repository.DaoRoute;
import com.UTN.TP_N5.dto.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.UTN.TP_N5.TpN5Application.modelMapper;

@RestController
@RequestMapping("/routes")
public class RouteController  {

    @Autowired
    private DaoRoute daoRoute;
    @Autowired
    private DaoAirport daoAirport;

    @PostMapping(value = "/")
    public void create(@RequestBody RouteDTO nuevo){
        Airport des = daoAirport.findByIata(nuevo.getDestination().getIata());
        Airport ori = daoAirport.findByIata(nuevo.getOrigin().getIata());
        if(ori!=null && des!=null){
            Routes niu = new Routes(ori,des,nuevo.getDistance());
            try{
                this.daoRoute.save(niu);
            }catch (Exception e){

            }
        }

    }
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
        List <RouteDTO> rutasDTO = new ArrayList<>();
        for (Routes ruta: rutas){
            RouteDTO routeDTO = new RouteDTO();
            modelMapper.map(ruta,routeDTO);
            rutasDTO.add(routeDTO);
        }
        return rutasDTO;
    }

}
