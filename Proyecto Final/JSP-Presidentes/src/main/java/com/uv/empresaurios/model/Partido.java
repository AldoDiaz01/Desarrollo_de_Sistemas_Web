package com.uv.empresaurios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_partido")
public class Partido {

    @Id
    @GenericGenerator(name = "id_usuario", strategy = "increment")
    @GeneratedValue(generator = "id_usuario")
    @Column(name = "id")
    private Integer id;

    private String nombre;

    private int antiguedad;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    public Partido() {
    }

    public Partido(Integer id, String nombre, int antiguedad, String nombreCompleto) {
        this.id = id;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    

}
