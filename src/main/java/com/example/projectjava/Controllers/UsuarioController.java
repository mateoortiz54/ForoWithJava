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

import com.example.projectjava.Models.Entity.Usuario;
import com.example.projectjava.Models.Service.IUsuarioService;

@Controller
public class UsuarioController {
    

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar")
    public String listar(Model model){

        model.addAttribute("titulo", "listado de usuarios");
        model.addAttribute("usuarios", usuarioService.findAll());

        return "listarUsuarios";
    };

    @GetMapping("/formUsuario")
    public String formUsuario(Map<String, Object> model){
        Usuario usuario = new Usuario();

        model.put("usuario", usuario);
        model.put("titulo", "Creando un usuario");

        return "formUsuario";

    }

    @RequestMapping(value="/addUsuario", method= RequestMethod.POST)
    public String guardarUsuario(@Valid Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("titulo", "Bienvenido de nuevo al form, hubo un error");
            return "formUsuario";
        }

        usuarioService.save(usuario);
        return "redirect:listar";

    }

    @GetMapping("/formUsuario/{id}")
    public String editarUsuario(@PathVariable long id, Map<String, Object> model){
        Usuario usuario = null;

        if(id>0){
            usuarioService.findOne(id);
        }else{
            return "redirect:listar";
        }

        model.put("usuario", usuario);
        model.put("titulo", "editando un usuario");

        return "formUpdateUsuario";
    }

}
