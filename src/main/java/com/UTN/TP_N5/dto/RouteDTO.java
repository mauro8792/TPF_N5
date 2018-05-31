package com.UTN.TP_N5.dto;

import com.UTN.TP_N5.Model.Routes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.UTN.TP_N5.TpN5Application.modelMapper;

@Getter
@Setter
@NoArgsConstructor
public class RouteDTO {
    AirportDTO origin;
    AirportDTO destination;
    float distance;

    public RouteDTO(Routes routes){
        origin = new AirportDTO();
        modelMapper.map(routes.getDestination(),this.destination);
        destination = new AirportDTO();
        modelMapper.map(routes.getOrigin(),this.origin);
        this.distance = routes.getDistance();
    }
}
