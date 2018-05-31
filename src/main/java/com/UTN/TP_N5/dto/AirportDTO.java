package com.UTN.TP_N5.dto;

import com.UTN.TP_N5.Model.Airport;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.UTN.TP_N5.TpN5Application.modelMapper;

@Getter
@Setter
@NoArgsConstructor
public class AirportDTO {
    private String nombre;
    private String iata;
    private CityDTO ciudad;

    public AirportDTO(Airport airport){
        this.ciudad = new CityDTO();
        modelMapper.map(airport.getCiudad(),this.ciudad);
        this.iata = airport.getIata();
        this.nombre = airport.getNombre();
    }
}
