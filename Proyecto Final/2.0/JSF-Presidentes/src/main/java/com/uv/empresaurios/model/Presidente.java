package com.uv.empresaurios.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_presidente")
public class Presidente implements Serializable {

    @Id
    @GenericGenerator(name = "id_presidente", strategy = "increment")
    @GeneratedValue(generator = "id_presidente")
    @Column(name = "id")
    private Integer id;

    private String nombre;

    private int edad;

    @Column(name = "calidad_gobierno")
    private int calidadGobierno;

    @Column(name = "es_dios")
    private boolean esDios;

    @Column(name = "puesto_robado")
    private String puestoRobado;

    //@ManyToOne()
    //@JoinColumn(foreignKey = @ForeignKey(name = "president_to_partido_fk"), name = "partido")
    private String partido;

    public Presidente() {
    }

    public Presidente(Integer id, String nombre, int edad, int calidadGobierno, boolean esDios, String puestoRobado, String partido) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.calidadGobierno = calidadGobierno;
        this.esDios = esDios;
        this.puestoRobado = puestoRobado;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCalidadGobierno() {
        return calidadGobierno;
    }

    public void setCalidadGobierno(int calidadGobierno) {
        this.calidadGobierno = calidadGobierno;
    }

    public boolean isEsDios() {
        return esDios;
    }

    public void setEsDios(boolean esDios) {
        this.esDios = esDios;
    }

    public String getPuestoRobado() {
        return puestoRobado;
    }

    public void setPuestoRobado(String puestoRobado) {
        this.puestoRobado = puestoRobado;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Presidente copy() {
        return new Presidente(id, nombre, edad, calidadGobierno, esDios, puestoRobado, partido);
    }

    public void restore(Presidente presidente) {
        this.id = presidente.getId();
        this.nombre = presidente.getNombre();
        this.edad = presidente.getEdad();
        this.calidadGobierno = presidente.getCalidadGobierno();
        this.esDios = presidente.isEsDios();
        this.puestoRobado = presidente.getPuestoRobado();
        this.partido = presidente.getPartido();
    }

}
