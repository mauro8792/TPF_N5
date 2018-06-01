package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Cabin;
import com.UTN.TP_N5.Repository.DaoCabin;
import com.UTN.TP_N5.Services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabin")
public class CabinController {

    @Autowired
    private CabinService daoCabin;

    @PostMapping(value = "/")
    public void create(@RequestBody Cabin nuevo){
        this.daoCabin.guardar(nuevo);
    }
    @DeleteMapping(value = "/{nombre}")
    public void deleteCountryForNombre(@PathVariable("nombre") String nombre){
        daoCabin.eliminar(nombre);
    }
    @GetMapping(value = "/{nombre}",produces = "application/json")
    public Cabin getById(@PathVariable("nombre") String nombre){
        Cabin pais = daoCabin.getByNombre(nombre);
        return pais;
    }
    @GetMapping(value = "/")
    public List getAllCabins(){
        List <Cabin> cabinas = (List<Cabin>) this.daoCabin.getAllCabins();
        return cabinas;
    }
}
