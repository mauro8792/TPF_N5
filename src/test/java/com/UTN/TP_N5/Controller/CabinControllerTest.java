package com.UTN.TP_N5.Controller;

import com.ModelsTP5.Model.Cabin;
import com.UTN.TP_N5.Services.CabinService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CabinControllerTest{

    private Cabin cabin;
    private CabinService cabinService;
    private CabinController cabinController;

    @Before
    public void setUp(){
        this.cabinService= mock(CabinService.class);
        this.cabinController =new CabinController(this.cabinService);
        this.cabin=new Cabin((long)1,"Turista");
        when(this.cabinService.getAllCabins()).thenReturn(new ArrayList());
        when(this.cabinService.getByNombre("Turista")).thenReturn(this.cabin);
        when(this.cabinService.guardar(this.cabin)).thenReturn(true);
        when(this.cabinService.eliminar("Turista")).thenReturn(true);
    }
    @Test
    public void getAllTest(){
        assertNotNull(this.cabinController.getAllCabins());
    }
    @Test
    public void getByNombreTest(){assertNotNull(this.cabinController.getByNombre("Turista")); }
    @Test
    public void saveTest(){ assertTrue(this.cabinController.create(this.cabin));}
    @Test
    public  void deleteTest(){assertTrue(this.cabinController.deleteCabinForName("Turista"));}



}
