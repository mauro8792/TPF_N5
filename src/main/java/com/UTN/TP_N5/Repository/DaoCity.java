package com.UTN.TP_N5.Repository;

import com.UTN.TP_N5.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoCity extends JpaRepository<City, Long> {
}
