package com.pmascotas.permascotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pmascotas.permascotas.model.entity.Mascota;
import com.pmascotas.permascotas.model.entity.Usuario;
import com.pmascotas.permascotas.service.MascotaService;
import com.pmascotas.permascotas.service.UsuarioService;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    MascotaService mascotaService;

    @GetMapping({ "/", "HOME", "index" })
    public String home(Model model) {
        model.addAttribute("allPets", mascotaService.getAllPets());
        return "home";
    }

    @GetMapping("/irSesion")
    public String oauth(Model model) {
        model.addAttribute("usuarioLogueado", new Usuario());
        return "inicio_sesion";
    }

    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@ModelAttribute("usuarioLogueado") Usuario user, Model model) {
        Usuario usuario = usuarioService.findByIdUserPassword(user.getIdUsuario(), user.getPassword());
        if (usuario.getIdUsuario() != 0) {
            model.addAttribute("idUsuario", usuario.getIdUsuario());
            model.addAttribute("email", usuario.getEmail());
            model.addAttribute("misMascotas", mascotaService.getPetsByIdUser(usuario.getIdUsuario()));
            return "mis_mascotas";
        } else {
            return "credenciales_incorrectas";
        }
    }

    @PostMapping(value = "/eliminar")
    public String eliminarProducto(@ModelAttribute Mascota mascota, RedirectAttributes redirectAttrs) {
    redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("clase", "warning");
    mascotaService.deletePet(mascota.getIdMascota());
    System.out.println("Mascota eliminada con exito!");
    return "redirect:/mis_mascotas";
}

    @GetMapping("/irRegistrarUsuario")
    public String irFormularioUsurio(Model model) {
        model.addAttribute("usuarioNuevo", new Usuario());
        return "registrar_usuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario user) {
        usuarioService.saveUser(user);
        System.out.println("Usuario guardado con exito!");
        return "redirect:/";
    }

}
