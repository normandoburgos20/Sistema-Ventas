package Controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Proveedor {

    /**
     * Metodo para guardar un nuevo proveedor
     */
    public boolean guardar(Proveedor objeto) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO proveedores VALUES (?,?,?,?,?,?)");

            consulta.setInt(1, 0); // id_proveedor (AUTO_INCREMENT)
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getProvincia());
            consulta.setString(4, objeto.getPais());
            consulta.setString(5, objeto.getContacto());
            consulta.setInt(6, objeto.getIdProducto()); // ✅ NUEVO CAMPO

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar proveedor: " + e.getMessage());
        }

        return respuesta;
    }

    /**
     * Metodo para verificar si el proveedor ya existe
     */
    public boolean existeProveedor(String nombre) {
        boolean respuesta = false;
        String sql = "SELECT nombre FROM proveedores WHERE nombre = '" + nombre + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar proveedor: " + e);
        }
        return respuesta;
    }

    /**
     * Metodo para actualizar un proveedor
     */
    public boolean actualizar(Proveedor p) {

        boolean respuesta = false;

        String sql = "UPDATE proveedores SET nombre=?, provincia=?, pais=?, contacto=?, idProducto=? "
                + "WHERE id_proveedor=?";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getProvincia());
            ps.setString(3, p.getPais());
            ps.setString(4, p.getContacto());
            ps.setInt(5, p.getIdProducto());      // ✅ NUEVO
            ps.setInt(6, p.getId_proveedor());    // 🔴 CLAVE

            respuesta = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
        }

        return respuesta;
    }

    /**
     * Metodo para eliminar un proveedor
     */
    public boolean eliminar(int idProveedor) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "DELETE FROM proveedores WHERE id_proveedor = ?");
            consulta.setInt(1, idProveedor);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.getMessage());
        }

        return respuesta;
    }

    /**
     * Metodo para listar proveedores
     */
    public List<Proveedor> listar() {

        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";

        try (Connection cn = Conexion.conectar(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Proveedor p = new Proveedor();

                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setProvincia(rs.getString("provincia"));
                p.setPais(rs.getString("pais"));
                p.setContacto(rs.getString("contacto"));
                p.setIdProducto(rs.getInt("idProducto")); // ✅ NUEVO

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar proveedores: " + e.getMessage());
        }

        return lista;
    }

}
