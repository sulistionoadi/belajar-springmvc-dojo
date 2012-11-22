/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author adi
 */

@Entity
@Table(name="m_barang")
public class Barang {
    
    @Id @GeneratedValue
    private Long id;
    
    @Column(name="kode_barang", nullable=false, length=8, unique=true)
    private String kode;
    
    @Column(name="nama_barang", nullable=false, length=30)
    private String nama;
    
    @Column(name="harga_barang", nullable=false)
    private BigDecimal harga = BigDecimal.ZERO;

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
