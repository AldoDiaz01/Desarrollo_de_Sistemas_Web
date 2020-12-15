package com.empresaurios.uv.presidente;

import com.empresaurios.uv.partido.Partido;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_presidente")
public class Presidente {

    @Id
    @GeneratedValue(generator = "increment_gen")
    @GenericGenerator(name = "increment_gen", strategy = "increment")
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private Double edad;
    @NotNull
    private Integer puestoRobado;
    @NotNull
    private Integer calidadGobierno;
    @NotNull
    private Boolean esDios;
    @ManyToOne
    private Partido partido;

    public Presidente() {
    }

    public Presidente(Integer id, @NotNull String nombre, @NotNull Double edad, @NotNull Integer puestoRobado, @NotNull Integer calidadGobierno, @NotNull Boolean esDios) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puestoRobado = puestoRobado;
        this.calidadGobierno = calidadGobierno;
        this.esDios = esDios;
    }

    public Presidente(Integer id, @NotNull String nombre, @NotNull Double edad, @NotNull Integer puestoRobado, @NotNull Integer calidadGobierno, @NotNull Boolean esDios, Partido partido) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puestoRobado = puestoRobado;
        this.calidadGobierno = calidadGobierno;
        this.esDios = esDios;
        this.partido = partido;
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

    public Double getEdad() {
        return edad;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }

    public Integer getPuestoRobado() {
        return puestoRobado;
    }

    public void setPuestoRobado(Integer puestoRobado) {
        this.puestoRobado = puestoRobado;
    }

    public Integer getCalidadGobierno() {
        return calidadGobierno;
    }

    public void setCalidadGobierno(Integer calidadGobierno) {
        this.calidadGobierno = calidadGobierno;
    }

    public Boolean getEsDios() {
        return esDios;
    }

    public void setEsDios(Boolean esDios) {
        this.esDios = esDios;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "Presidente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", puestoRobado=" + puestoRobado +
                ", calidadGobierno=" + calidadGobierno +
                ", esDios=" + esDios +
                ", partido=" + partido +
                '}';
    }
}
