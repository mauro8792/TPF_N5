package com.UTN.TP_N5.Controller;

import com.UTN.TP_N5.Model.Price;
import com.UTN.TP_N5.Repository.DaoPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private DaoPrice daoPrice;

    @PostMapping(value = "/")
    public void newPrice(@RequestBody Price price){ this.daoPrice.save(price); }

    @GetMapping(value = "/", produces = "application/json")
    public List getAll(){
        List <Price> prices = this.daoPrice.findAll();
        return  prices;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Price getById(@Param("id")Long id){
        Price rtn = this.daoPrice.findById(id).get();
        return rtn;
    }
    @DeleteMapping(value = "/{id}")
    public void deleteById(@Param("id")Long id){
        this.daoPrice.deleteById(id);
    }
}
