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

    public Pasaje(String TipoTransporte, double Importe, Ciudad nombreCiudadOrigen, boolean estado) {
        this.TipoTransporte = TipoTransporte;
        this.Importe = Importe;
        this.nombreCiudadOrigen = nombreCiudadOrigen;
        this.estado = estado;
    }

 

    public Pasaje(int idPasaje, String TipoTransporte, double Importe, Ciudad nombreCiudadOrigen, boolean estado) {
        this.idPasaje = idPasaje;
        this.TipoTransporte = TipoTransporte;
        this.Importe = Importe;
        this.nombreCiudadOrigen = nombreCiudadOrigen;
        this.estado = estado;
    }

    public Pasaje() {
    }

    public int getIdPasaje() {
        return idPasaje;
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
