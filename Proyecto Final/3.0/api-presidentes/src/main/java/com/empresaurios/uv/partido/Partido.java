package com.empresaurios.uv.partido;

import javax.persistence.Column;
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
    @GenericGenerator(name = "id_partido", strategy = "increment")
    @GeneratedValue(generator = "id_partido")
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @NotNull
    private int antiguedad;

    public Partido() {
    }

    public Partido(Integer id) {
        this.id = id;
    }

    public Partido(Integer id, @NotNull String nombre, @NotNull String nombreCompleto, @NotNull int antiguedad) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCompleto = nombreCompleto;
        this.antiguedad = antiguedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "Presidente{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", nombreCompleto='" + nombreCompleto + '\''
                + ", antiguedad=" + antiguedad
                + '}';
    }
}
