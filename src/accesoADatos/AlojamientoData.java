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
        String sql = "INSERT INTO Alojamiento (fechaIngreso, fechaEgreso, estado, servicio, importeDiario, cupoAlojamiento, ciudadDestino, nombre, tipoAlojamiento) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setDate(1, Date.valueOf(alojamiento.getFechaIngreso()));
            ps.setDate(2, Date.valueOf(alojamiento.getFechaEgreso()));
            ps.setBoolean(3, alojamiento.isEstado());
            ps.setString(4, alojamiento.getServicio());
            ps.setDouble(5, alojamiento.getImporteDiario());
            ps.setInt(6, alojamiento.getCupoAlojamiento());
            ps.setInt(7, alojamiento.getCiudadDestino().getIdCiudad());
            ps.setString(8, alojamiento.getNombre());
            ps.setString(9, alojamiento.getTipoAlojamiento());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alojamiento.setIdAlojamiento(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se guardó con éxito el hotel");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento");
        }
    }
    
    public Alojamiento obtenerAlojamientoPorId(int idAlojamiento) {
        String sql = "SELECT * FROM Alojamiento WHERE idAlojamiento = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlojamiento);
            ResultSet rs = ps.executeQuery();
            CiudadData ciudadData = new CiudadData();
            Alojamiento alojamiento = new Alojamiento();
            if (rs.next()) {
                
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                alojamiento.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                alojamiento.setFechaEgreso(rs.getDate("fechaEgreso").toLocalDate());
                alojamiento.setEstado(rs.getBoolean("estado"));
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setImporteDiario(rs.getDouble("importeDiario"));
                alojamiento.setNombre(rs.getString("nombre"));
                alojamiento.setTipoAlojamiento(rs.getString("tipoAlojamiento"));
                Ciudad ciudadDestinoo = ciudadData.obtenerCiudadPorId(rs.getInt("ciudadDestino"));
                alojamiento.setCupoAlojamiento(rs.getInt("cupoAlojamiento"));
                alojamiento.setCiudadDestino(ciudadDestinoo);
                return alojamiento;
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento");
        }
        return null;
    }
    
    public List<Alojamiento> obtenerAlojamientosPorCiudadDestino(Ciudad ciudadDestino) {
        List<Alojamiento> alojamientos = new ArrayList<>();
        String sql = "SELECT * FROM Alojamiento WHERE ciudadDestino = ? AND estado = 1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ciudadDestino.getIdCiudad());
            ResultSet rs = ps.executeQuery();
            CiudadData ciudadData = new CiudadData();
         
            while (rs.next()) {
                
                Alojamiento alojamiento = new Alojamiento();
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                alojamiento.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                alojamiento.setFechaEgreso(rs.getDate("fechaEgreso").toLocalDate());
                alojamiento.setEstado(rs.getBoolean("estado"));
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setImporteDiario(rs.getDouble("importeDiario"));
                alojamiento.setNombre(rs.getString("nombre"));
                alojamiento.setTipoAlojamiento(rs.getString("tipoAlojamiento"));
                Ciudad ciudadDestinoo = ciudadData.obtenerCiudadPorId(rs.getInt("ciudadDestino"));
                alojamiento.setCiudadDestino(ciudadDestinoo);
                alojamiento.setCupoAlojamiento(rs.getInt("cupoAlojamiento"));
                alojamientos.add(alojamiento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error a la tabla alojamiento data");
        }
        
        return alojamientos;
    }
    
    public List<Alojamiento> obtenerTodosLosAlojamientos() {
        
        List<Alojamiento> alojamientos = new ArrayList<>();
        String sql = "SELECT * FROM Alojamiento";
        CiudadData ciudadData = new CiudadData();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alojamiento alojamiento = new Alojamiento();
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                alojamiento.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                alojamiento.setFechaEgreso(rs.getDate("fechaEgreso").toLocalDate());
                alojamiento.setEstado(rs.getBoolean("estado"));
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setImporteDiario(rs.getDouble("importeDiario"));
                alojamiento.setNombre(rs.getString("nombre"));
                alojamiento.setTipoAlojamiento(rs.getString("tipoAlojamiento"));
                Ciudad ciudadDestino = ciudadData.obtenerCiudadPorId(rs.getInt("ciudadDestino"));
                alojamiento.setCiudadDestino(ciudadDestino);
                alojamiento.setCupoAlojamiento(rs.getInt("cupoAlojamiento"));
                alojamientos.add(alojamiento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento");
        }
        return alojamientos;
    }
    public List<Alojamiento> obtenerTodosLosAlojamientosActivos() {
        
        List<Alojamiento> alojamientos = new ArrayList<>();
        String sql = "SELECT * FROM Alojamiento where estado = 1";
        CiudadData ciudadData = new CiudadData();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alojamiento alojamiento = new Alojamiento();
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                alojamiento.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                alojamiento.setFechaEgreso(rs.getDate("fechaEgreso").toLocalDate());
                alojamiento.setEstado(rs.getBoolean("estado"));
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setImporteDiario(rs.getDouble("importeDiario"));
                alojamiento.setNombre(rs.getString("nombre"));
                alojamiento.setTipoAlojamiento(rs.getString("tipoAlojamiento"));
                Ciudad ciudadDestino = ciudadData.obtenerCiudadPorId(rs.getInt("ciudadDestino"));
                alojamiento.setCiudadDestino(ciudadDestino);
                alojamiento.setCupoAlojamiento(rs.getInt("cupoAlojamiento"));
                alojamientos.add(alojamiento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento");
        }
        return alojamientos;
    }
    
    public void actualizarAlojamiento(Alojamiento alojamiento) {
        String sql = "UPDATE alojamiento SET fechaIngreso = ?, fechaEgreso = ?, estado = ?, servicio = ?, importeDiario = ?, cupoAlojamiento = ?, ciudadDestino = ?, nombre = ?, tipoAlojamiento = ? WHERE idAlojamiento = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(alojamiento.getFechaIngreso()));
            ps.setDate(2, Date.valueOf(alojamiento.getFechaEgreso()));
            ps.setBoolean(3, alojamiento.isEstado());
            ps.setString(4, alojamiento.getServicio());
            ps.setDouble(5, alojamiento.getImporteDiario());
            ps.setInt(6, alojamiento.getCupoAlojamiento());
            JOptionPane.showMessageDialog(null, alojamiento.getCupoAlojamiento());
            ps.setInt(7, alojamiento.getCiudadDestino().getIdCiudad());
            ps.setString(8, alojamiento.getNombre());
            ps.setString(9, alojamiento.getTipoAlojamiento());
            ps.setInt(10, alojamiento.getIdAlojamiento());
            
            int exito = ps.executeUpdate();
         
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se guardaron los cambios de hotel con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alojamiento");
        }
    }
    
    public void eliminarAlojamiento(int idAlojamiento) {
        String sql = "DELETE FROM Alojamiento WHERE idAlojamiento = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlojamiento);
            
            int exito  = ps.executeUpdate();
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Se eliminó el hotel con éxito");
            
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento");
        }
    }
}
