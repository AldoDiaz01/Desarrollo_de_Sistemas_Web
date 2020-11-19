/*
 */
package com.empresaurios.webservice;

import com.empresaurios.bean.BeanOperations;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Luis Angel
 */
@WebService(serviceName = "SumaWBS")
public class SumaWBS {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "suma")
    public Integer suma(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        try {
            Properties prop = new Properties();
            prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            prop.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.setProperty(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            prop.setProperty(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
            Context context = new InitialContext();
            Context envCtx = (Context) context.lookup("java:comp/env");
            BeanOperations bean = (BeanOperations) envCtx.lookup("BeanSuma/BeanOperations");
            return bean.sumar(num1, num2);
        } catch (NamingException ex) {
            Logger.getLogger(SumaWBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

}
