package com.empresaurios.uv.partido;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PartidoRepository extends CrudRepository<Partido, Integer> {
    
     List<Partido> findByNombre(String nombre);
    
}
