package Entidades;

import java.time.LocalDate;

/**
 *
 * @author gustavo salgado
 */
public class Pasaje {

    private int idPasaje;

    private String TipoTransporte;

    private double Importe;

    public Ciudad nombreCiudadOrigen;

    private boolean estado;

    private LocalDate fechaSalida;

    private LocalDate fechaRegreso;

    public Pasaje(int idPasaje, String TipoTransporte, double Importe, Ciudad nombreCiudadOrigen, boolean estado, LocalDate fechaSalida, LocalDate fechaRegreso) {
        this.idPasaje = idPasaje;
        this.TipoTransporte = TipoTransporte;
        this.Importe = Importe;
        this.nombreCiudadOrigen = nombreCiudadOrigen;
        this.estado = estado;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = this.fechaRegreso;
    }

    public Pasaje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(LocalDate fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }
    
    

    public String getTipoTransporte() {
        return TipoTransporte;
    }

    public void setTipoTransporte(String TipoTransporte) {
        this.TipoTransporte = TipoTransporte;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    public Ciudad getNombreCiudadOrigen() {
        return nombreCiudadOrigen;
    }

    public void setNombreCiudadOrigen(Ciudad nombreCiudadOrigen) {
        this.nombreCiudadOrigen = nombreCiudadOrigen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
