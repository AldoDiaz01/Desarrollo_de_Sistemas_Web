package com.combi.personasapi.connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
    private final String url = "jdbc:postgresql://localhost/testing?user=postgres&password=root";

    private Connection connection = null;

    private static ConnectionDB instance = null;

    private ConnectionDB() {
        try {
            connection = DriverManager.getConnection(url);
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.INFO, "Conexión exitosa");
        } catch (SQLException e) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, "There was an error", e);
        }
    }

    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }

        return instance;
    }

    public boolean execute(String sql) {
        boolean result = false;
        int rows = 0;

        try {
            Statement st = connection.createStatement();

            rows = st.executeUpdate(sql);

            if (rows != 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet result = null;

        try {
            Statement st = connection.createStatement();

            result = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
