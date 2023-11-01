/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Entidades.Paquete;
import Entidades.Presupuesto;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FamiliaSic
 */

    
    public class PresupuestoData {

    private Connection con = null;

    public PresupuestoData() {

        con = Conexion.getConexion();

    }

    public int guardarPresupuesto(Presupuesto presupuesto) {
        String sql = "INSERT INTO presupuesto (idPaquete, nombreCliente, apellidoCliente, dniCliente, telefonoCliente, mailCliente, pagoCliente, cuotasCliente, idUsuario) VALUES (?,?,?,?, ?, ?, ?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, presupuesto.getIdPresupuesto());
            ps.setObject(2, presupuesto.getIdPaquete());
            ps.setString(3, presupuesto.getNombreCliente());
            ps.setString(4, presupuesto.getApellidoCliente());
            ps.setInt(5, presupuesto.getDniCliente());
            ps.setInt(6, presupuesto.getTelefonoCliente());
            ps.setString(7, presupuesto.getMailCliente());
            ps.setString(8, presupuesto.getPagoCliente());
            ps.setString(9, presupuesto.getCuotasCliente());
            ps.setObject(10, presupuesto.getIdUsuario());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                presupuesto.setIdPresupuesto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se guardó con éxito el paquete");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se encuentran campos vacíos para generar el resumen de presupuesto");
        }
        return presupuesto.getIdPresupuesto();
    }

 public void eliminarPresupuesto(int idPresupuesto) {
        String deleteQuery = "DELETE FROM presupuesto WHERE idPresupuesto = ?";
        try (PreparedStatement ps = con.prepareStatement(deleteQuery)) {
            ps.setInt(1, idPresupuesto);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el presupuesto con éxito");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder al presupuesto");
        }
    }
    
    public Presupuesto buscarPresupuestoPorId(int idPresupuesto) {
        String sql = "SELECT * FROM presupuesto WHERE idPresupuesto = ?";
        Presupuesto presupuesto = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idPresupuesto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idPresupuesto");
                String nombreCliente = rs.getString("nombreCliente");
                String apellidoCliente = rs.getString("apellidoCliente");
                int dniCliente = rs.getInt("dniCliente");
                int telefonoCliente = rs.getInt("telefonoCliente");
                String mailCliente = rs.getString("mailCliente");
                String pagoCliente = rs.getString("pagoCliente");
                String cuotasCliente = rs.getString("cuotasCliente");
                Usuario usuario = (Usuario) rs.getObject("idUsuario");
                Paquete paquete = (Paquete) rs.getObject("idPaquete");


                presupuesto = new Presupuesto(id, paquete, nombreCliente, apellidoCliente, dniCliente, telefonoCliente, mailCliente, pagoCliente, cuotasCliente, usuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PresupuestoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return presupuesto;
    }

   


}


