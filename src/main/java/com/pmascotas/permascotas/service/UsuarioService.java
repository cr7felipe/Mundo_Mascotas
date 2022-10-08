package com.pmascotas.permascotas.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmascotas.permascotas.model.entity.Usuario;
import com.pmascotas.permascotas.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
 
    // Guardar un usuario
    public void saveUser(Usuario usuario) {
        usuarioRepository.save(usuario);
    }  

    // Consultar un usuario
    public Usuario findByIdUser(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    // Obtener una lista de usuarios
    public List<Usuario> findAllUser() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        return usuarios;
    }

    // Consultar un usurio por idUsuario y Password.
    public Usuario findByIdUserPassword(Long idUsuario, String password) {
        Usuario usuario = usuarioRepository.findByUserPassword(idUsuario, password);
        return usuario;
    }

    // Actualizar usuario
    public Usuario updateUsuario(Usuario idUsuario) {
        return usuarioRepository.save(idUsuario);
    }

    // Elimiar un usuario por idUsuario.
    public boolean deleteUser(Long idUsuario) {
        try {
            usuarioRepository.deleteById(idUsuario);
            return true;
        } catch(Exception err) {
            return false;
        }
    }
}
