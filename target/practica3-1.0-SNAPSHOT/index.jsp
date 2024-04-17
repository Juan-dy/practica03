<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.practica3.Estudiante"%>
<%
    if (session.getAttribute("l") == null) {
        ArrayList<Estudiante> arrayLista = new ArrayList<Estudiante>();
        session.setAttribute("l", arrayLista);
    }
    ArrayList<Estudiante> lista = (ArrayList<Estudiante>) session.getAttribute("l");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP</title>
    </head>
    <body>
        <h1>Listado de inscritos - Juan de Dios Mamani Mamani</h1>
        <a href="MainServlet?o=n">Nuevo</a>
        <table border="1px">
            <tr>
                <th>Id</th>
                <th>Fecha</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Turno</th>
                <th>Seminarios</th>
                <th></th>
                <th></th>
            </tr>

            <%                for (Estudiante item : lista) {

            %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getFecha()%></td>
                <td><%= item.getNombre()%></td>
                <td><%= item.getApellidos()%></td>
                <td><%= item.getTurno()%></td>
                <td><%
                    for (String is : item.getSeminarios()) {
                        
                        
                        %>
                        <%=is%>
                        <%
                    }
                    %></td>
                <td><a href="MainServlet?o=ed&id=<%= item.getId()%>">Editar</a></td>
                <td><a href="MainServlet?o=el&id=<%= item.getId()%>">Eliminar</a></td>
            </tr>
            <%
                }%>

        </table>

    </body>
</html>
