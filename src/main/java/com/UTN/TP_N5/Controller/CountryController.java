package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Country;
import com.UTN.TP_N5.Services.CountryService;
import com.UTN.TP_N5.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.UTN.TP_N5.TpN5Application.modelMapper;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService daoCountry;

    @PostMapping(value = "/")
    public void create(@RequestBody Country nuevo){
        this.daoCountry.guardar(nuevo);
    }

    @DeleteMapping (value = "/{iso}")
    public void deleteCountryForIso(@PathVariable("iso") String iso){
        this.daoCountry.eliminar(iso);
    }

    @GetMapping(value = "/{iso}",produces = "application/json")
    public CountryDTO getById(@PathVariable("iso") String iso){
        CountryDTO pais = new CountryDTO();
        modelMapper.map(this.daoCountry.getByIso(iso),pais);
        return pais;
    }

    @GetMapping(value = "/")
    public List getAllCountrie(){
        List<Country> countries = this.daoCountry.getAllCountry();
        return countries;
    }
}