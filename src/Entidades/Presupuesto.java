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
public class Presupuesto {
 
    
    private int idPresupuesto;
    
    private Paquete idPaquete;

    private String nombreCliente;

    private String apellidoCliente;

    private int dniCliente;

    private int telefonoCliente;

    private String mailCliente;
    
    private String pagoCliente;
    
    private String cuotasCliente;
    
    private Usuario idUsuario;
    
    public Presupuesto() {
    }

    public Presupuesto( Paquete idPaquete, String nombreCliente, String apellidoCliente, int dniCliente, int telefonoCliente, String mailCliente, String pagoCliente, String cuotasCliente, Usuario idUsuario) {
        this.idPaquete = idPaquete;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.dniCliente = dniCliente;
        this.telefonoCliente = telefonoCliente;
        this.mailCliente = mailCliente;
        this.pagoCliente = pagoCliente;
        this.cuotasCliente = cuotasCliente;
        this.idUsuario = idUsuario;
    }

    public Presupuesto(int idPresupuesto, Paquete idPaquete, String nombreCliente, String apellidoCliente, int dniCliente, int telefonoCliente, String mailCliente, String pagoCliente, String cuotasCliente, Usuario idUsuario) {
        this.idPresupuesto = idPresupuesto;
        this.idPaquete = idPaquete;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.dniCliente = dniCliente;
        this.telefonoCliente = telefonoCliente;
        this.mailCliente = mailCliente;
        this.pagoCliente = pagoCliente;
        this.cuotasCliente = cuotasCliente;
        this.idUsuario = idUsuario;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Paquete getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Paquete idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getMailCliente() {
        return mailCliente;
    }

    public void setMailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
    }

    public String getPagoCliente() {
        return pagoCliente;
    }

    public void setPagoCliente(String pagoCliente) {
        this.pagoCliente = pagoCliente;
    }

    public String getCuotasCliente() {
        return cuotasCliente;
    }

    public void setCuotasCliente(String cuotasCliente) {
        this.cuotasCliente = cuotasCliente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}




