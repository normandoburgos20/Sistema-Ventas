package Controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.CabeceraVenta;
import Modelo.Ventas;

/**
 *
 * @author norma
 */
public class Ctrl_RegistrarVenta {

    //ultimo id de la cabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal iDColVar;

    /**
     * **************************************************
     * metodo para guardar la cabecera de venta
     * **************************************************
     */
    public boolean guardar(CabeceraVenta cabecera) {

        boolean respuesta = false;

        try {
            Connection cn = Conexion.conectar();

            String sql = "INSERT INTO cabecera_ventas "
                    + "(idCliente, id_usuario, fechaVenta, formaDePago, estado) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, cabecera.getIdCliente());
            pst.setInt(2, cabecera.getIdUsuario());   // 🔥 IMPORTANTE
            pst.setString(3, cabecera.getFechaVenta());
            pst.setString(4, cabecera.getFormaDePago());
            pst.setInt(5, cabecera.getEstado());

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera de venta: " + e);
        }

        return respuesta;
    }

    /**
     * **************************************************
     * metodo para guardar el detalle de venta
     * **************************************************
     */
    public boolean guardarDetalle(Ventas detalle) {

        boolean respuesta = false;

        try {
            Connection cn = Conexion.conectar();

            String sql = "INSERT INTO ventas "
                    + "(idCabeceraVenta, idProducto, cantidad, precio, totalPagar) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, detalle.getIdCabeceraVenta());
            pst.setInt(2, detalle.getIdProducto());
            pst.setInt(3, detalle.getCantidad());
            pst.setDouble(4, detalle.getPrecioUnitario());  // 🔥 CORREGIDO
            pst.setDouble(5, detalle.getTotalPagar());

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar detalle: " + e);
        }

        return respuesta;
    }

    /**
     * **************************************************
     * metodo para actualizar un producto
     * **************************************************
     */
    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "update cabecera_ventas set idCliente = ?, estado = ? "
                    + "where idCabeceraVenta ='" + idCabeceraVenta + "'");
            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera de venta: " + e);
        }
        return respuesta;
    }

    public int obtenerUltimoId() {

        int id = 0;
        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT MAX(idCabeceraVenta) FROM cabecera_ventas";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                id = rs.getInt(1);
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener último id: " + e);
        }

        return id;
    }
}
