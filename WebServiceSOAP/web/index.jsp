<%-- 
    Document   : index
    Created on : 11/11/2020, 03:04:58 PM
    Author     : Luis Angel
--%>

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
            String host = "localhost";// if you run your client and server sample on same machine
            String port = "3700";//default

            Properties prop = new Properties();
            prop.put("org.omg.CORBA.ORBInitialHost", host);
            prop.put("org.omg.CORBA.ORBInitialPort", port);
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            SumaBean bean = (SumaBean) envCtx.lookup("SumaBean/SumaBean");

            out.println(bean.sumar(2, 8));
        %>
    </body>
</html>
