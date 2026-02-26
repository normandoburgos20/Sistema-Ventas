package Modelo;

/**
 *
 * @author norma
 */
public class CabeceraVenta {

    // Atributos (mapeados a la tabla cabecera_ventas)
    private int idCabeceraVenta;   // PK
    private int idCliente;         // FK hacia cliente
    private int idUsuario;         // FK hacia usuario
    private String fechaVenta;     // date en SQL, String o LocalDate en Java
    private int estado;            // estado de la venta
    private String formaDePago;    // forma de pago

    // Constructor vacío
    public CabeceraVenta() {
        this.idCabeceraVenta = 0;
        this.idCliente = 0;
        this.idUsuario = 0;
        this.fechaVenta = "";
        this.estado = 0;
        this.formaDePago = "";
    }

    

    // Constructor con parámetros
    public CabeceraVenta(int idCabeceraVenta, int idCliente, int idUsuario,
            String fechaVenta, int estado, String formaDePago) {
        this.idCabeceraVenta = idCabeceraVenta;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.formaDePago = formaDePago;
    }

    // Getters y Setters
    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    //toString 
    @Override
    public String toString() {
        return "CabeceraVenta{" + "idCabeceraVenta=" + idCabeceraVenta + ", idCliente=" + idCliente + ", formaDePago=" + formaDePago + ", fechaVenta=" + fechaVenta + ", estado=" + estado + '}';
    }

}
