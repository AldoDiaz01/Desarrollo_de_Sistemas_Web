package com.empresaurios.ejb.operations.client;

import com.empresaurios.ejb.operations.interfaces.IOperations;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author daniel
 */
public class Client {

    public static void main(String[] args) throws NamingException {
        String name = "java:global/ejb-operations/Operations!com.empresaurios.ejb.operations.interfaces.IOperations";
        Context jndi = new InitialContext();

        IOperations operations = (IOperations) jndi.lookup(name);

        System.out.println(operations.suma(2, 2));
    }
}
