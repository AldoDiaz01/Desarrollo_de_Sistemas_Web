<%-- 
    Document   : eliminar
    Created on : 3/10/2020, 04:49:33 AM
    Author     : Luis Angel
--%>

<%@page import="dao.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    PersonaDAO personaDao = new PersonaDAO();
    personaDao.delete(id);
    response.sendRedirect("index.jsp");
%>
