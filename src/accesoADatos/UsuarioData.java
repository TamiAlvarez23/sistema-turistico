/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FamiliaSic
 */
public class UsuarioData {

    private Connection con = null;

    public UsuarioData() {

        con = Conexion.getConexion();

    }

    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombreUsuario, rango, nombre, apellido, claveUsuario, estadoUsuario) VALUES (?, ?, ?, ?, ?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getRango());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getClaveUsuario());
            ps.setBoolean(6, usuario.isEstadoUsuario());
            ps.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla usuario");
        }

    }

    public Usuario buscarUsuario(String nombreUsuarioBuscar) {
        String sql = "SELECT * FROM usuario WHERE nombreUsuario = ?";
        Usuario usuario = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombreUsuarioBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nombreUsuario = rs.getString("nombreUsuario");
                String rango = rs.getString("rango");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String claveUsuario = rs.getString("claveUsuario");
                boolean estadoUsuario = rs.getBoolean("estadoUsuario");
                usuario = new Usuario(id, nombreUsuario, nombre, apellido, claveUsuario, estadoUsuario, rango);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    
    public void editarUsuario(Usuario usuario){
        String sql = "UPDATE usuario SET nombreUsuario = ? , nombre = ? , apellido = ? , claveUsuario = ? WHERE idUsuario = ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getClaveUsuario());
            ps.setInt(5, usuario.getIdUsuario() );
            
            int exito = ps.executeUpdate();
         
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Perfil modificado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

}
