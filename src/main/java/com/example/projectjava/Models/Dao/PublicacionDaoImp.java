package com.example.projectjava.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.projectjava.Models.Entity.Publicacion;

@Repository("PublicacionDaoJPA")
public class PublicacionDaoImp implements IPublicacionDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Publicacion> findAll() {
        return em.createQuery("from Publicacion").getResultList();
    }

    @Override
    @Transactional
    public void save(Publicacion publicacion) {

        
        if(publicacion.getId() != null && publicacion.getId()>0){
            em.merge(publicacion);
        }else{
            em.persist(publicacion);
        }
        
    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion findOne(Long id) {
        return em.find(Publicacion.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Publicacion publicacion = findOne(id);
        em.remove(publicacion);
    }
    
}
