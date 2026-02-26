
package Modelo;

/**
 *
 * @author norma
 */


public class Ventas {

    // ===== ATRIBUTOS =====
    private int idVenta;
    private int idCabeceraVenta;
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private double totalPagar;

    // ===== CONSTRUCTOR VACÍO =====
    public Ventas() {
    }

    // ===== CONSTRUCTOR COMPLETO =====
    public Ventas(int idVenta, int idCabeceraVenta, int idProducto,
                  String nombre, int cantidad,
                  double precioUnitario, double totalPagar) {

        this.idVenta = idVenta;
        this.idCabeceraVenta = idCabeceraVenta;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalPagar = totalPagar;
     
    }

    // ===== GETTERS Y SETTERS =====

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idDetalle) {
        this.idVenta = idDetalle;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    
    



   

    // toString
    @Override public String toString() { return "Ventas{" + "idVenta=" + idVenta + ", idCabeceraVenta=" + idCabeceraVenta + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", totalPagar=" + totalPagar  + ",nombre='"+nombre+'\'' + '}'; }

    
}