package com.empresaurios.presiapi.partido;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_partido")
public class Partido {

    @Id
    @GeneratedValue(generator = "increment_gen")
    @GenericGenerator(name = "increment_gen", strategy = "increment")
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private String nombreCompleto;
    @NotNull
    private Integer antiguedad;

    public Partido() {
    }

    public Partido(Integer id, @NotNull String nombre, @NotNull String nombreCompleto, @NotNull Integer antiguedad) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCompleto = nombreCompleto;
        this.antiguedad = antiguedad;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Presidente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", antiguedad=" + antiguedad +
                '}';
    }
}
