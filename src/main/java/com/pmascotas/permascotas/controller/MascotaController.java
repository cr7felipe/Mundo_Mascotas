package com.pmascotas.permascotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pmascotas.permascotas.model.entity.Mascota;
import com.pmascotas.permascotas.service.MascotaService;

@Controller
@RequestMapping(path = "/mascotas")
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    @GetMapping(path = "/mascotas")
    public String listarMascotas(Model model) {
        model.addAttribute("listarMascotas", mascotaService.getAllPets());
        return "listarMascotas";
    }

    @GetMapping(value = "/agregar")
    public String agregarProducto(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "mascotas/agregar_mascota";
    }
    
    @GetMapping("/mascota")
    public String mostrarMascotas(Model model) {
        model.addAttribute("allPets", mascotaService.getAllPets());
        return "";
    }

}
