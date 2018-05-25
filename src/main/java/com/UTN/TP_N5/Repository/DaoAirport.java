package com.UTN.TP_N5.Repository;

import com.UTN.TP_N5.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaoAirport extends JpaRepository<Airport,Long> {


}
