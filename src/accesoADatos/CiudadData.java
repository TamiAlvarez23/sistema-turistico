
package accesoADatos;

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
public class CiudadData {
    private Connection con = null;
    
    public CiudadData (){

    con = Conexion.getConexion();
    
}
    public void agregarCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO Ciudad (nombre, pais, estado, provincia) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, ciudad.getPais());
            ps.setBoolean(3, ciudad.isEstado());
            ps.setString(4, ciudad.getProvincia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla ciudad");
        }
    }

    public Ciudad obtenerCiudadPorId(int idCiudad) {
        String sql = "SELECT * FROM Ciudad WHERE idCiudad = ?";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudad);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idCiudad");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                boolean estado = rs.getBoolean("estado");
                String provincia = rs.getString("provincia");
                return new Ciudad(id, nombre, pais, estado, provincia);
            }else{
            JOptionPane.showMessageDialog(null, "no existe la ciudad");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla ciudad");
        }
        return null;
    }

    public List<Ciudad> obtenerTodasLasCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        String selectQuery = "SELECT * FROM Ciudad";
        try (PreparedStatement ps = con.prepareStatement(selectQuery)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idCiudad");
                String nombre = resultSet.getString("nombre");
                String pais = resultSet.getString("pais");
                boolean estado = resultSet.getBoolean("estado");
                String provincia = resultSet.getString("provincia");
                ciudades.add(new Ciudad(id, nombre, pais, estado, provincia));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla ciudad");
        }
        return ciudades;
    }

    public void actualizarCiudad(Ciudad ciudad) {
        String updateQuery = "UPDATE Ciudad SET nombre = ?, pais = ?, estado = ?, provincia = ? WHERE idCiudad = ?";
        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, ciudad.getPais());
            ps.setBoolean(3, ciudad.isEstado());
            ps.setString(4, ciudad.getProvincia());
            ps.setInt(5, ciudad.getIdCiudad());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla ciudad");
        }
    }

    public void eliminarCiudad(int idCiudad) {
        String deleteQuery = "DELETE FROM Ciudad WHERE idCiudad = ?";
        try (PreparedStatement ps = con.prepareStatement(deleteQuery)) {
            ps.setInt(1, idCiudad);
            ps.executeUpdate();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "no se puede acceder a la tabla ciudad");
        }
    }
    
    
    
    
    
    
}
