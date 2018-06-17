package com.UTN.TP_N5.Controller;


import com.ModelsTP5.Model.Airport;
import com.ModelsTP5.Model.Routes;
import com.UTN.TP_N5.Services.AirportService;
import com.UTN.TP_N5.Services.RouteService;
import com.ModelsTP5.dto.RouteDTO;
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

    public RouteController(RouteService routeService, AirportService airportService) {
        this.daoRoute = routeService;
        this.daoAirport = airportService;
    }
    @PostMapping(value = "/")
    public boolean create(@RequestBody RouteDTO nuevo) {
        boolean ret = false;
        Airport des = daoAirport.getByIata(nuevo.getDestination().getIata());
        Airport ori = daoAirport.getByIata(nuevo.getOrigin().getIata());
        if (ori != null && des != null) {
            Routes niu = new Routes(ori, des, nuevo.getDistance());
            try {
                ret = this.daoRoute.guardar(niu);
            } catch (Exception e) {
            }
        }
        return ret;
    }
    @DeleteMapping(value = "/{id}")
    public boolean deleteRouteForId(@PathVariable("id") Long id) {
        return daoRoute.eliminar(id);
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public Routes getById(@PathVariable("id") Long id) {
        Routes ruta = daoRoute.getById(id);
        return ruta;
    }
    @GetMapping(value = "/")
    public List getAllRoutes() {
        List<Routes> rutas = (List<Routes>) this.daoRoute.getAllRoutes();
        List<RouteDTO> rutasDTO = new ArrayList<>();
        for (Routes ruta: rutas) {
            RouteDTO routeDTO = new RouteDTO(ruta);
            rutasDTO.add(routeDTO);
        }
        return rutasDTO;
    }

}
