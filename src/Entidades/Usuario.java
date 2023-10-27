/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author FamiliaSic
 */
public class Usuario {
    
    
    private int idUsuario;
    
    private String nombreUsuario, nombre, apellido;

    private String claveUsuario;
    
    private String rango;
    
    private boolean estadoUsuario;

    public Usuario(String nombreUsuario, String nombre, String apellido, String claveUsuario, boolean estadoUsuario, String rango) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.claveUsuario = claveUsuario;
        this.estadoUsuario = estadoUsuario;
        this.rango = rango;
    }

    public Usuario(int idUsuario, String nombreUsuario, String nombre, String apellido, String claveUsuario, boolean estadoUsuario, String rango) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.claveUsuario = claveUsuario;
        this.estadoUsuario = estadoUsuario;
        this.rango = rango;
    }

    public Usuario(int idUsuario, String nombreUsuario, String nombre, String apellido, String claveUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.claveUsuario = claveUsuario;
        
    }
    
    

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

   

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public boolean isEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}
   