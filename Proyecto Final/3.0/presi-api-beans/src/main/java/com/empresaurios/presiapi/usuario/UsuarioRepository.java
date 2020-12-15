package com.empresaurios.presiapi.usuario;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    List<Usuario> findByEmail(String email);
}
