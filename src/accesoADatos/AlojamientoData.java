package accesoADatos;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author gustavo salgado
 */
public class AlojamientoData {

    private Connection con = null;
    private CiudadData cd = new CiudadData();

    public AlojamientoData() {
        con = Conexion.getConexion();
    }

    public void agregarAlojamiento(Alojamiento alojamiento) {
        String sql = "INSERT INTO Alojamiento (fechaIngreso, fechaEgreso, estado, servicio, importeDiario, ciudadDestino) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            java.util.Date fechaIngreso1 = alojamiento.getFechaIngreso();
            java.util.Date fechaEgreso2 = alojamiento.getFechaEgreso();
            java.sql.Date fechaIng = new java.sql.Date(fechaIngreso1.getTime());
            java.sql.Date fechaEgr = new java.sql.Date(fechaEgreso2.getTime());
            ps.setDate(1, fechaIng);
            ps.setDate(2, fechaEgr);
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

    public List<Alojamiento> obtenerAlojamientosPorCiudadDestino(Ciudad ciudadDestino) {
        List<Alojamiento> alojamientos = new ArrayList<>();
        String sql = "SELECT * FROM Alojamiento WHERE ciudadDestino = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ciudadDestino.getIdCiudad());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Alojamiento alojamiento = new Alojamiento();
                alojamiento.setAlojamiento(rs.getInt("idAlojamiento"));
                alojamiento.setFechaIngreso(rs.getDate("fechaInicio"));
                alojamiento.setFechaEgreso(rs.getDate("fechaFin"));
                alojamiento.setEstado(rs.getBoolean("estado"));
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setImporteDiario(rs.getDouble("importeDiario"));

                alojamientos.add(alojamiento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error a la tabla alojamiento data");
        }

        return alojamientos;
    }

    public List<Alojamiento> obtenerTodosLosAlojamientos() {

        List<Alojamiento> alojamientos = new ArrayList<>();
        String sql = "SELECT * FROM Alojamiento";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alojamiento alojamiento = new Alojamiento();
                alojamiento.setAlojamiento(rs.getInt("idAlojamiento"));
                alojamiento.setFechaIngreso(rs.getDate("fechaIngreso"));
                alojamiento.setFechaEgreso(rs.getDate("fechaEgreso"));
                alojamiento.setEstado(true);
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setImporteDiario(rs.getDouble("importeDiario"));
                int idCiudadDestino = rs.getInt("ciudadDestino");
                Ciudad ciudadDestino = (Ciudad) rs.getObject("ciudadDestino");
                alojamiento.setCiudadDestino(ciudadDestino);
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
            java.util.Date fechaIngreso1 = alojamiento.getFechaIngreso();
            java.util.Date fechaEgreso2 = alojamiento.getFechaEgreso();
            java.sql.Date fechaIng = new java.sql.Date(fechaIngreso1.getTime());
            java.sql.Date fechaEgr = new java.sql.Date(fechaEgreso2.getTime());
             ps.setDate(1, fechaIng);
            ps.setDate(2, fechaEgr);
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
