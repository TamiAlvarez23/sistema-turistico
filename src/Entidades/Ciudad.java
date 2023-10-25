package Entidades;

/**
 *
 * @author gustavo salgado
 */
public class Ciudad {

    private int idCiudad;

    private String nombre;

    private String pais;

    private boolean estado;

    private String provincia;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad(String nombre, String pais, boolean estado, String provincia) {
        this.nombre = nombre;
        this.pais = pais;
        this.estado = estado;
        this.provincia = provincia;
    }

    public Ciudad() {
    }

    public Ciudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    

    public Ciudad(int idCiudad, String nombre, String pais, boolean estado, String provincia) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.pais = pais;
        this.estado = estado;
        this.provincia = provincia;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
}
