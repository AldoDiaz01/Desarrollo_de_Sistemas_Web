<%-- 
    Document   : index
    Created on : 21/10/2020, 08:57:58 PM
    Author     : Luis Angel
--%>

<%@page import="javax.ejb.EJB"%>
<%@page import="SessionBean.calcularbean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="calcservlet" method="post">
            <input type="text" name="t1">
            <input type="text" name="t2">
            <input type="submit" value="sumar">
        </form>
    </body>
</html>