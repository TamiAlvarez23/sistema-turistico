package accesoADatos;


import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo salgado
 */
public class PasajeData {

    private Connection con = null;
   
    
    
    public PasajeData (){

    con = Conexion.getConexion();
    
    }

    public void agregarPasaje(Pasaje pasaje) {
        String sql = "INSERT INTO Pasaje (tipoTransporte, importe, nombreCiudadOrigen, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasaje.getTipoTransporte());
            ps.setDouble(2, pasaje.getImporte());
            ps.setString(3, pasaje.getNombreCiudadOrigen().getNombre());
            ps.setBoolean(4, pasaje.isEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se pudo acceder a la tabla pasaje");
        }
    }

    public Pasaje obtenerPasajePorId(int idPasaje) {
        String sql = "SELECT * FROM Pasaje WHERE idPasaje = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPasaje);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idPasaje");
                String tipoTransporte = rs.getString("tipoTransporte");
                double importe = rs.getDouble("importe");
                String nombreCiudadOrigen = rs.getString("nombreCiudadOrigen");
                boolean estado = rs.getBoolean("estado");
                return new Pasaje(id, tipoTransporte, importe, nombreCiudadOrigen, estado);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "no se pudo acceder a la tabla pasaje");
        }
        return null;
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
                String nombreCiudadOrigen = rs.getString("nombreCiudadOrigen");
                boolean estado = rs.getBoolean("estado");
                pasajes.add(new Pasaje(id, tipoTransporte, importe, nombreCiudadOrigen, estado));
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "no se pudo acceder a la tabla pasaje");
        }
        return pasajes;
    }

    public void actualizarPasaje(Pasaje pasaje) {
        String updateQuery = "UPDATE Pasaje SET tipoTransporte = ?, importe = ?, nombreCiudadOrigen = ?, estado = ? WHERE idPasaje = ?";
        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, pasaje.getTipoTransporte());
            ps.setDouble(2, pasaje.getImporte());
            ps.setString(3, pasaje.getNombreCiudadOrigen().getNombre());
            ps.setBoolean(4, pasaje.isEstado());
            ps.setInt(5, pasaje.getIdPasaje());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de pasaje");
        }
    }

    public void eliminarPasaje(int idPasaje) {
        String deleteQuery = "DELETE FROM Pasaje WHERE idPasaje = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, idPasaje);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se pudo acceder a la tabla pasaje");
        }
    }
}
