package com.UTN.TP_N5.Repository;

import com.ModelsTP5.Model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoCabin extends JpaRepository<Cabin,Long> {
    Cabin findByNombre(String nombre);
}
