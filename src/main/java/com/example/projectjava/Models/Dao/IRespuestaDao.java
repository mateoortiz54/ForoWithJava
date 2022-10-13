package com.example.projectjava.Models.Dao;

import java.util.List;


import com.example.projectjava.Models.Entity.Respuesta;

public interface IRespuestaDao {
    
    public List<Respuesta> findAll();

    public void save(Respuesta respuesta);

    public Respuesta findOne(Long id); //puede que este malo

    public void delete(Long id);

}
