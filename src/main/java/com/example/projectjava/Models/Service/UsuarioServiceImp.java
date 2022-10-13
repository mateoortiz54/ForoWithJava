package com.example.projectjava.Models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projectjava.Models.Dao.IUsuarioDao;
import com.example.projectjava.Models.Entity.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        
        return usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findOne(Long id) {
        
        return usuarioDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioDao.delete(id);
        
    }
    
}
