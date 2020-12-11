<%-- 
    Document   : index
    Created on : 11/11/2020, 03:04:58 PM
    Author     : Luis Angel
--%>

<%@page import="com.empresaurios.bean.BeanOperations"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="com.empresaurios.bean.SumaBean"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.activation.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Properties prop = new Properties();
            prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            prop.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.setProperty(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            prop.setProperty(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
            Context context = new InitialContext();
            Context envCtx = (Context) context.lookup("java:comp/env");
            BeanOperations bean = (BeanOperations) envCtx.lookup("BeanSuma/BeanOperations");

            out.println("La suma es: " + bean.sumar(2, 8));
        %>
    </body>
</html>
