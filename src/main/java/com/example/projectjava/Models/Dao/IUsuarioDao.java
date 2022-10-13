package com.example.projectjava.Models.Dao;

import java.util.List;


import com.example.projectjava.Models.Entity.Usuario;

public interface IUsuarioDao {
    
    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public Usuario findOne(Long id); //puede que este malo

    public void delete(Long id);

}
