package com.empresaurios.presiapi.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public Iterable<Usuario> get() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Boolean put(@PathVariable Integer id, @RequestBody Usuario entity) {
        try {
            entity.setId(id);
            repository.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
