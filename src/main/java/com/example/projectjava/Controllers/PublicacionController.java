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

import com.example.projectjava.Models.Entity.Publicacion;
import com.example.projectjava.Models.Service.IPublicacionService;

@Controller
public class PublicacionController {
    

    @Autowired
    private IPublicacionService publicacionService;

    @GetMapping("/listarPublicaciones")
    public String listar(Model model){

        model.addAttribute("titulo", "listado de Publicaciones");
        model.addAttribute("publicaciones", publicacionService.findAll());

        return "listarPublicaciones";
    };

    @GetMapping("/formPublicacion")
    public String formPublicacion(Map<String, Object> model){
        Publicacion publicacion = new Publicacion();

        model.put("publicacion", publicacion);
        model.put("titulo", "Creando un Publicacion");

        return "formPublicacion";

    }

    @RequestMapping(value="/addPublicacion", method= RequestMethod.POST)
    public String guardarPublicacion(@Valid Publicacion publicacion, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("titulo", "Bienvenido de nuevo al form, hubo un error");
            return "formPublicacion";
        }

        publicacionService.save(publicacion);
        return "redirect:listarPublicaciones";

    }

    @GetMapping("/formPublicacion/{id}")
    public String editarPublicacion(@PathVariable long id, Map<String, Object> model){
        Publicacion publicacion = null;

        if(id>0){
            publicacion = publicacionService.findOne(id);
        }else{
            return "redirect:listarPublicaciones";
        }

        model.put("publicacion", publicacion);
        model.put("titulo", "editando una publicacion");

        return "formPublicacion";
    }


    @GetMapping("/eliminarPublicacion/{id}")
    public String eliminar(@PathVariable Long id){
        if(id>0){
            publicacionService.delete(id);
        }
        return "redirect:/listarPublicaciones";
        
    }

}
