<%-- 
    Document   : agregar
    Created on : 3/10/2020, 03:40:08 AM
    Author     : Luis Angel
--%>

<%@page import="com.uv.empresaurios.jsp.personas.dao.PersonaDao"%>
<%@page import="com.uv.empresaurios.jsp.personas.model.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Persona persona = new Persona();
    persona.setId(Integer.parseInt(request.getParameter("id")));
    persona.setNombre(request.getParameter("nombre"));
    persona.setDireccion(request.getParameter("direccion"));
    persona.setTelefono(request.getParameter("telefono"));
    PersonaDao personaDao = new PersonaDao();
    if (persona.getNombre() != null && persona.getDireccion() != null && persona.getTelefono() != null) {
        personaDao.insert(persona);
    }
    response.sendRedirect("index.jsp");
%>