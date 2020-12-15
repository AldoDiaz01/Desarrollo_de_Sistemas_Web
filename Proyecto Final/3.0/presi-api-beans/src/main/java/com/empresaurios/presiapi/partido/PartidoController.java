package com.empresaurios.presiapi.partido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoRepository repository;

    @GetMapping
    public Iterable<Partido> get() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Partido getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Boolean post(@RequestBody Partido entity) {
        try {
            repository.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/{id}")
    public Boolean put(@PathVariable Integer id, @RequestBody Partido entity) {
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
