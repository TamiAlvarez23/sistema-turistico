package accesoADatos;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import Entidades.Paquete;
import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo salgado
 */
public class PaqueteData {

    private Connection con = null;
    private CiudadData cd = new CiudadData();
    private AlojamientoData ad = new AlojamientoData();
    private PasajeData pd = new PasajeData();

    public PaqueteData() {
        con = Conexion.getConexion();
    }

    public void agregarPaquete(Paquete paquete) {
        String sql = "INSERT INTO Paquete (origen, destino, alojamiento, pasaje, estado, cupo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, paquete.getOrigen().getIdCiudad());
            ps.setInt(2, paquete.getDestino().getIdCiudad());
            ps.setInt(3, paquete.getAlojamiento().getIdAlojamiento());
            ps.setInt(4, paquete.getPasaje().getIdPasaje());
            ps.setBoolean(5, paquete.isEstado());
            ps.setInt(6, paquete.getCupo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paquete.setIdPaquete(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se guardo con exito el paquete");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a tabla paquete " + e);
        }
    }

    public Paquete obtenerPaquetePorId(int idPaquete) {
        String sql = "SELECT * FROM Paquete WHERE idPaquete = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPaquete);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Paquete paquete = new Paquete();
                
                Ciudad ciudadOrigen = cd.obtenerCiudadPorId(rs.getInt("origen"));
                Ciudad ciudadDestino = cd.obtenerCiudadPorId(rs.getInt("destino"));
                Alojamiento alojamiento = ad.obtenerAlojamientoPorId(rs.getInt("alojamiento"));
                Pasaje pasaje = pd.obtenerPasajePorId(rs.getInt("pasaje"));
                boolean estado = rs.getBoolean("estado");
                int cupo = rs.getInt("cupo");
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setOrigen(ciudadOrigen);
                paquete.setDestino(ciudadDestino);
                paquete.setPasaje(pasaje);
                paquete.setAlojamiento(alojamiento);
                paquete.setEstado(estado);
                paquete.setCupo(cupo);
                return paquete;

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a tabla paquete");
        }
        return null;
    }

    public List<Paquete> obtenerTodosLosPaquetes() {
        List<Paquete> paquetes = new ArrayList<>();
        Paquete paquete;
        String sql = "SELECT * FROM Paquete";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paquete = new Paquete();
                
                Ciudad ciudadOrigen = cd.obtenerCiudadPorId(rs.getInt("origen"));
                Ciudad ciudadDestino = cd.obtenerCiudadPorId(rs.getInt("destino"));
                Alojamiento alojamiento = ad.obtenerAlojamientoPorId(rs.getInt("alojamiento"));
                Pasaje pasaje = pd.obtenerPasajePorId(rs.getInt("pasaje"));
                boolean estado = rs.getBoolean("estado");
                int cupo = rs.getInt("cupo");
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setOrigen(ciudadOrigen);
                paquete.setDestino(ciudadDestino);
                paquete.setPasaje(pasaje);
                paquete.setAlojamiento(alojamiento);
                paquete.setEstado(estado);
                paquete.setCupo(cupo);
                paquetes.add(paquete);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a tabla paquete");
        }
        return paquetes;
    }

    public void actualizarPaquete(Paquete paquete) {
        String sql = "UPDATE Paquete SET origen = ?, destino = ?, alojamiento = ?, pasaje = ? , estado = ?, cupo = ? WHERE idPaquete = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, paquete.getOrigen().getIdCiudad());
            ps.setInt(2, paquete.getDestino().getIdCiudad());
            ps.setInt(3, paquete.getAlojamiento().getIdAlojamiento());
            ps.setInt(4, paquete.getPasaje().getIdPasaje());
            ps.setBoolean(5, paquete.isEstado());
            ps.setInt(6, paquete.getCupo());
            ps.setInt(7, paquete.getIdPaquete());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a tabla paquete");
        }
    }

    public void eliminarPaquete(int idPaquete) {
        String sql = "DELETE FROM Paquete WHERE idPaquete = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPaquete);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a tabla paquete");
        }
    }

    public List<Paquete> obtenerPorCiudadOrigen(int idCiudadOrigen) {
        List<Paquete> paquetes = new ArrayList<>();
        Paquete paquete = new Paquete();
        String sql = "SELECT * FROM Paquete WHERE origen = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudadOrigen);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getOrigen().setIdCiudad(rs.getInt("idCiudad"));

                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de ciudad");
        }
        return paquetes;
    }

    public List<Paquete> obtenerPorCiudadDestino(int idCiudadDestino) {
        Paquete paquete = new Paquete();
        List<Paquete> paquetes = new ArrayList<>();

        String sql = "SELECT * FROM Paquete WHERE destino = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudadDestino);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getDestino().setIdCiudad(rs.getInt("idCiudad"));

                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de ciudad");
        }
        return paquetes;

    }

    public List<Paquete> obtenerPorFechaInicio(LocalDate fechaIngreso) {

        List<Paquete> paquetes = new ArrayList<>();

        String sql = "SELECT P.idPaquete, A.idAlojamiento, A.fechaIngreso "
                + "FROM Paquete P "
                + "INNER JOIN Alojamiento A ON P.idAlojamiento = A.idAlojamiento "
                + "WHERE A.fechaIngreso = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaIngreso));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getAlojamiento().setIdAlojamiento(rs.getInt("idAlojamiento"));
                paquete.getAlojamiento().setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de alojameinto");
        }
        return paquetes;

    }

    public List<Paquete> obtenerPorFechaEgreso(LocalDate fechaEgreso) {

        List<Paquete> paquetes = new ArrayList<>();
        String sql = "SELECT P.idPaquete, A.idAlojamiento, A.fechaEgreso "
                + "FROM Paquete P "
                + "INNER JOIN Alojamiento A ON P.idAlojamiento = A.idAlojamiento "
                + "WHERE A.fechaEgreso = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaEgreso));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getAlojamiento().setIdAlojamiento(rs.getInt("idAlojamiento"));
                paquete.getAlojamiento().setFechaEgreso(rs.getDate("fechaEgreso").toLocalDate());
                paquetes.add(paquete);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de alojameinto");
        }
        return paquetes;

    }

    public List<Paquete> obtenerPorCupo(int cupoAlojamiento) {

        List<Paquete> paquetes = new ArrayList<>();
        String sql = "SELECT P.idPaquete, A.idAlojamiento, A.cupo AS cupoAlojamiento "
                + "FROM Paquete P "
                + "INNER JOIN Alojamiento A ON P.idAlojamiento = A.idAlojamiento "
                + "WHERE A.cupo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cupoAlojamiento);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getAlojamiento().setIdAlojamiento(rs.getInt("idAlojamiento"));
                paquete.getAlojamiento().setCupoAlojamiento(rs.getInt("cupoAlojamiento"));

                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de alojamiento");
        }

        return paquetes;
    }

    public List<Paquete> obtenerPorCiudadOrigenDestino(int idCiudadOrigen, int idCiudadDestino) {
        List<Paquete> paquetes = new ArrayList<>();

        String sql = "SELECT P.idPaquete, CO.nombre AS origen, CD.nombre AS destino "
                + "FROM Paquete P "
                + "INNER JOIN Ciudad CO ON P.origen = CO.idCiudad "
                + "INNER JOIN Ciudad CD ON P.destino = CD.idCiudad "
                + "WHERE CO.idCiudad = ? AND CD.idCiudad = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudadOrigen);
            ps.setInt(2, idCiudadDestino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getOrigen().setNombre(rs.getString("origen"));
                paquete.getDestino().setNombre(rs.getString("destino"));
                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de paquete");
        }

        return paquetes;
    }

    public List<Paquete> obtenerPorCiudadOrigenDestinoFecha(int idCiudadOrigen, int idCiudadDestino, LocalDate fechaInicio) {

        List<Paquete> paquetes = new ArrayList<>();
        String sql = "SELECT P.idPaquete, CO.nombre AS origen, CD.nombre AS destino, A.fechaInicio "
                + "FROM Paquete P "
                + "INNER JOIN Ciudad CO ON P.origen = CO.idCiudad "
                + "INNER JOIN Ciudad CD ON P.destino = CD.idCiudad "
                + "INNER JOIN Alojamiento A ON P.idAlojamiento = A.idAlojamiento "
                + "WHERE CO.idCiudad = ? AND CD.idCiudad = ? AND A.fechaInicio = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudadOrigen);
            ps.setInt(2, idCiudadDestino);
            ps.setDate(3, Date.valueOf(fechaInicio));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getOrigen().setNombre(rs.getString("origen"));
                paquete.getDestino().setNombre(rs.getString("destino"));
                paquete.getAlojamiento().setFechaIngreso(rs.getDate("fechaInicio").toLocalDate());
                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de paquete");
        }

        return paquetes;
    }

    public List<Paquete> obtenerPorCiudadOrigenDestinoFechas(int idCiudadOrigen, int idCiudadDestino, LocalDate fechaInicio, LocalDate fechaRegreso) {
        List<Paquete> paquetes = new ArrayList<>();

        String sql = "SELECT P.idPaquete, CO.nombre AS origen, CD.nombre AS destino, A.fechaIngreso, A.fechaEgreso "
                + "FROM Paquete P "
                + "INNER JOIN Ciudad CO ON P.origen = CO.idCiudad "
                + "INNER JOIN Ciudad CD ON P.destino = CD.idCiudad "
                + "INNER JOIN Alojamiento A ON P.idAlojamiento = A.idAlojamiento "
                + "WHERE CO.idCiudad = ? AND CD.idCiudad = ? AND A.fechaIngreso >= ? AND A.fechaEgreso <= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudadOrigen);
            ps.setInt(2, idCiudadDestino);
            ps.setDate(3, Date.valueOf(fechaInicio));
            ps.setDate(4, Date.valueOf(fechaRegreso));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idpaquete"));
                paquete.getOrigen().setNombre(rs.getString("origen"));
                paquete.getDestino().setNombre(rs.getString("destino"));
                paquete.getAlojamiento().setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                paquete.getAlojamiento().setFechaEgreso(rs.getDate("fechaEgreso").toLocalDate());
                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de paquete");
        }

        return paquetes;
    }

    public List<Paquete> obtenerPorCiudadOrigenDestinoFechasCupo(int idCiudadOrigen, int idCiudadDestino, LocalDate fechaInicio, LocalDate fechaRegreso, int cupo) {

        List<Paquete> paquetes = new ArrayList<>();
        String sql = "SELECT P.idPaquete, CO.nombre AS origen, CD.nombre AS destino, A.fechaIngreso, A.fechaEgreso "
                + "FROM Paquete P "
                + "INNER JOIN Ciudad CO ON P.origen = CO.idCiudad "
                + "INNER JOIN Ciudad CD ON P.destino = CD.idCiudad "
                + "INNER JOIN Alojamiento A ON P.idAlojamiento = A.idAlojamiento "
                + "WHERE CO.idCiudad = ? AND CD.idCiudad = ? AND A.fechaIngreso >= ? AND A.fechaEgreso <= ? "
                + "AND P.cupo >= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudadOrigen);
            ps.setInt(2, idCiudadDestino);
            ps.setDate(3, Date.valueOf(fechaInicio));
            ps.setDate(4, Date.valueOf(fechaRegreso));
            ps.setInt(5, cupo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getOrigen().setNombre(rs.getString("origen"));
                paquete.getDestino().setNombre(rs.getString("destino"));
                paquete.getAlojamiento().setFechaIngreso(rs.getDate("fechaInicio").toLocalDate());
                paquete.getAlojamiento().setFechaEgreso(rs.getDate("fechaRegreso").toLocalDate());
                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de paquete");
        }

        return paquetes;

    }

    public List<Paquete> obtenerPorCiudadOrigenDestinoCupo(int idCiudadOrigen, int idCiudadDestino, int cupo) {
        List<Paquete> paquetes = new ArrayList<>();

        String sql = "SELECT P.idPaquete, CO.nombre AS origen, CD.nombre AS destino, A.cupo AS cupoAlojamiento "
                + "FROM Paquete P "
                + "INNER JOIN Ciudad CO ON P.origen = CO.idCiudad "
                + "INNER JOIN Ciudad CD ON P.destino = CD.idCiudad "
                + "INNER JOIN Alojamiento A ON P.idAlojamiento = A.idAlojamiento "
                + "WHERE CO.idCiudad = ? AND CD.idCiudad = ? AND A.cupo >= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudadOrigen);
            ps.setInt(2, idCiudadDestino);
            ps.setInt(3, cupo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.getOrigen().setNombre(rs.getString("origen"));
                paquete.getDestino().setNombre(rs.getString("destino"));
                paquete.getAlojamiento().setCupoAlojamiento(rs.getInt("alojamiento"));
                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de alojamiento");
        }

        return paquetes;
    }

    public List<Paquete> obtenerPorFechasCupo(LocalDate fechaInicio, LocalDate fechaRegreso, int cupo) {
        List<Paquete> paquetes = new ArrayList<>();
        String sql = "SELECT P.idPaquete, A.fechaIngreso, A.fechaEgreso, A.cupo AS cupoAlojamiento "
                + "FROM Paquete P "
                + "INNER JOIN Alojamiento A ON P.idAlojamiento = A.idAlojamiento "
                + "WHERE A.fechaIngreso >= ? AND A.fechaEgreso <= ? AND A.cupo >= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaInicio));
            ps.setDate(2, Date.valueOf(fechaRegreso));
            ps.setInt(3, cupo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paquete paquete = new Paquete();
                paquete.getAlojamiento().setFechaIngreso(rs.getDate("fechaInicio").toLocalDate());
                paquete.getAlojamiento().setFechaEgreso(rs.getDate("fechaEgreso").toLocalDate());
                paquete.getAlojamiento().setCupoAlojamiento(rs.getInt("cupoAlojamiento"));
                paquetes.add(paquete);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla de alojamiento");
        }
        return paquetes;
    }

}
