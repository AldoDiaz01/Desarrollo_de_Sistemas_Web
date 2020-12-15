package com.uv.empresaurios.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

    @Id
    @GenericGenerator(name = "id_usuario", strategy = "increment")
    @GeneratedValue(generator = "id_usuario")
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "clave")
    private String clave;

    public Usuario() {
    }

    public Usuario(Integer id, String email, String clave) {
        this.id = id;
        this.email = email;
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", clave=" + clave + '}';
    }
    
    

}
