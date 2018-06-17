package com.UTN.TP_N5.Repository;

import com.ModelsTP5.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoAirport extends JpaRepository<Airport, Long> {
    Airport findByIata(String iata);
}
