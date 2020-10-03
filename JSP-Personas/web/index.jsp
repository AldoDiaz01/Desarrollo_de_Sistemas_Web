<%-- 
    Document   : index
    Created on : 2/10/2020, 01:15:15 AM
    Author     : Asti Consultoria de Software
--%>

<%@page import="model.Persona"%>
<%@page import="java.util.List"%>
<%@page import="dao.personaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/styles.css" rel="stylesheet" type="text/css"/>
        <title>Inicio</title>
    </head>
    <%
        personaDAO personaDao = new personaDAO();
        List<Persona> personas = personaDao.findAll();
    %>

    <div>
        <div class="card">
            <h1>Agregar persona</h1>
            <form action="agregar.jsp" method="POST">

                <div class="form-group">
                    <label>ID:</label>
                    <input type="text" name="id" id="id">
                </div>

                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="nombre" id="nombre">
                </div>

                <div class="form-group">
                    <label>Dirección: </label>
                    <input type="text" name="direccion" id="direccion">
                </div>

                <div class="form-group">
                    <label>Telefono: </label>
                    <input type="text" name="telefono" id="telefono">
                </div>

                <div class="text-center">
                    <input type="submit" value="Guardar">
                </div>
            </form>
        </div>

        <div class="new-table">
            <h1>Personas</h1>
            <table >
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Acciones</th>
                </tr>
                <%  
                    int index = 0;
                    while (index < personas.size()) {
                %>
                <tr>
                    <td><%= personas.get(index).getId()%></td>
                    <td><%= personas.get(index).getNombre()%></td>
                    <td><%= personas.get(index).getDireccion()%></td>
                    <td><%= personas.get(index).getTelefono()%></td>
                    <td>
                        <input type="button" value="Editar">
                        <a href="eliminar.jsp?id=<%= personas.get(index).getId() %>" class="btn" >Eliminar</a>
                    </td>
                </tr>
                <%
                        index = index + 1;
                    }
                %>
            </table>
        </div>
    </div>
</body>
</html>
