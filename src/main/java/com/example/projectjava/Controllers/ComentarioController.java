package com.example.projectjava.Controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.projectjava.Models.Entity.Comentario;
import com.example.projectjava.Models.Service.IComentarioService;

@Controller
public class ComentarioController {
    

    @Autowired
    private IComentarioService comentarioService;

    @GetMapping("/listarComentarios")
    public String listar(Model model){

        model.addAttribute("titulo", "listado de comentarios");
        model.addAttribute("comentarios", comentarioService.findAll());

        return "listarComentarios";
    };

    @GetMapping("/formComentario")
    public String formComentario(Map<String, Object> model){
        Comentario comentario = new Comentario();

        model.put("comentario", comentario);
        model.put("titulo", "Creando un comentario");

        return "formComentario";

    }

    @RequestMapping(value="/addComentario", method= RequestMethod.POST)
    public String guardarComentario(@Valid Comentario comentario, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("titulo", "Bienvenido de nuevo al form, hubo un error");
            return "formComentario";
        }

        comentarioService.save(comentario);
        return "redirect:listarComentarios";

    }

    @GetMapping("/formComentario/{id}")
    public String editarComentario(@PathVariable long id, Map<String, Object> model){
        Comentario comentario = null;

        if(id>0){
            comentario = comentarioService.findOne(id);
        }else{
            return "redirect:listar";
        }

        model.put("comentario", comentario);
        model.put("titulo", "editando un comentario");

        return "formComentario";
    }


    @GetMapping("/eliminarComentario/{id}")
    public String eliminar(@PathVariable Long id){
        if(id>0){
            comentarioService.delete(id);
        }
        return "redirect:/listarComentarios";
        
    }

}
