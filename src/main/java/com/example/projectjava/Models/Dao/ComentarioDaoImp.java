package com.example.projectjava.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.projectjava.Models.Entity.Comentario;

@Repository("ComentarioDaoJPA")
public class ComentarioDaoImp implements IComentarioDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Comentario> findAll() {
        return em.createQuery("from Comentario").getResultList();
    }

    @Override
    @Transactional
    public void save(Comentario comentario) {

        
        if(comentario.getId() != null && comentario.getId()>0){
            em.merge(comentario);
        }else{
            em.persist(comentario);
        }
        
    }

    @Override
    @Transactional(readOnly = true)
    public Comentario findOne(Long id) {
        return em.find(Comentario.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Comentario comentario = findOne(id);
        em.remove(comentario);
    }
    
}
