package com.example.projectjava.Models.Entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Respuestas")
public class Respuesta implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @Column(name="id_usuario")
    private Long IdUsuario;

    @NotEmpty
    @Column(name="respuesta_comentario")
    private String RespuestaComentario;

    @NotNull
    @Column(name="id_comentario")
    private Long IdComentario;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getRespuestaComentario() {
        return RespuestaComentario;
    }

    public void setRespuestaComentario(String respuestaComentario) {
        RespuestaComentario = respuestaComentario;
    }

    public Long getIdComentario() {
        return IdComentario;
    }

    public void setIdComentario(Long idComentario) {
        IdComentario = idComentario;
    }


    
}
