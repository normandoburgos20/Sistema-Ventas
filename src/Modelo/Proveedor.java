package Modelo;

/**
 *
 * @author norma
 */
public class Proveedor {
    //Atributos

    private int id_proveedor;
    private String nombre;
    private String provincia;
    private String pais;
    private String contacto;
    private int idProducto;

    //Contructor
    public Proveedor() {
        this.id_proveedor = 0;
        this.nombre = "";
        this.provincia = "";
        this.pais = "";
        this.contacto="";
        this.idProducto=0;
    }

    public Proveedor(int id_proveedor, String nombre, String provincia, String pais, String contacto, int idProducto) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.provincia = provincia;
        this.pais = pais;
        this.contacto = contacto;
        this.idProducto = idProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    
}
