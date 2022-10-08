package com.pmascotas.permascotas.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pmascotas.permascotas.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    @Query(value="select * from usuarios c where c.id_usuario = ?1 and c.password = ?2", nativeQuery = true)
	Usuario findByUserPassword(Long idUsuario, String password);

}
