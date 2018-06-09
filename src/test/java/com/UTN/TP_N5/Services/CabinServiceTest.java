package com.UTN.TP_N5.ServicesTests;

import com.UTN.TP_N5.Model.Cabin;
import com.UTN.TP_N5.Repository.DaoCabin;
import com.UTN.TP_N5.Services.CabinService;
import com.UTN.TP_N5.dto.CabinDTO;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class CabinServiceTest {

    private CabinService cabinService;
    private Cabin cabin;

    @Before
    public void config(){
        DaoCabin mockDao = mock(DaoCabin.class);
        this.cabinService = new CabinService(mockDao);
        this.cabin = new Cabin((long)1,"Economica");
        when(mockDao.save(this.cabin)).thenReturn(this.cabin);
        when(mockDao.findByNombre("Economica")).thenReturn(this.cabin);
        when(mockDao.findById(this.cabin.getId())).thenReturn((Optional.of(this.cabin)));
        when(mockDao.findAll()).thenReturn(new ArrayList<>());

    }

    @Test
    public void saveTest(){
        Boolean res = this.cabinService.guardar(this.cabin);
        assertEquals(Boolean.TRUE,res);
    }

    @Test
    public void findByNameTest(){
        assertNotNull(this.cabinService.getByNombre("Economica"));
    }

    @Test
    public void findAllTest(){
        assertNotNull(this.cabinService.getAllCabins());
    }

    @Test
    public void deleteTest(){
        assertTrue(this.cabinService.eliminar("Economica"));
    }
    @Test
    public void modifyCabin(){
        assertTrue(this.cabinService.modifyCabin(new CabinDTO("PrimeraClase"),(long)1));
    }
}
