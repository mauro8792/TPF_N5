package com.UTN.TP_N5.dto;

import com.UTN.TP_N5.Model.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
    private String iso;
    private String name;

    public CountryDTO(Country country){
        this.name = country.getName();
        this.iso = country.getIso();
    }
}
