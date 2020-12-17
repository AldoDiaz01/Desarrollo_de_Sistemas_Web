package com.empresaurios.uv.partido;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PartidoRepository extends CrudRepository<Partido, Integer> {
    
    Optional<Partido> findByNombre(String nombre);
}
