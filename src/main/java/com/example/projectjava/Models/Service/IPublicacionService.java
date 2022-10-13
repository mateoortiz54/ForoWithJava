package com.example.projectjava.Models.Service;

import java.util.List;

import com.example.projectjava.Models.Entity.Publicacion;

public interface IPublicacionService {
    public List<Publicacion> findAll();

    public void save(Publicacion publicacion);

    public Publicacion findOne(Long id);

    public void delete(Long id);
}
