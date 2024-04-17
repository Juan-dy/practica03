package com.mycompany.practica3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        Estudiante obEst = new Estudiante();
        ArrayList<Estudiante> listaEst = (ArrayList<Estudiante>) sesion.getAttribute("l");

        int id, pos;

        String opcion = request.getParameter("o");
        switch (opcion) {
            case "n":
                request.setAttribute("objEst", obEst);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "ed":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarE(request, id);
                obEst = listaEst.get(pos);

                request.setAttribute("objEst", obEst);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;

            case "el":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarE(request, id);

                if (pos >= 0) {
                    listaEst.remove(pos);
                }
                request.setAttribute("l", listaEst);
                response.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Estudiante oE = new Estudiante();
        HttpSession sesion = request.getSession();

        ArrayList<Estudiante> arrayL = (ArrayList<Estudiante>) sesion.getAttribute("l");

        int id = Integer.parseInt(request.getParameter("id"));
        String[] sem = request.getParameterValues("sem");

        oE.setId(id);
        oE.setFecha(request.getParameter("fecha"));
        oE.setNombre(request.getParameter("nombre"));
        oE.setApellidos(request.getParameter("apellidos"));
        oE.setTurno(request.getParameter("turno"));

        oE.setSeminarios(sem);

        if (id == 0) {
            int idNuevo = idNuevo(request);
            oE.setId(idNuevo);
            arrayL.add(oE);
        } else {
            int pos = buscarE(request, id);
            arrayL.set(pos, oE);
        }

        request.setAttribute("l", arrayL);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    public int buscarE(HttpServletRequest request, int id) {
        HttpSession sesion = request.getSession();

        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) sesion.getAttribute("l");
        int posicion = -1;

        if (lista != null) {

            for (Estudiante item : lista) {
                posicion++;
                if (item.getId() == id) {
                    break;
                }
            }
        }
        return posicion;

    }

    public int idNuevo(HttpServletRequest request) {
        HttpSession sesion = request.getSession();

        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) sesion.getAttribute("l");

        int idNum = 0;

        for (Estudiante item : lista) {
            idNum = item.getId();
        }
        return idNum + 1;

    }

}
