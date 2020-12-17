package com.empresaurios.uv.partido;

import org.springframework.data.repository.CrudRepository;

public interface PartidoRepository extends CrudRepository<Partido, Integer> {
    
     Partido findByNombre(String nombre);
    
}
