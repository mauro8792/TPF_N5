package com.UTN.TP_N5.Controller;

import com.ModelsTP5.Model.Cabin;
import com.ModelsTP5.Model.Price;
import com.ModelsTP5.Model.RouteXCabin;
import com.ModelsTP5.Model.Routes;
import com.UTN.TP_N5.Services.CabinService;
import com.UTN.TP_N5.Services.PriceService;
import com.UTN.TP_N5.Services.RouteService;
import com.ModelsTP5.dto.PriceDTO;
import com.ModelsTP5.dto.PriceInDTO;
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

    @Autowired
    private RouteService routeService;

    @Autowired
    private CabinService cabinService;

    public PriceController(PriceService priceService, RouteService routeService, CabinService cabinService) {
        this.daoPrice = priceService;
        this.routeService = routeService;
        this.cabinService = cabinService;
    }

    @PostMapping(value = "/")
    public void newPrice(@RequestBody PriceInDTO price) {
        Routes route = this.routeService.getById(price.getIdRoute());
        Cabin cabin = this.cabinService.getCabinID(price.getIdCabin());
        if (route != null && cabin != null) {
            RouteXCabin rxc = new RouteXCabin(route, cabin);
            Price price1 = new Price(price.getPrecio(), price.getDesde(), price.getHasta());
            price1.setRouteXCabins(rxc);
            this.daoPrice.guardar(price1);
        }

    }

    @GetMapping(value = "/", produces = "application/json")
    public List getAll() {
        List<Price> prices = this.daoPrice.getAllPrice();
        List<PriceDTO> priceDTOS = new ArrayList<>();
        for (Price price : prices) {
            PriceDTO priceDTO = new PriceDTO(price);
            priceDTOS.add(priceDTO);
        }
        return priceDTOS;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Price getById(@PathVariable("id")Long id) {
        Price rtn = this.daoPrice.getById(id);
        return rtn;
    }
    @DeleteMapping(value = "/{id}")
    public void deleteById(@Param("id")Long id) {
        this.daoPrice.eliminar(id);
    }
}
