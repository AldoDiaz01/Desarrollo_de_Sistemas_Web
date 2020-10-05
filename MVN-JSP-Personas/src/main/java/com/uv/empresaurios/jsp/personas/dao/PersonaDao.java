/*
 */
package com.uv.empresaurios.jsp.personas.dao;

import com.uv.empresaurios.jsp.personas.connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.uv.empresaurios.jsp.personas.model.Persona;

/**
 *
 * @author Luis Angel
 */
public class PersonaDao implements IDAO<Persona, Integer>{

    @Override
    public Persona insert(Persona entidad) {
        String sql = "INSERT INTO tb_personas(id, nombre,direccion,telefono) VALUES(" +
                entidad.getId() + ",'" +
                entidad.getNombre() + "','" +
                entidad.getDireccion() + "','" +
                entidad.getTelefono() + "') ";
        return ConnectionDB.getInstance().execute(sql) ? entidad : null;
    }

    @Override
    public Persona update(Persona entidad) {
        String sql = "UPDATE tb_personas SET "
                + "nombre = '" + entidad.getNombre() + "', "
                + "direccion = '" + entidad.getDireccion() + "', "
                + "telefono = '" + entidad.getTelefono() + "' WHERE id = " + entidad.getId();
        return ConnectionDB.getInstance().execute(sql) ? entidad : null;
    }

    @Override
    public boolean delete(Integer id) {
        return ConnectionDB.getInstance().execute("DELETE FROM tb_personas WHERE id = '" + id + "'");
    }

    @Override
    public Persona find(Integer id) {
        Persona persona = null;
        try{
            ResultSet rs = ConnectionDB.getInstance().executeQuery("SELECT * FROM tb_personas WHERE id = '" + id + "'");
            if(rs.next()){
                persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persona;
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> personas = new ArrayList<>();
        try{
            ResultSet rs = ConnectionDB.getInstance().executeQuery("SELECT * FROM tb_personas ORDER BY id");
            while(rs.next()){
                personas.add(new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch(SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personas;
    }
    
}
