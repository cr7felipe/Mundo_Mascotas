package com.pmascotas.permascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pmascotas.permascotas.model.entity.Mascota;

@Repository
public interface MascotaRepository extends CrudRepository<Mascota, Long> {
    @Query(value="select * from mascotas c where c.id_usuario = ?1 and c.estado = 'A'", nativeQuery = true)
	List<Mascota> findByUserId(Long idUsurio);

    @Query(value="update mascotas set c.estado='I' where c.id_usuario = ?1 and c.id_mascota = ?2", nativeQuery = true)
    Mascota updateByUserId(Long idUsurio, Long idMascota);
    
}
