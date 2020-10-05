<%-- 
    Document   : editar
    Created on : 3/10/2020, 04:11:31 PM
    Author     : Luis Angel
--%>

<%@page import="com.uv.empresaurios.jsp.personas.dao.PersonaDao"%>
<%@page import="com.uv.empresaurios.jsp.personas.model.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/styles.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar</title>
    </head>
    <body>
        <% 
            int id = Integer.parseInt(request.getParameter("id"));
            PersonaDao personaDao = new PersonaDao();
            Persona persona = personaDao.find(id);
        %>
        <div class="card">
            <h1>Actualizar persona</h1>
            <form action="editar.jsp" method="PUT">

                <div class="form-group">
                    <label>ID:</label>
                    <input type="text" readonly="" name="id" id="id" value="<%= persona.getId() %>">
                </div>

                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="nombre" id="nombre" value="<%= persona.getNombre() %>">
                </div>

                <div class="form-group">
                    <label>Dirección: </label>
                    <input type="text" name="direccion" id="direccion" value="<%= persona.getDireccion() %>">
                </div>

                <div class="form-group">
                    <label>Telefono: </label>
                    <input type="text" name="telefono" id="telefono" value="<%= persona.getTelefono() %>">
                </div>

                <div class="text-center">
                    <input type="submit" value="Actualizar">
                    <input type="button" value="Regresar" onclick="location.href='index.jsp'">
                </div>
            </form>
        </div>
    </body>
</html>

<%
    String nombre = request.getParameter("nombre");
    String direccion = request.getParameter("direccion");
    String telefono = request.getParameter("telefono");
    
    if(nombre!=null && direccion!=null && telefono!=null) {
        persona.setNombre(nombre);
        persona.setDireccion(direccion);
        persona.setTelefono(telefono);
        personaDao.update(persona);
        response.sendRedirect("index.jsp");
    }
%>

