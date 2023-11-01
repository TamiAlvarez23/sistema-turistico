package Entidades;

/**
 *
 * @author gustavo salgado
 */
public class Paquete {

    private int idPaquete;

    private Ciudad origen;

    private Ciudad destino;

    private Alojamiento alojamiento;

    private boolean estado;

    private Pasaje pasaje;
    
    private int cupo;
    
    private String Habilitacion;
    
    public Paquete() {
    }

    public Paquete(int idPaquete, Ciudad origen, Ciudad destino, Alojamiento alojamiento, boolean estado, Pasaje pasaje, int cupo) {
        this.idPaquete = idPaquete;
        this.origen = origen;
        this.destino = destino;
        this.alojamiento = alojamiento;
        this.estado = estado;
        this.pasaje = pasaje;
        this.cupo = cupo;
    }

    public Paquete(Ciudad origen, Ciudad destino, Alojamiento alojamiento, boolean estado, Pasaje pasaje, int cupo) {
        this.origen = origen;
        this.destino = destino;
        this.alojamiento = alojamiento;
        this.estado = estado;
        this.pasaje = pasaje;
        this.cupo = cupo;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Pasaje getPasaje() {
        return pasaje;
    }

    public void setPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getHabilitacion() {
       if(estado){
           return "Habilitado";
           
       
       }else{
           return "Deshabilitado";
       }
    }

    
    
    
    
    
    
    
}
