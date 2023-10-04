
package sistema.turistico;

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
        // Crear una instancia de CiudadData, AlojamientoData, PasajeData, y PaqueteData
        // Asegúrate de tener una conexión a la base de datos configurada correctamente

        CiudadData ciudadData = new CiudadData();
        AlojamientoData alojamientoData = new AlojamientoData();
        PasajeData pasajeData = new PasajeData(/* conexión a la base de datos */);
        PaqueteData paqueteData = new PaqueteData(/* conexión a la base de datos */);

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú de opciones:\n" +
                    "1. Agregar una Ciudad\n" +
                    "2. Agregar un Alojamiento\n" +
                    "3. Agregar un Pasaje\n" +
                    "4. Agregar un Paquete\n" +
                    "5. Salir"
            );

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "saliste");
                break;
            }

            switch (opcion) {
                case "1":
                    // Agregar una Ciudad
                    // Solicitar datos al usuario y usar ciudadData para agregar la Ciudad a la base de datos
                    break;
                case "2":
                    // Agregar un Alojamiento
                    // Solicitar datos al usuario y usar alojamientoData para agregar el Alojamiento a la base de datos
                    break;
                case "3":
                    // Agregar un Pasaje
                    // Solicitar datos al usuario y usar pasajeData para agregar el Pasaje a la base de datos
                    break;
                case "4":
                    // Agregar un Paquete
                    // Solicitar datos al usuario y usar paqueteData para agregar el Paquete a la base de datos
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
    }


