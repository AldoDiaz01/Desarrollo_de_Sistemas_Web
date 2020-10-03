<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso JavaBeans</title>
    </head>
    <body>
        <jsp:useBean id="rectangulo" class="com.cov.crud.jsp.Bean.Rectangulo" scope="page"/>

        <jsp:setProperty name="rectangulo" property="base" value="20"/>
        <jsp:setProperty name="rectangulo" property="altura" value="10"/>

        Base: ${rectangulo.base}
        <br/><br/>
        Altura: ${rectangulo.altura}
        <br/><br/>
        Area: ${rectangulo.area}
        <br/><br/>
        <a href="/Crud-JSP/index.jsp">Regresar al inicio</a>
    </body>
</html>
