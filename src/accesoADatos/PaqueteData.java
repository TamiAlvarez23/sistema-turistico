
package accesoADatos;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import Entidades.Paquete;
import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo salgado
 */
public class PaqueteData {
     private Connection con = null;
     private CiudadData cd = new CiudadData();
     private  AlojamientoData ad= new AlojamientoData();
     private PasajeData pd=new PasajeData();

    public PaqueteData() {
        con = Conexion.getConexion();
    }
    
    
 public void agregarPaquete(Paquete paquete) {
        String sql = "INSERT INTO Paquete (origen, destino, alojamiento, pasaje) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, paquete.getOrigen().getIdCiudad()); 
            ps.setInt(2, paquete.getDestino().getIdCiudad()); 
            ps.setInt(3, paquete.getAlojamiento().getAlojamiento());
            ps.setInt(4, paquete.getPasaje().getIdPasaje()); 
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al acceder a tabla paquete" );
        }
    }

    public Paquete obtenerPaquetePorId(int idPaquete) {
        String sql = "SELECT * FROM Paquete WHERE idPaquete = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPaquete);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               Paquete paquete=new Paquete();
               paquete.setIdPaquete(idPaquete);
                paquete.setOrigen((Ciudad) rs.getObject("origen"));
                paquete.setDestino((Ciudad) rs.getObject("destino"));
                paquete.setAlojamiento((Alojamiento) rs.getObject("alojamiento"));
                paquete.setPasaje((Pasaje) rs.getObject("pasaje"));
                
               
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al acceder a tabla paquete" );
        }
        return null;
    }

    public List<Paquete> obtenerTodosLosPaquetes() {
        List<Paquete> paquetes = new ArrayList<>();
        String sql = "SELECT * FROM Paquete";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
                
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paquete paquete=new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                Ciudad ciu=cd.obtenerCiudadPorId(rs.getInt("origen"));
                Ciudad ciu2=cd.obtenerCiudadPorId(rs.getInt("destino"));
                Alojamiento alo=ad.obtenerAlojamientoPorId(rs.getInt(sql));
                Pasaje pas=pd.obtenerPasajePorId(rs.getInt("pasaje"));
                paquetes.add(paquete);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al acceder a tabla paquete" );
        }
        return paquetes;
    }

    public void actualizarPaquete(Paquete paquete) {
        String sql = "UPDATE Paquete SET origen = ?, destino = ?, alojamiento = ?, pasaje = ? WHERE idPaquete = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, paquete.getOrigen().getIdCiudad()); 
            ps.setInt(2, paquete.getDestino().getIdCiudad()); 
            ps.setInt(3, paquete.getAlojamiento().getAlojamiento()); 
            ps.setInt(4, paquete.getPasaje().getIdPasaje()); 
            ps.setInt(5, paquete.getIdPaquete());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al acceder a tabla paquete" );
        }
    }

    public void eliminarPaquete(int idPaquete) {
        String sql = "DELETE FROM Paquete WHERE idPaquete = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPaquete);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al acceder a tabla paquete" );
        }
    }
}
