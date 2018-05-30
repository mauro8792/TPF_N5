package com.UTN.TP_N5.Services;

import com.UTN.TP_N5.Repository.DaoAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    @Autowired
    private DaoAirport daoAirport;
}
