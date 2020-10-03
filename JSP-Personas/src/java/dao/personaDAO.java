/*
 */
package dao;

import connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Persona;

/**
 *
 * @author Luis Angel
 */
public class personaDAO implements IDAO<Persona, Integer>{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        return ConnectionDB.getInstance().execute("DELETE FROM tb_personas WHERE id = '" + id + "'");
    }

    @Override
    public Persona find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> personas = new ArrayList<>();
        try{
            ResultSet rs = ConnectionDB.getInstance().executeQuery("SELECT * FROM tb_personas");
            while(rs.next()){
                personas.add(new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch(SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personas;
    }
    
}
