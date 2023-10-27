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

    public PasajeData() {

        con = Conexion.getConexion();

    }

    public void agregarPasaje(Pasaje pasaje) {
        String sql = "INSERT INTO Pasaje (tipoTransporte, importe, nombreCiudadOrigen, estado, fechaSalida, fechaRegreso) VALUES (?, ?, ?, ?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasaje.getTipoTransporte());
            ps.setDouble(2, pasaje.getImporte());
            ps.setObject(3, pasaje.getNombreCiudadOrigen());
            ps.setBoolean(4, pasaje.isEstado());
            ps.setDate(5, Date.valueOf(pasaje.getFechaSalida()));
            ps.setDate(6, Date.valueOf(pasaje.getFechaRegreso()));
            
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla pasaje");
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
                Ciudad nombreCiudadOrigen = (Ciudad) rs.getObject("nombreCiudadOrigen");
                boolean estado = rs.getBoolean("estado");
                LocalDate fechaSalida = rs.getDate("fechaSalida").toLocalDate();
                LocalDate fechaRegreso = rs.getDate("fechaRegreso").toLocalDate();
                pasaje = new Pasaje(id, tipoTransporte, importe, nombreCiudadOrigen, estado, fechaSalida, fechaRegreso);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla pasaje");
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
                Ciudad nombreCiudadOrigen = (Ciudad) rs.getObject("nombreCiudadOrigen");
                boolean estado = rs.getBoolean("estado");
                LocalDate fechaSalida = rs.getDate("fechaSalida").toLocalDate();
                LocalDate fechaRegreso = rs.getDate("fechaRegreso").toLocalDate();
                pasajes.add(new Pasaje(id, tipoTransporte, importe, nombreCiudadOrigen, estado, fechaSalida, fechaRegreso));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla pasaje");
        }
        return pasajes;
    }

    public void actualizarPasaje(Pasaje pasaje) {
        String updateQuery = "UPDATE Pasaje SET tipoTransporte = ?, importe = ?, nombreCiudadOrigen = ?, estado = ? ,fechaSalida = ?, fechaRegreso = ?  WHERE idPasaje = ?";
        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, pasaje.getTipoTransporte());
            ps.setDouble(2, pasaje.getImporte());
            ps.setObject(3, pasaje.getNombreCiudadOrigen());
            ps.setBoolean(4, pasaje.isEstado());
            ps.setDate(5, Date.valueOf(pasaje.getFechaSalida()));
            ps.setDate(6, Date.valueOf(pasaje.getFechaRegreso()));
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de pasaje");
        }
    }

    public void eliminarPasaje(int idPasaje) {
        String deleteQuery = "DELETE FROM Pasaje WHERE idPasaje = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, idPasaje);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla pasaje");
        }
    }
}
