package com.UTN.TP_N5.dto;

import com.UTN.TP_N5.Model.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.UTN.TP_N5.TpN5Application.modelMapper;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {
    private String iata;
    private String name;
    private CountryDTO country;

    public CityDTO(City ciudad){
        this.iata = ciudad.getIata();
        this.name = ciudad.getName();
        this.country =new CountryDTO();
        modelMapper.map(ciudad.getCountry(),this.country);
    }

}
