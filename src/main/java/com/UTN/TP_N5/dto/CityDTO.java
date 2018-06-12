package com.UTN.TP_N5.dto;

import com.UTN.TP_N5.Model.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import static com.UTN.TP_N5.TpN5Application.modelMapper;

@NoArgsConstructor @Getter @Setter
public class CityDTO {
    private String iata; private String name; private CountryDTO country;

    public CityDTO(City ciudad){
        this.setIata(ciudad.getIata());
        this.setName(ciudad.getName());
        this.country = new CountryDTO(ciudad.getCountry().getIso(),ciudad.getCountry().getName());
    }
}
