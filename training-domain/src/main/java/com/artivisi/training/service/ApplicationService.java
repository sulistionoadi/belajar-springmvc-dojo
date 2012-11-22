/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.service;

import com.artivisi.training.domain.Barang;
import java.util.List;

/**
 *
 * @author adi
 */
public interface ApplicationService {
    
    public void saveBarang(Barang barang);
    public void deleteBarang(Barang barang);
    public Long countBarang();
    public List<Barang> findAllBarang(Integer start, Integer row);
    public Barang findBarangById(Long id);
    
}
