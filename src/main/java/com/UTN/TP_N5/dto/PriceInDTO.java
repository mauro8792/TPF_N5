package com.UTN.TP_N5.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PriceInDTO {
    @NotNull
    private Long idRoute;
    @NotNull
    private Long idCabin;
    @NotNull
    private int precio;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date desde;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date hasta;

}
