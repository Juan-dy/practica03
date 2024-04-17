<%@page import="com.mycompany.practica3.Estudiante"%>
<%
    Estudiante es = (Estudiante) request.getAttribute("objEst");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro en Seminarios</h1>
        <form method="post" action="MainServlet">
            <input type="hidden" name="id" value="<%= es.getId() %>">

                <table>
                    <tr>
                        <td>Fecha</td>
                        <td><input type="date" name="fecha" value="<%= es.getFecha() %>"></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" value="<%= es.getNombre() %>"></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="apellidos" value="<%= es.getApellidos() %>"></td>
                    </tr>
                    <tr>
                        <td>Turno</td>
                        <td><label><input type="radio" name="turno" value="mañana">Mañana</label>
                            <label><input type="radio" name="turno" value="tarde">Tarde</label>
                            <label><input type="radio" name="turno" value="noche">Noche</label></td>
                    </tr>
                </table>
           
                <label><input type="checkbox" name="sem" value="Inteligencia Artificial"> Inteligencia Artificial</label>
                <br>
                <label><input type="checkbox" name="sem" value="Machine Learning"> Machine Learning</label>
                <br>
                <label><input type="checkbox" name="sem" value="Simulacion con Arena"> Simulación con Arena</label>
                <br>
                <label><input type="checkbox" name="sem" value="Robotica Educativa"> Robotica Educativa</label>
            <br>
            <input type="submit">
        </form>
    </body>
</html>
