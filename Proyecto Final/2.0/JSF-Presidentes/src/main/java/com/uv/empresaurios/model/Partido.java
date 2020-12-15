package com.uv.empresaurios.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_partido")
public class Partido implements Serializable{

    @Id
    @GenericGenerator(name = "id_partido", strategy = "increment")
    @GeneratedValue(generator = "id_partido")
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
    
    public Partido copy() {
        return new Partido(id, nombre, antiguedad,nombreCompleto);
    }

    public void restore(Partido partido) {
        this.id = partido.getId();
        this.nombre = partido.getNombre();
        this.antiguedad = partido.getAntiguedad();
        this.nombreCompleto = partido.getNombreCompleto();
    }

}
