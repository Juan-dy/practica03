package com.mycompany.practica3;
import java.util.ArrayList;
public class Estudiante {
    
    private int id;
    private String fecha;
    private String nombre;
    private String apellidos;
    private String turno;
    private String[] sem;
    
    public Estudiante(){
        this.id = 0;
        this.fecha = "";
        this.nombre = "";
        this.apellidos = "";
        this.turno = "";
        this.sem = new String[5];
    }
    
    public int getId(){
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public String[] getSeminarios() {
        return sem;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setSeminarios(String[] seminarios) {
        this.sem = seminarios;
    }
    
    
    
}
