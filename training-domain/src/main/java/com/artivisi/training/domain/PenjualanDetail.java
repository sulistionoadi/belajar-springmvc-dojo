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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author adi
 */

@Entity
@Table(name="t_penjualan_detail", 
        uniqueConstraints={
            @UniqueConstraint(
                columnNames={"id_header","kode_barang"}
            )
        })
public class PenjualanDetail {
    
    @Id @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_header", nullable=false)
    private PenjualanHeader header;
    
    @ManyToOne
    @JoinColumn(name="kode_barang", nullable=false)
    private Barang barang;
    
    @Column(name="qty", nullable=false)
    private Integer qty = 0;
    
    @Column(name="harga", nullable=false)
    private BigDecimal harga = BigDecimal.ZERO;
    
    @Column(name="total", nullable=false)
    private BigDecimal total = BigDecimal.ZERO;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public PenjualanHeader getHeader() {
        return header;
    }

    public void setHeader(PenjualanHeader header) {
        this.header = header;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
}
