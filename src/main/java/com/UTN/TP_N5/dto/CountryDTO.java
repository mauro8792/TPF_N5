package com.UTN.TP_N5.dto;

import com.UTN.TP_N5.Model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CountryDTO {
    private String iso; private String name;

    public CountryDTO(Country country){
        this.iso=country.getIso();
        this.name=country.getName();
    }
}
