package com.crud.app.controlador;

import com.crud.app.interfazServicio.IpersonaServicio;
import com.crud.app.modelo.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IpersonaServicio servicio;
    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona>personas=servicio.listar();
        model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona", new Persona());
        return "form";
    }
    @PostMapping("/save")
    public String guardar(@Validated Persona p, Model model){
        servicio.save(p);
        return "redirect:/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona>persona=servicio.listarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(Model model, @PathVariable int id){
        servicio.delete(id);
        return "redirect:/listar";
    }
}
