package com.UTN.TP_N5.dto;

import com.UTN.TP_N5.Model.Routes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static com.UTN.TP_N5.TpN5Application.modelMapper;

@NoArgsConstructor
@Getter
@Setter
public class RouteDTO {
    private AirportDTO origin;
    private AirportDTO destination;
    private float distance;

    public RouteDTO(Routes routes){
        this.origin = new AirportDTO();
        this.destination = new AirportDTO();
        modelMapper.map(routes.getDestination(),this.destination);
        modelMapper.map(routes.getOrigin(),this.origin);
        this.distance = routes.getDistance();
    }
}
