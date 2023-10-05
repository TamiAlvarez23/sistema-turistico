package sistema.turistico;

import Entidades.Ciudad;
import accesoADatos.AlojamientoData;
import accesoADatos.CiudadData;
import accesoADatos.PaqueteData;
import accesoADatos.PasajeData;
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
                JOptionPane.showMessageDialog(null, "saliste");
                break;
            }

            switch (opcion) {
                case "1":
                    cargarciudad();
                    break;
                case "2":

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
//        boolean estado = JOptionPane.showInputDialog("¿Está activo? (si/no): ").equalsIgnoreCase("si");
        if (nombre != null && provincia != null && pais != null) {
         try {
            Ciudad city = new Ciudad(1, nombre, pais,true, provincia);
            CiudadData cd=new CiudadData();
            cd.agregarCiudad(city);
            JOptionPane.showMessageDialog(null, "Ciudad agregada con exito");
         }catch (NumberFormatException e){
         JOptionPane.showMessageDialog(null, "error en los datos suministrados");
         }

        }else {
        JOptionPane.showMessageDialog(null, "ingrese valores correctos");
        }
    }
    public static void cargaralojamiento(){
    
    
    }

}
