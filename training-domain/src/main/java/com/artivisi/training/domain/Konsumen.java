/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.domain;

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
@Table(name="m_konsumen")
public class Konsumen {
    
    @Id @GeneratedValue
    private Long id;
    
    @Column(name="nama_konsumen", nullable=false, length=30)
    private String nama;
    
    @Column(name="alamat", nullable=false, length=50)
    private String alamat;
    
    @Column(name="email", nullable=false, length=50, unique=true)
    private String email;
    
    @Column(name="no_telp", nullable=false, length=15)
    private String noTelp;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
    
}
