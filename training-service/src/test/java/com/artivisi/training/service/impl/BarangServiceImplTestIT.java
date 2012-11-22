/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.service.impl;

import static org.junit.Assert.*;

import com.artivisi.training.domain.Barang;
import com.artivisi.training.service.ApplicationService;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author adi
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:com/artivisi/training/**/applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class BarangServiceImplTestIT {
    
    @Autowired private ApplicationService applicationService;
    
    @Test public void testSaveBarang(){
        Barang b = new Barang();
        b.setKode("B0001");
        b.setNama("Mouse Logitect P22");
        b.setHarga(new BigDecimal("100000"));
        applicationService.saveBarang(b);
    }
    
    @Test public void testFindAllBarang(){
        Long numrows = applicationService.countBarang();
        assertTrue(numrows > 0);
        
        List<Barang> listBarang = 
                applicationService.findAllBarang(
                0, numrows.intValue());
        
        assertEquals(numrows.intValue(), listBarang.size());
    }
}
