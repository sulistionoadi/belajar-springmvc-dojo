/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author adi
 */

@Entity
@Table(name="t_penjualan_header")
public class PenjualanHeader {
    
    @Id @GeneratedValue
    private Long id;
    
    @Column(name="no_faktur", nullable=false, unique=true)
    private String noFaktur;
    
    @Temporal(TemporalType.DATE)
    @Column(name="tanggal", nullable=false)
    private Date tanggal;
    
    @ManyToOne
    @JoinColumn(name="id_konsumen", nullable=false)
    private Konsumen konsumen;

    @OneToMany(mappedBy="header")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<PenjualanDetail> penjualanDetails = 
            new ArrayList<PenjualanDetail>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Konsumen getKonsumen() {
        return konsumen;
    }

    public void setKonsumen(Konsumen konsumen) {
        this.konsumen = konsumen;
    }

    public String getNoFaktur() {
        return noFaktur;
    }

    public void setNoFaktur(String noFaktur) {
        this.noFaktur = noFaktur;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public List<PenjualanDetail> getPenjualanDetails() {
        return penjualanDetails;
    }

    public void setPenjualanDetails(List<PenjualanDetail> penjualanDetails) {
        this.penjualanDetails = penjualanDetails;
    }
    
    
}
