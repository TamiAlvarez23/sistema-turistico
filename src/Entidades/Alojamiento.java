package Entidades;

import java.util.Date;

/**
 *
 * @author gustavo salgado
 */
public class Alojamiento {

    private int Alojamiento;

    private Date fechaIngreso;

    private Date fechaEgreso;

    private boolean estado;

    private String servicio;

    private double importeDiario;

    private Ciudad ciudadDestino;

    public Alojamiento() {
    }
    

    public Alojamiento(int Alojamiento, Date fechaIngreso, Date fechaEgreso, boolean estado, String servicio, double importeDiario, Ciudad ciudadDestino) {
        this.Alojamiento = Alojamiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
        this.ciudadDestino = ciudadDestino;
    }

    public int getAlojamiento() {
        return Alojamiento;
    }

    public void setAlojamiento(int Alojamiento) {
        this.Alojamiento = Alojamiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getImporteDiario() {
        return importeDiario;
    }

    public void setImporteDiario(double importeDiario) {
        this.importeDiario = importeDiario;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    
    
}
