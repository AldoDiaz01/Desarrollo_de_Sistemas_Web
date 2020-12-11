package com.empresaurios.ejb.operations.client;

import com.empresaurios.ejb.operations.interfaces.IOperations;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 *
 * @author daniel
 */
public class Client {

    public static void main(String[] args) throws NamingException {

        try {
            String host = "localhost";// if you run your client and server sample on same machine
            String port = "3700";//default

            Properties prop = new Properties();
            prop.put("org.omg.CORBA.ORBInitialHost", host);
            prop.put("org.omg.CORBA.ORBInitialPort", port);
            InitialContext context = new InitialContext(prop);
            System.out.println(" >> Obtenido un contexto JNDI");

            // Obtener una referencia al Bean
            IOperations operations = (IOperations) context.lookup("java:global/ejb-operations/Operations!com.empresaurios.ejb.operations.interfaces.IOperations"); // Nombre del ejb en el ejb-jar.xml
            System.out.println(" >> Obtenida una referencia al Bean \"EJB Operations\"");
            

            System.out.println(operations.suma(2, 8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
