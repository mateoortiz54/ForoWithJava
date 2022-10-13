package com.example.projectjava.Models.Service;

import java.util.List;

import com.example.projectjava.Models.Entity.Respuesta;

public interface IRespuestaService {
    public List<Respuesta> findAll();

    public void save(Respuesta respuesta);

    public Respuesta findOne(Long id);

    public void delete(Long id);
}
