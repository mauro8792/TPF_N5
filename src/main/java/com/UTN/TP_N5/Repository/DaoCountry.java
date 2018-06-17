package com.UTN.TP_N5.Repository;


import com.ModelsTP5.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoCountry extends JpaRepository<Country,Long> {
    Country findByIso(String iso);
}
