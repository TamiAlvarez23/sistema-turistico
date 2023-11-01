package accesoADatos;

import Entidades.Ciudad;
import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo salgado
 */
public class PasajeData {
    
    private Connection con = null;
    CiudadData ciudadData = new CiudadData();

    public PasajeData() {

        con = Conexion.getConexion();

    }

    public void agregarPasaje(Pasaje pasaje) {
        String sql = "INSERT INTO Pasaje (tipoTransporte, importe, nombreCiudadOrigen, cupoPasaje, estado) VALUES (?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasaje.getTipoTransporte());
            ps.setDouble(2, pasaje.getImporte());
            ps.setInt(3, pasaje.getNombreCiudadOrigen().getIdCiudad());
            ps.setInt(4, pasaje.getCupo());
            ps.setBoolean(5, pasaje.isEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Pasaje " + e);
        }
    }

    public Pasaje obtenerPasajePorId(int idPasaje) {
        String sql = "SELECT * FROM Pasaje WHERE idPasaje = ?";
        Pasaje pasaje = null;
        

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPasaje);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idPasaje");
                String tipoTransporte = rs.getString("tipoTransporte");
                double importe = rs.getDouble("importe");
                
                Ciudad nombreCiudadOrigen = ciudadData.obtenerCiudadPorId(rs.getInt("nombreCiudadOrigen"));
                boolean estado = rs.getBoolean("estado");
                int cupo = rs.getInt("cupoPasaje");
                pasaje = new Pasaje(id, tipoTransporte, importe, nombreCiudadOrigen, estado, cupo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Pasaje");
        }
        return pasaje;
    }

    public List<Pasaje> obtenerTodosLosPasajes() {
        List<Pasaje> pasajes = new ArrayList<>();
        String selectQuery = "SELECT * FROM Pasaje";
        try (PreparedStatement ps = con.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idPasaje");
                String tipoTransporte = rs.getString("tipoTransporte");
                double importe = rs.getDouble("importe");
                Ciudad nombreCiudadOrigen = ciudadData.obtenerCiudadPorId(rs.getInt("nombreCiudadOrigen"));
                boolean estado = rs.getBoolean("estado");
                int cupo = rs.getInt("cupoPasaje");
                pasajes.add(new Pasaje(id, tipoTransporte, importe, nombreCiudadOrigen, estado, cupo));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Pasaje");
        }
        return pasajes;
    }
    public List<Pasaje> obtenerTodosLosPasajesActivos() {
        List<Pasaje> pasajes = new ArrayList<>();
        String selectQuery = "SELECT * FROM Pasaje where estado = 1";
        try (PreparedStatement ps = con.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idPasaje");
                String tipoTransporte = rs.getString("tipoTransporte");
                double importe = rs.getDouble("importe");
                Ciudad nombreCiudadOrigen = ciudadData.obtenerCiudadPorId(rs.getInt("nombreCiudadOrigen"));
                boolean estado = rs.getBoolean("estado");
                int cupo = rs.getInt("cupoPasaje");
                pasajes.add(new Pasaje(id, tipoTransporte, importe, nombreCiudadOrigen, estado, cupo));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Pasaje");
        }
        return pasajes;
    }
    
    

    public void actualizarPasaje(Pasaje pasaje) {
        String updateQuery = "UPDATE Pasaje SET tipoTransporte = ?, importe = ?, nombreCiudadOrigen = ?, cupoPasaje = ?,  estado = ? WHERE idPasaje = ?";
        
        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, pasaje.getTipoTransporte());
            ps.setDouble(2, pasaje.getImporte());
            ps.setInt(3, pasaje.getNombreCiudadOrigen().getIdCiudad());
            ps.setInt(4, pasaje.getCupo());
            ps.setBoolean(5, pasaje.isEstado());
            ps.setInt(6, pasaje.getIdPasaje());
            ps.executeUpdate();
            
            int exito = ps.executeUpdate();
         
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se modificó el pasaje con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Pasaje " +e);
        }
    }

    public void eliminarPasaje(int idPasaje) {
        String deleteQuery = "DELETE FROM Pasaje WHERE idPasaje = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, idPasaje);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Pasaje");
        }
    }
}
