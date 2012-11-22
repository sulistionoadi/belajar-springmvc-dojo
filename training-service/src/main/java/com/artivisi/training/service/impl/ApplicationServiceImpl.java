/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.service.impl;

import com.artivisi.training.domain.Barang;
import com.artivisi.training.service.ApplicationService;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author adi
 */

@Service("applicationService")
@Transactional
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired private SessionFactory sessionFactory;
    
    @Override
    public void saveBarang(Barang barang) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(barang);
    }

    @Override
    public void deleteBarang(Barang barang) {
        sessionFactory.getCurrentSession()
                .delete(barang);
    }

    @Override
    public Long countBarang() {
        return (Long) sessionFactory.getCurrentSession()
            .createQuery("select count(b) from Barang b")
            .uniqueResult();
    }

    @Override
    public List<Barang> findAllBarang(Integer start, Integer row) {
        if(start==null) start=0;
        if(row==null) row=20;
        
        return sessionFactory.getCurrentSession()
            .createQuery("select b from Barang b")
            .setFirstResult(start)
            .setMaxResults(row)
            .list();
    }

    @Override
    public Barang findBarangById(Long id) {
        return (Barang) sessionFactory.getCurrentSession()
                .createQuery("select b from Barang b "
                + "where b.id=:id")
                .setParameter("id", id)
                .uniqueResult();
    }
    
}
