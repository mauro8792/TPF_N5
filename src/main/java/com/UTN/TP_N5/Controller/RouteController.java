package com.UTN.TP_N5.Controller;


import com.UTN.TP_N5.Model.Airport;
import com.UTN.TP_N5.Model.Routes;
import com.UTN.TP_N5.Services.AirportService;
import com.UTN.TP_N5.Services.RouteService;
import com.UTN.TP_N5.dto.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/routes")
public class RouteController  {

    @Autowired
    private RouteService daoRoute;
    @Autowired
    private AirportService daoAirport;

    public RouteController(RouteService routeService){
        this.daoRoute=routeService;
    }
    @PostMapping(value = "/")
    public void create(@RequestBody RouteDTO nuevo){
        Airport des = daoAirport.getByIata(nuevo.getDestination().getIata());
        Airport ori = daoAirport.getByIata(nuevo.getOrigin().getIata());
        if(ori!=null && des!=null){
            Routes niu = new Routes(ori,des,nuevo.getDistance());
            try{
                this.daoRoute.guardar(niu);
            }catch (Exception e){
            }
        }
    }
    @DeleteMapping(value = "/{id}")
    public void deleteRouteForId(@PathVariable("id") Long id){
        daoRoute.eliminar(id);
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public Routes getById(@PathVariable("id") Long id){
        Routes ruta = daoRoute.getById(id);
        return ruta;
    }
    @GetMapping(value = "/")
    public List getAllRoutes(){
        List <Routes> rutas = (List<Routes>) this.daoRoute.getAllRoutes();
        List <RouteDTO> rutasDTO = new ArrayList<>();
        for (Routes ruta: rutas){
            RouteDTO routeDTO = new RouteDTO(ruta);
            rutasDTO.add(routeDTO);
        }
        return rutasDTO;
    }

}
