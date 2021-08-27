package com.ps2.ps2.web;

import com.ps2.ps2.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ps2.ps2.servicio.IPersonaService;
import javax.validation.Valid;
import lombok.var;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private IPersonaService personaService;
    
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var personas = personaService.listarPersonas();   
        log.info("Ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login: " + user);
        model.addAttribute("personas",personas);
        var saldoTotal=0D;
        for(var p:personas){
            saldoTotal+=p.getSaldo();
        }
        model.addAttribute("saldoTotal",saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona p, Errors e){ //Guardar con validacion, pasamos por parametro el error
        if(e.hasErrors()){
            return "modificar";
        }
            personaService.guardar(p);
            return"redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona p, Model model){ //Recibe persona y lo inicializa automaticamente con el valor de idPersona (automatico por spring), recibimos model para compartilar en la sig peticion
        p = personaService.encontrarPersona(p); //buscamos la persona en la base de datos
        model.addAttribute("persona",p);
        return "modificar";
    }
    
    @GetMapping("/eliminar") //metodo hecho con query parameter
    public String eliminar(Persona p){
        personaService.eliminar(p);
        return "redirect:/";
    }
    
}
