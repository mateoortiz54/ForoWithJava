package com.example.projectjava.Models.Dao;

import java.util.List;


import com.example.projectjava.Models.Entity.Publicacion;

public interface IPublicacionDao {
    
    public List<Publicacion> findAll();

    public void save(Publicacion publicacion);

    public Publicacion findOne(Long id); //puede que este malo

    public void delete(Long id);

}
