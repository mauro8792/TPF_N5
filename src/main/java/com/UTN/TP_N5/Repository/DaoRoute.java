package com.UTN.TP_N5.Repository;

import com.UTN.TP_N5.Model.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoRoute extends JpaRepository<Routes, Long> {
    Routes findByIdd(Long Id);
}
