package com.example.projectjava.Models.Dao;

import java.util.List;


import com.example.projectjava.Models.Entity.Comentario;

public interface IComentarioDao {
    
    public List<Comentario> findAll();

    public void save(Comentario comentario);

    public Comentario findOne(Long id); //puede que este malo

    public void delete(Long id);

}
