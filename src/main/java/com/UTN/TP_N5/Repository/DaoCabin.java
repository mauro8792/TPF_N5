package com.UTN.TP_N5.Repository;

import com.UTN.TP_N5.Model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoCabin extends JpaRepository<Cabin,Long> {
    Cabin findByNombre(String nombre);
}
