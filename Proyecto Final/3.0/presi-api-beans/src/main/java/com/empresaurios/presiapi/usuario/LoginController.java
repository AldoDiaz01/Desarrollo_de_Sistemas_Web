package com.empresaurios.presiapi.usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Map<String, String> login(@RequestParam("email") String email, @RequestParam("clave") String clave) {
        List<Usuario> lstAdminExist = repository.findByEmail(email);
        HashMap<String, String> map = new HashMap<>();
        if (lstAdminExist.isEmpty()) {
            map.put("message", "El email del usuario esta incorrecto");
        } else {
            if (lstAdminExist.get(0).getClave().equals(clave)) {
                map.put("key", getJWTToken(email));
                return map;
            }
        }
        map.put("message", "Clave incorrecta");
        return map;
    }

    private String getJWTToken(String username) {
        String secretKey = "solcov_secret";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("solcovJWT")
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 6000000)) // 1 hora
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return token;
    }
}
