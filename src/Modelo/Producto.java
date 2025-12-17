
package Modelo;

public class Producto {

    //Atributos
    private int idProducto;
    private String nombre;
    private int stock;
    private double precio;
    private String descripcion;
    private String codigo;
    private int idCategoria;
    private int estado;

    
   

    //Contructor
    public Producto() {
        this.idProducto = 0;
        this.nombre = "";
        this.stock = 0;
        this.precio = 0.0;
        this.descripcion = "";
        this.codigo = "";
        this.idCategoria = 0;
        this.estado = 0;
    }
    //Contructor sobrecargado

    public Producto(int idProducto, String nombre, int stock, double precio, String descripcion, String codigo, int idCategoria, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }

    //Set and get
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

   

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }



}