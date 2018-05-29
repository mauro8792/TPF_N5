package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Cabin;
import com.UTN.TP_N5.Repository.DaoCabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabin")
public class CabinController {

    @Autowired
    private DaoCabin daoCabin;

    @PostMapping(value = "/")
    public void create(@RequestBody Cabin nuevo){
        this.daoCabin.save(nuevo);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCountryForId(@PathVariable("id") Long id){
        Cabin cabina = daoCabin.findById(id).get();
        daoCabin.delete(cabina);
    }
    @GetMapping(value = "/{id}",produces = "application/json")
    public Cabin getById(@PathVariable("id") Long id){
        Cabin pais = daoCabin.findById(id).get();
        return pais;
    }
    @GetMapping(value = "/")
    public List getAllCabins(){
        List <Cabin> cabinas = (List<Cabin>) this.daoCabin.findAll();
        return cabinas;
    }
}
