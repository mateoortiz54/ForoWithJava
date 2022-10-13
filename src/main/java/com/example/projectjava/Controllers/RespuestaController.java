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

import com.example.projectjava.Models.Entity.Respuesta;
import com.example.projectjava.Models.Service.IRespuestaService;

@Controller
public class RespuestaController {
    

    @Autowired
    private IRespuestaService respuestaService;

    @GetMapping("/listarRespuestas")
    public String listar(Model model){

        model.addAttribute("titulo", "listado de respuestas");
        model.addAttribute("respuestas", respuestaService.findAll());

        return "listarRespuestas";
    };

    @GetMapping("/formRespuesta")
    public String formRespuesta(Map<String, Object> model){
        Respuesta respuesta = new Respuesta();

        model.put("respuesta", respuesta);
        model.put("titulo", "Creando una Respuesta");

        return "formRespuesta";

    }

    @RequestMapping(value="/addRespuesta", method= RequestMethod.POST)
    public String guardarRespuesta(@Valid Respuesta respuesta, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("titulo", "Bienvenido de nuevo al form, hubo un error");
            return "formRespuesta";
        }

        respuestaService.save(respuesta);
        return "redirect:listarRespuestas";

    }

    @GetMapping("/formRespuesta/{id}")
    public String editarRespuesta(@PathVariable long id, Map<String, Object> model){
        Respuesta respuesta = null;

        if(id>0){
            respuesta = respuestaService.findOne(id);
        }else{
            return "redirect:listarRespuestas";
        }

        model.put("respuesta", respuesta);
        model.put("titulo", "editando una respuesta");

        return "formRespuesta";
    }


    @GetMapping("/eliminarRespuesta/{id}")
    public String eliminar(@PathVariable Long id){
        if(id>0){
            respuestaService.delete(id);
        }
        return "redirect:/listarRespuestas";
        
    }

}
