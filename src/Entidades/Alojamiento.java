package Entidades;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author gustavo salgado
 */
public class Alojamiento {

    private int idAlojamiento;

    private LocalDate fechaIngreso;

    private LocalDate fechaEgreso;

    private boolean estado;

    private String servicio;

    private double importeDiario;
    
    private int cupoAlojamiento;

    private Ciudad ciudadDestino;

    public Alojamiento(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    

    public Alojamiento(LocalDate fechaIngreso, LocalDate fechaEgreso, boolean estado, double importeDiario) {
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.importeDiario = importeDiario;
    }

    public Alojamiento(LocalDate fechaIngreso, LocalDate fechaEgreso, boolean estado, String servicio, double importeDiario) {
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
    }

    public Alojamiento() {
    }

    public Alojamiento(LocalDate fechaIngreso, LocalDate fechaEgreso, boolean estado, String servicio, double importeDiario, Ciudad ciudadDestino) {
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
        this.ciudadDestino = ciudadDestino;
    }
    

    public Alojamiento(int Alojamiento, LocalDate fechaIngreso, LocalDate fechaEgreso, boolean estado, String servicio, double importeDiario, Ciudad ciudadDestino) {
        this.idAlojamiento = Alojamiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
        this.ciudadDestino = ciudadDestino;
    }

    public Alojamiento(int cupoAlojamiento) {
        this.cupoAlojamiento = cupoAlojamiento;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
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

    public int getCupoAlojamiento() {
        return cupoAlojamiento;
    }

    public void setCupoAlojamiento(int cupoAlojamiento) {
        this.cupoAlojamiento = cupoAlojamiento;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

   
 
    
}
