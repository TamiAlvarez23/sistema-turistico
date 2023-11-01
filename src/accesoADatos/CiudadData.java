
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
    String sql = "INSERT INTO ciudad (nombre, pais, estado, provincia) VALUES (?, ?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       
        ps.setString(1, ciudad.getNombre());
        ps.setString(2, ciudad.getPais());
        ps.setBoolean(3,ciudad.isEstado()); 
        ps.setString(4, ciudad.getProvincia());
        
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            ciudad.setIdCiudad(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Se guardó con éxito la ciudad");
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad");
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
            JOptionPane.showMessageDialog(null, "La ciudad no existe");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad");
        }
        return null;
    }
    
    public Ciudad obtenerCiudadPorNombre(String nombre1) {
        String sql = "SELECT * FROM Ciudad WHERE nombre = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idCiudad");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                boolean estado = rs.getBoolean("estado");
                String provincia = rs.getString("provincia");
                return new Ciudad(id, nombre, pais, estado, provincia);
            }else{
            JOptionPane.showMessageDialog(null, "La ciudad no existe");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad");
        }
        return null;
    }

    public List<Ciudad> obtenerTodasLasCiudadesActivaas() {
        List<Ciudad> ciudades = new ArrayList<>();
        String sql = "SELECT * FROM Ciudad where estado = 1";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad");
        }
        return ciudades;
    }
    
    public List<Ciudad> obtenerTodasLasCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        String sql = "SELECT * FROM Ciudad ";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad");
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
            int exito  = ps.executeUpdate();
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Se actualizo la ciudad con exito");
            
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad");
        }
    }

    public void eliminarCiudad(int idCiudad) {
        String deleteQuery = "DELETE FROM Ciudad WHERE idCiudad = ?";
        try (PreparedStatement ps = con.prepareStatement(deleteQuery)) {
            ps.setInt(1, idCiudad);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Se eliminó la ciudad correctamente");
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla ciudad");
        }
    }
   
}
