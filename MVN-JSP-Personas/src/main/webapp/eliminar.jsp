<%-- 
    Document   : eliminar
    Created on : 3/10/2020, 04:49:33 AM
    Author     : Luis Angel
--%>

<%@page import="com.uv.empresaurios.jsp.personas.dao.PersonaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    PersonaDao personaDao = new PersonaDao();
    personaDao.delete(id);
    response.sendRedirect("index.jsp");
%>
