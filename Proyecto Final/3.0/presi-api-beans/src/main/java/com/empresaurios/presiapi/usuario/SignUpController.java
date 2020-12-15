package com.empresaurios.presiapi.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Boolean post(@RequestBody Usuario entity) {
        try {
            repository.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
