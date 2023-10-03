
package accesoADatos;

import Entidades.Alojamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gustavo salgado
 */
public class AlojamientoData {

    private Connection con = null;

    public AlojamientoData() {
        con = Conexion.getConexion();
    }

    public void agregarAlojamiento(Alojamiento alojamiento) {
        String sql = "INSERT INTO Alojamiento (fechaIngreso, fechaEgreso, estado, servicio, importeDiario, ciudadDestino) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, (Date) alojamiento.getFechaIngreso());
            ps.setDate(2, (Date) alojamiento.getFechaEgreso());
            ps.setBoolean(3, alojamiento.isEstado());
            ps.setString(4, alojamiento.getServicio());
            ps.setDouble(5, alojamiento.getImporteDiario());
            ps.setInt(6, alojamiento.getCiudadDestino().getIdCiudad()); 
            ps.executeUpdate();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla alojamiento");
        }
    }

    public Alojamiento obtenerAlojamientoPorId(int idAlojamiento) {
        String sql = "SELECT * FROM Alojamiento WHERE idAlojamiento = ?";
        
        try { 
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, idAlojamiento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               int id = rs.getInt("idAlojamiento");
               return new Alojamiento();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alojamiento");
        }
        return null;
    }

    public List<Alojamiento> obtenerTodosLosAlojamientos() {
        
        List<Alojamiento> alojamientos = new ArrayList<>();
        String sql = "SELECT * FROM Alojamiento";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql) ;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alojamiento alojamiento=new Alojamiento();
                alojamiento.setAlojamiento(rs.getInt("idAlumno"));
                alojamiento.setFechaIngreso(rs.getDate("fechaIngreso"));
                alojamiento.setFechaEgreso(rs.getDate("fechaEgreso"));
                alojamiento.setEstado(true);
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setImporteDiario(rs.getDouble("importeDiario"));
//                alojamiento.setCiudadDestino(rs.gets("ciudadDestino"));
                alojamientos.add(alojamiento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alojamiento");
        }
        return alojamientos;
    }

    public void actualizarAlojamiento(Alojamiento alojamiento) {
        String sql = "UPDATE Alojamiento SET fechaIngreso = ?, fechaEgreso = ?, estado = ?, servicio = ?, importeDiario = ?, ciudadDestino = ? WHERE idAlojamiento = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setDate(1, (Date) alojamiento.getFechaIngreso());
            ps.setDate(2, (Date) alojamiento.getFechaEgreso());
            ps.setBoolean(3, alojamiento.isEstado());
            ps.setString(4, alojamiento.getServicio());
            ps.setDouble(5, alojamiento.getImporteDiario());
            ps.setInt(6, alojamiento.getCiudadDestino().getIdCiudad()); 
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alojamiento");
        }
    }

    public void eliminarAlojamiento(int idAlojamiento) {
        String sql = "DELETE FROM Alojamiento WHERE idAlojamiento = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlojamiento);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alojamiento");
        }
    }
}
