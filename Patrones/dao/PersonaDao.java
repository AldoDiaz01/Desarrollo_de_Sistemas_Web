package com.combi.personasapi.dao;

import com.combi.personasapi.connection.ConnectionDB;
import com.combi.personasapi.model.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDao implements IDao<Persona, Integer> {

    @Override
    public Persona insert(Persona entidad) {
        String sql = "INSERT INTO personas(id, nombre, domicilio, telefono) VALUES("
                + entidad.getId() + ",'"
                + entidad.getNombre() + "','"
                + entidad.getDomicilio() + "', '"
                + entidad.getTelefono() + "')";

        return ConnectionDB.getInstance().execute(sql) ? entidad : null;
    }

    @Override
    public Persona update(Persona entidad) {
        String sql = "UPDATE personas SET "
                + "nombre = '" + entidad.getNombre() + "', "
                + "domicilio = '" + entidad.getDomicilio() + "', "
                + "telefono = '" + entidad.getTelefono() + "' "
                + "WHERE id = " + entidad.getId();

        return ConnectionDB.getInstance().execute(sql) ? entidad : null;
    }

    @Override
    public boolean delete(Integer id) {
        return ConnectionDB.getInstance().execute("DELETE FROM personas "
                + "WHERE id = '" + id + "'");
    }

    @Override
    public Persona find(Integer id) {
        Persona persona = null;

        try
        {
            ResultSet resultSet = ConnectionDB.getInstance().executeQuery("SELECT * FROM personas "
                    + "WHERE id = '" + id + "'");

            if(resultSet.next())
            {
                persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return persona;
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> personas = new ArrayList<>();

        try
        {
            ResultSet resultSet = ConnectionDB.getInstance().executeQuery("SELECT * FROM personas");

            while (resultSet.next())
            {
                personas.add(new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personas;
    }
}
