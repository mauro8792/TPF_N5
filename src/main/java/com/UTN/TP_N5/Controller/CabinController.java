package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Cabin;
import com.UTN.TP_N5.Services.CabinService;
import com.UTN.TP_N5.dto.CabinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabin")
public class CabinController {

    @Autowired
    private CabinService daoCabin;

    public CabinController(CabinService cabinService){
        this.daoCabin=cabinService;
    }

    @PostMapping(value = "/")
    public void create(@RequestBody Cabin nuevo){
        this.daoCabin.guardar(nuevo);
    }
    @DeleteMapping(value = "/{nombre}")
    public void deleteCabinForName(@PathVariable("nombre") String nombre){
        daoCabin.eliminar(nombre);
    }

    @GetMapping(value = "/{nombre}",produces = "application/json")
    public CabinDTO getByNombre(@PathVariable("nombre") String nombre){
        Cabin cabin = daoCabin.getByNombre(nombre);
        CabinDTO cabinDTO= new CabinDTO(cabin.getNombre());
        return cabinDTO;
    }
    @GetMapping(value = "/")
    public List getAllCabins(){
        List <Cabin> cabinas = (List<Cabin>) this.daoCabin.getAllCabins();
        return cabinas;
    }
    @PutMapping(value = "/{id}")
    public void modifyCabin(@RequestBody CabinDTO cabin,@PathVariable ("id") Long id){
        this.daoCabin.modifyCabin(cabin, id);
    }
}
