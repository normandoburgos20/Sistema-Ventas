package Modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDAU {
    
    public boolean login(String usuario, String clave) {
        boolean estado = false;
        Connection con = Conexion.conectar();
        String sql = "SELECT * FROM usuarios WHERE usuario=? AND clave=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estado = true;
            }
        } catch (Exception e) {
            System.out.println("❌ Error en login: " + e.getMessage());
        }
        return estado;
    }
}
