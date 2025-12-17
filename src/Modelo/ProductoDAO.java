package Controlador;

import Modelo.Producto;
import conexion.Conexion;
import java.sql.*;
import java.util.*;

public class ProductoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean agregar(Producto p) {
        String sql = "INSERT INTO productos (idProducto, nombre,stock,precio,descripcion,codigo,idCategoria, estado) VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1,0);
            ps.setString(2, p.getNombre());
            ps.setInt(3,p.getStock());
            ps.setDouble(4, p.getPrecio());
            ps.setString(5, p.getDescripcion());
            ps.setString(6, p.getCodigo());
            ps.setInt(7, p.getIdCategoria());
            ps.setInt(8, p.getEstado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar: " + e);
            return false;
        }
    }
    

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto( rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setStock(rs.getInt("stock"));
                p.setPrecio(rs.getDouble("precio"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCodigo(rs.getString("codigo"));
                p.setIdCategoria(rs.getInt("idCategoria"));
                
                
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e);
        }
        return lista;
    }

    public boolean actualizar(Producto p) {
    String sql = "UPDATE productos SET nombre=?, stock=?, precio=?, descripcion=?, codigo=?, idCategoria=?, estado=? WHERE idProducto=?";

    try {
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);

        ps.setString(1, p.getNombre());
        ps.setInt(2, p.getStock());
        ps.setDouble(3, p.getPrecio());
        ps.setString(4, p.getDescripcion());
        ps.setString(5, p.getCodigo());
        ps.setInt(6, p.getIdCategoria());
        ps.setInt(7, p.getEstado());
        ps.setInt(8, p.getIdProducto()); // 🔴 CLAVE PARA ACTUALIZAR

        ps.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Error al actualizar: " + e);
        return false;
    }
}


    public boolean eliminar(int idProducto) {
        String sql = "DELETE FROM productos WHERE idProducto=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e);
            return false;
        }
    }
}