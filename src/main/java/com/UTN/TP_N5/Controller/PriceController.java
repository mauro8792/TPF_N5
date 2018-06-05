package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Price;
import com.UTN.TP_N5.Services.PriceService;
import com.UTN.TP_N5.dto.PriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService daoPrice;

    @PostMapping(value = "/")
    public void newPrice(@RequestBody Price price){ this.daoPrice.guardar(price); }

    @GetMapping(value = "/", produces = "application/json")
    public List getAll(){
        List <Price> prices = this.daoPrice.getAllPrice();
        List <PriceDTO> priceDTOS = new ArrayList<>();
        for(Price price : prices){
            PriceDTO priceDTO = new PriceDTO(price);
            priceDTOS.add(priceDTO);
        }
        return priceDTOS;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Price getById(@PathVariable("id")Long id){
        Price rtn = this.daoPrice.getById(id);
        return rtn;
    }
    @DeleteMapping(value = "/{id}")
    public void deleteById(@Param("id")Long id){
        this.daoPrice.eliminar(id);
    }
}
