package com.example.projectjava.Models.Service;

import java.util.List;

import com.example.projectjava.Models.Entity.Comentario;

public interface IComentarioService {
    public List<Comentario> findAll();

    public void save(Comentario comentario);

    public Comentario findOne(Long id);

    public void delete(Long id);
}
