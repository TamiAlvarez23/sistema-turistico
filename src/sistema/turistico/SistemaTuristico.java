package sistema.turistico;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import accesoADatos.AlojamientoData;
import accesoADatos.CiudadData;
import accesoADatos.Conexion;
import accesoADatos.PaqueteData;
import accesoADatos.PasajeData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo salgado
 */
public class SistemaTuristico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CiudadData ciudadData = new CiudadData();
        AlojamientoData alojamientoData = new AlojamientoData();
        PasajeData pasajeData = new PasajeData(/* conexión a la base de datos */);
        PaqueteData paqueteData = new PaqueteData(/* conexión a la base de datos */);

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú de opciones:\n"
                    + "1. Agregar una Ciudad\n"
                    + "2. Agregar un Alojamiento\n"
                    + "3. Agregar un Pasaje\n"
                    + "4. Agregar un Paquete\n"
                    + "5. Salir"
            );

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Vuelva Pronto A Tagus!!");
                break;
            }

            switch (opcion) {
                case "1":
                    cargarciudad();
                    break;
                case "2":
                    cargarAlojamiento();
                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    // Salir del programa
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elige una opción válida.");
            }
        }
    }

    public static void cargarciudad() {

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad:");
        String provincia = JOptionPane.showInputDialog("Ingrese la provincia:");
        String pais = JOptionPane.showInputDialog("Ingrese el país:");
        boolean estado = JOptionPane.showInputDialog("¿Está activo? (si/no): ").equalsIgnoreCase("si");
        if (nombre != null && provincia != null && pais != null) {
            try {
                Ciudad city = new Ciudad(1, nombre, pais, true, provincia);
                CiudadData cd = new CiudadData();
                cd.agregarCiudad(city);
                JOptionPane.showMessageDialog(null, "Ciudad agregada con exito");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "error en los datos suministrados");
            }

        } else {
            JOptionPane.showMessageDialog(null, "ingrese valores correctos");
        }
    }
public static void cargarAlojamiento() {
  AlojamientoData alojamientoData = new AlojamientoData();
    Alojamiento nuevoAlojamiento = new Alojamiento();
    
    nuevoAlojamiento.setFechaIngreso(new Date(2020,06,12)); 
    nuevoAlojamiento.setFechaEgreso(new Date(2021,05,13)); 
    nuevoAlojamiento.setEstado(true);
    nuevoAlojamiento.setServicio("desayuno"); 
    nuevoAlojamiento.setImporteDiario(450.0); 
    
    Ciudad ciudadDestino = new Ciudad();
    ciudadDestino.setIdCiudad(5);
    nuevoAlojamiento.setCiudadDestino(ciudadDestino);
    alojamientoData.agregarAlojamiento(nuevoAlojamiento);
}

    
    
    
    
//        String fechaIngresoStr = JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/MM/yyyy):");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date fechaIngreso = null;
//        try {
//            fechaIngreso = dateFormat.parse(fechaIngresoStr);
//        } catch (ParseException e) {
//            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use dd/MM/yyyy.");
//        }
//        if (fechaIngreso != null) {
//            JOptionPane.showMessageDialog(null, "Fecha de ingreso: " + dateFormat.format(fechaIngreso));
//        }
//        String fechaEgresoStr = JOptionPane.showInputDialog("Ingrese la fecha de egreso (dd/MM/yyyy):");
//        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
//        Date fechaEgreso = null;
//        try {
//            fechaEgreso = dateFormat1.parse(fechaEgresoStr);
//        } catch (ParseException e) {
//            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use dd/MM/yyyy.");
//        }
//        if (fechaEgreso != null) {
//            JOptionPane.showMessageDialog(null, "Fecha de egreso: " + dateFormat.format(fechaEgreso));
//        }
//        boolean estado = JOptionPane.showInputDialog("¿alojamiento esta activo? (si/no): ").equalsIgnoreCase("si");;
//        String servicio = JOptionPane.showInputDialog("Ingrese el servicio incluido ;)");
//        double importeDiario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el importe diario:"));
//        Ciudad ciudadDestino = obtenerCiudadDestino();
//
//        if (ciudadDestino != null) {
//            try {
//                Alojamiento aloja = new Alojamiento(fechaIngreso,fechaEgreso,estado,servicio,importeDiario,ciudadDestino);
//                AlojamientoData ad = new AlojamientoData();
//                ad.agregarAlojamiento(aloja);
//                JOptionPane.showMessageDialog(null, "Alojamiento agregado con éxito");
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Error en los datos suministrados");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Ingrese valores correctos");
//        }
//
//    }
//
//    private static Ciudad obtenerCiudadDestino() {
//        Connection con = null;
//       List<Ciudad> ciudades = new ArrayList<>();
//        String sql = "SELECT * FROM `ciudad` WHERE `nombre` = ?";
//        try {
//            con = Conexion.getConexion();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String nombre = rs.getString("nombre");
//                ciudades.add(new Ciudad(nombre));
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a ciudades destino");
//        }
//        if (!ciudades.isEmpty()) {
//            return ciudades.get(0);
//        } else {
//            return null; // 
//        }
//    }
}


