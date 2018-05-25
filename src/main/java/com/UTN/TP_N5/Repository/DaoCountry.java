package com.UTN.TP_N5.Repository;

import com.UTN.TP_N5.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoCountry extends JpaRepository<Country,Long> {
    /*

    @Query("SELECT id_country FROM Countries c WHERE c.id_country=id")
    List<Country> findOne(Long id);
*/
}
