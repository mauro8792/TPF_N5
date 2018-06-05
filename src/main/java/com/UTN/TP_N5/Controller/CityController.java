package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.City;
import com.UTN.TP_N5.Services.CityService;
import com.UTN.TP_N5.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import static com.UTN.TP_N5.TpN5Application.modelMapper;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService daocity;

    @PostMapping(value = "/")
    public void create(@RequestBody City nuevo){
        this.daocity.guardar(nuevo);
    }

    @GetMapping(value = "/{iata}", produces = "application/json")
    public CityDTO getByName(@PathVariable("iata") String iata){
        CityDTO rtn = new CityDTO();
        modelMapper.map(this.daocity.getByIata(iata),rtn);
        return rtn;
    }
    @GetMapping(value = "/", produces = "application/json")
    public List getAllCities(){
        List <City> ciudades = (List<City>) this.daocity.getAllCity();
        List <CityDTO> ciudadesDTO = new ArrayList<>();
        for (City ciudad: ciudades) {
            CityDTO cityDTO = new CityDTO();
            modelMapper.map(ciudad,cityDTO);
            ciudadesDTO.add(cityDTO);
        }
        return ciudadesDTO;
    }
    @DeleteMapping(value = "/{iata}")
    public void deleteCityForIata(@PathVariable("iata") String iata){
      this.daocity.eliminar(iata);
    }
}
