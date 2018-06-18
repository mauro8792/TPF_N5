package com.UTN.TP_N5.Controller;

import com.ModelsTP5.Model.Cabin;
import com.ModelsTP5.Model.Price;
import com.ModelsTP5.Model.RouteXCabin;
import com.ModelsTP5.Model.Routes;
import com.ModelsTP5.dto.RouteDTO;
import com.UTN.TP_N5.Services.CabinService;
import com.UTN.TP_N5.Services.PriceService;
import com.UTN.TP_N5.Services.RouteService;
import com.ModelsTP5.dto.PriceDTO;
import com.ModelsTP5.dto.PriceInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

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
    @GetMapping(value = "/especific/{destino}/{origen}/{fecha}")
    public List especificRouteandDate(@PathVariable(value = "destino") String destino, @PathVariable(value = "origen") String origen,@PathVariable(value = "fecha") String fechita) throws ParseException {
        LocalDate fecha = LocalDate.parse(fechita);
        Routes route = this.routeService.getEspecificRoute(destino,origen);
        List<PriceDTO> resultado = null;
        if (route != null) {
            resultado = new ArrayList<>();
            for (RouteXCabin rxc : route.getCabinas()) {
                for (Price price : rxc.getPrecios()) {
                    if ((fecha.isAfter(price.getDesde())) && (fecha.isBefore(price.getHasta()))) {
                        resultado.add(new PriceDTO(price));
                        break;
                    }
                }
            }

        }
        return resultado;
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
