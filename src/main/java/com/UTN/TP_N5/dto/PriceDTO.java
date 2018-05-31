package com.UTN.TP_N5.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {
    private int price;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date desde;
}
