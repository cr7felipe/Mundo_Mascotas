package com.pmascotas.permascotas.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmascotas.permascotas.model.entity.Mascota;
import com.pmascotas.permascotas.repository.MascotaRepository;

@Service
public class MascotaService {
    @Autowired
    MascotaRepository mascotaRepository;

    // Guardar mascota.
    public void savePet(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

     // Consultar todas las mascotas.
     public Mascota getPetForId(Long idMascota) {
        return mascotaRepository.findById(idMascota).get();
    }

    // Consultar todas las mascotas.
    public ArrayList<Mascota> getAllPets() {
        return (ArrayList<Mascota>) mascotaRepository.findAll();
    }

    // Consultar las mascotas para un idUsuario.
    public ArrayList<Mascota> getPetsByIdUser(Long idUsuario) {
        ArrayList<Mascota> mascotasUsuario = (ArrayList<Mascota>) mascotaRepository.findByUserId(idUsuario);
        int cantMascotas = mascotasUsuario.size();
        System.out.println("cantMascotas: " + cantMascotas);
        return mascotasUsuario;
    }

    // Actualizar mascota.
    public Mascota updatePet(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // Eliminar mascota.
    public void deletePet(Long idMascota) {
        mascotaRepository.deleteById(idMascota);
    }
}
