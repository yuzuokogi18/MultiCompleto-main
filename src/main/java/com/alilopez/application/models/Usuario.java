package com.alilopez.application.models;

public class Usuario {
    private String nombre;
    private String contraseña;
    private int matricula;
    private String correo;
    private int cuatrimestre;

    public Usuario(String nombre, String contraseña, int matricula, String correo, int cuatrimestre) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.matricula = matricula;
        this.correo = correo;
        this.cuatrimestre = cuatrimestre;
    }

    public Usuario() {
        this.nombre = "Admin";
        this.contraseña = "1";
        this.matricula = 111111;
        this.correo = "Esmirna@ids.upchiapas.edu.mx";
        this.cuatrimestre = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Matrícula: " + matricula + ", Correo: " + correo + ", Cuatrimestre: " + cuatrimestre;
    }

    // Mtodo polimorfico con implementacion predeterminad tipo de polimorfismo es decir que aqi uso Sobrecarga
    public void realizarAccion() {
        System.out.println("Realizando acción genérica");
    }
}