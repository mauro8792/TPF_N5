package com.UTN.TP_N5.Services;

import com.ModelsTP5.Model.Cabin;
import com.UTN.TP_N5.Repository.DaoCabin;
import com.UTN.TP_N5.Services.CabinService;
import com.ModelsTP5.dto.CabinDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CabinServiceTest {

    private DaoCabin mockDao;
    private CabinService cabinService;
    private Cabin cabin;

    @Before
    public void config(){
        mockDao = mock(DaoCabin.class);
        this.cabinService = new CabinService(mockDao);
        this.cabin = new Cabin((long)1,"Economica");
        when(mockDao.save(this.cabin)).thenReturn(this.cabin);
        when(mockDao.findByNombre(this.cabin.getNombre())).thenReturn(this.cabin);
        when(mockDao.findById(this.cabin.getId())).thenReturn((Optional.of(this.cabin)));
        when(mockDao.findAll()).thenReturn(new ArrayList<>());

    }

    @Test
    public void badSaveTest(){
        Boolean res = this.cabinService.guardar(this.cabin);
        assertFalse(res);
    }
    @Test
    public void goodSaveTest(){
        Cabin cabinita = new Cabin((long)2,"Primera Clase");
        Boolean res = this.cabinService.guardar(cabinita);
        assertTrue(res);
    }
    @Test
    public void findByNameTest(){

        assertNotNull(this.cabinService.getByNombre(this.cabin.getNombre()));
    }

    @Test
    public void findAllTest(){
        assertNotNull(this.cabinService.getAllCabins());
    }

    @Test
    public void deleteTest(){
        assertTrue(this.cabinService.eliminar(this.cabin.getNombre()));
    }
    @Test
    public void modifyCabin(){
        assertTrue(this.cabinService.modifyCabin(new CabinDTO("PrimeraClase"),(long)1));
    }
}
