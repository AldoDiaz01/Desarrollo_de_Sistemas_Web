package com.empresaurios.uv.presidente;

import com.empresaurios.uv.partido.Partido;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_presidente")
public class Presidente {

    @Id
    @GenericGenerator(name = "id_presidente", strategy = "increment")
    @GeneratedValue(generator = "id_presidente")
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private int edad;
    @NotNull
    private int puestoRobado;
    @NotNull
    private int calidadGobierno;
    @NotNull
    @Column(name = "es_dios")
    private Boolean esDios;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "president_to_partido_fk"), name = "partido")
    private Partido partido;

    public Presidente() {
    }

    public Presidente(Integer id, @NotNull String nombre, @NotNull int edad, @NotNull int puestoRobado, @NotNull int calidadGobierno, @NotNull Boolean esDios) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puestoRobado = puestoRobado;
        this.calidadGobierno = calidadGobierno;
        this.esDios = esDios;
    }

    public Presidente(Integer id, @NotNull String nombre, @NotNull int edad, @NotNull int puestoRobado, @NotNull int calidadGobierno, @NotNull Boolean esDios, Partido partido) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puestoRobado = puestoRobado;
        this.calidadGobierno = calidadGobierno;
        this.esDios = esDios;
        this.partido = partido;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuestoRobado() {
        return puestoRobado;
    }

    public void setPuestoRobado(int puestoRobado) {
        this.puestoRobado = puestoRobado;
    }

    public int getCalidadGobierno() {
        return calidadGobierno;
    }

    public void setCalidadGobierno(int calidadGobierno) {
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
        return "Presidente{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", edad=" + edad
                + ", puestoRobado=" + puestoRobado
                + ", calidadGobierno=" + calidadGobierno
                + ", esDios=" + esDios
                + ", partido=" + partido
                + '}';
    }
}
