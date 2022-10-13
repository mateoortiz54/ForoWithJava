package com.example.projectjava.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.projectjava.Models.Entity.Usuario;

@Repository("UsuarioDaoJPA")
public class UsuarioDaoImp implements IUsuarioDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return em.createQuery("from Usuario").getResultList();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {

        //usuario.getId() != null &&
        if(usuario.getId()>0){
            em.merge(usuario);
        }else{
            em.persist(usuario);
        }
        
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findOne(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Usuario usuario = findOne(id);
        em.remove(usuario);
    }
    
}
