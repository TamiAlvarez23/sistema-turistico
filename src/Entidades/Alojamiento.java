package Entidades;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author gustavo salgado
 */
public class Alojamiento {

    private int idAlojamiento;

    private LocalDate fechaIngreso;//8

    private LocalDate fechaEgreso;//7

    private boolean estado;

    private String servicio;//9

    private double importeDiario;//6
    
    private int cupoAlojamiento;//5

    private Ciudad ciudadDestino;//3
    
    private String nombre;//1
    
    private String tipoAlojamiento;//2
    
    private String habilitacion;
    
    public Alojamiento() {
    }

    public Alojamiento(LocalDate fechaIngreso, LocalDate fechaEgreso, boolean estado, String servicio, double importeDiario, Ciudad ciudadDestino, String nombre, String tipoAlojamiento, int cupo) {
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
        this.ciudadDestino = ciudadDestino;
        this.nombre = nombre;
        this.tipoAlojamiento = tipoAlojamiento;
        this.cupoAlojamiento = cupo;
    }
    

    public Alojamiento(int idAlojamiento, LocalDate fechaIngreso, LocalDate fechaEgreso, boolean estado, String servicio, double importeDiario, Ciudad ciudadDestino, String nombre, String tipoAlojamiento, int cupo) {
        this.idAlojamiento = idAlojamiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
        this.ciudadDestino = ciudadDestino;
        this.nombre = nombre;
        this.tipoAlojamiento = tipoAlojamiento;
        this.cupoAlojamiento = cupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public String getHabilitacion() {
        if(estado){
            return "Habilitado";
        
        }else{
            return "Deshabiltado";
        
        }
    }
    
    

   
 
    
}
