package Controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import Vista.InterVentas;

/**
 *
 * @author norma
 */
public class VentaPDF {

    private String nombreCliente;
    private String cedulaCliente;
    private String telefonoCliente;
    private String direccionCliente;

    private String fechaActual = "";
    private String nombreArchivoPDFVenta = "";
    private String formaDePago = "";

    //metodo para obtener datos del cliente
    public void DatosCliente(int idCliente) {
        Connection cn = Conexion.conectar();
        String sql = "select * from clientes where idCliente = '" + idCliente + "'";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                cedulaCliente = rs.getString("dni");
                telefonoCliente = rs.getString("telefono");
                direccionCliente = rs.getString("direccion");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
    }
    
    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    // ==============================
    // GENERAR PDF
    // ==============================
    public void generarFacturaPDF() {

        Document doc = new Document();

        try {

            fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            String clienteLimpio = nombreCliente.replaceAll("[^a-zA-Z0-9]", "_");
            nombreArchivoPDFVenta = "Venta_" + clienteLimpio + "_" + fechaActual + ".pdf";

            // Ruta Documentos/PDF1
            File carpeta = new File(System.getProperty("user.home")
                    + File.separator + "Documents"
                    + File.separator + "PDF1");

            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            File file = new File(carpeta, nombreArchivoPDFVenta);

            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();

            // ===== COLORES =====
            BaseColor azulCorporativo = new BaseColor(25, 50, 100);
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, azulCorporativo);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 11);
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
            Font headerWhite = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.WHITE);

            // ==============================
            // LOGO + TITULO
            // ==============================
            Image logo = null;

            try {
                logo = Image.getInstance(
                        getClass().getResource("/img/tinda.jpeg"));
                logo.scaleToFit(100, 100);
            } catch (Exception e) {
                System.out.println("No se pudo cargar logo: " + e);
            }

            PdfPTable tablaEncabezado = new PdfPTable(2);
            tablaEncabezado.setWidthPercentage(100);
            tablaEncabezado.setWidths(new float[]{30f, 70f});

            PdfPCell celdaLogo = new PdfPCell();
            celdaLogo.setBorder(0);
            if (logo != null) {
                celdaLogo.addElement(logo);
            }

            PdfPCell celdaTitulo = new PdfPCell();
            celdaTitulo.setBorder(0);

            Paragraph titulo = new Paragraph("FACTURA DE VENTA\n", tituloFont);
            titulo.setAlignment(Element.ALIGN_RIGHT);

            Paragraph fecha = new Paragraph("Fecha: " + fechaActual, normalFont);
            fecha.setAlignment(Element.ALIGN_RIGHT);

            celdaTitulo.addElement(titulo);
            celdaTitulo.addElement(fecha);

            tablaEncabezado.addCell(celdaLogo);
            tablaEncabezado.addCell(celdaTitulo);

            doc.add(tablaEncabezado);
            doc.add(new Paragraph("\n"));

            // ==============================
            // DATOS CLIENTE
            // ==============================
            PdfPTable tablaCliente = new PdfPTable(2);
            tablaCliente.setWidthPercentage(100);

            tablaCliente.addCell(crearCelda("DNI:", boldFont, 0));
            tablaCliente.addCell(crearCelda(cedulaCliente, normalFont, 0));

            tablaCliente.addCell(crearCelda("Nombre:", boldFont, 0));
            tablaCliente.addCell(crearCelda(nombreCliente, normalFont, 0));

            tablaCliente.addCell(crearCelda("Teléfono:", boldFont, 0));
            tablaCliente.addCell(crearCelda(telefonoCliente, normalFont, 0));

            tablaCliente.addCell(crearCelda("Dirección:", boldFont, 0));
            tablaCliente.addCell(crearCelda(direccionCliente, normalFont, 0));

            doc.add(tablaCliente);
            doc.add(new Paragraph("\n"));

            // ==============================
            // TABLA PRODUCTOS
            // ==============================
            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.setWidths(new float[]{15f, 45f, 20f, 20f});

            tablaProducto.addCell(crearCeldaHeader("Cantidad", headerWhite, azulCorporativo));
            tablaProducto.addCell(crearCeldaHeader("Descripción", headerWhite, azulCorporativo));
            tablaProducto.addCell(crearCeldaHeader("P. Unitario", headerWhite, azulCorporativo));
            tablaProducto.addCell(crearCeldaHeader("Total", headerWhite, azulCorporativo));

            for (int i = 0; i < InterVentas.jTable_productos.getRowCount(); i++) {

                tablaProducto.addCell(crearCelda(
                        InterVentas.jTable_productos.getValueAt(i, 2).toString(),
                        normalFont, 1));

                tablaProducto.addCell(crearCelda(
                        InterVentas.jTable_productos.getValueAt(i, 1).toString(),
                        normalFont, 0));

                tablaProducto.addCell(crearCelda(
                        InterVentas.jTable_productos.getValueAt(i, 3).toString(),
                        normalFont, 1));

                tablaProducto.addCell(crearCelda(
                        InterVentas.jTable_productos.getValueAt(i, 4).toString(),
                        normalFont, 1));
            }

            doc.add(tablaProducto);
            doc.add(new Paragraph("\n"));

            // ==============================
            // TOTAL + FORMA DE PAGO
            // ==============================
            PdfPTable tablaPago = new PdfPTable(2);
            tablaPago.setWidthPercentage(40);
            tablaPago.setHorizontalAlignment(Element.ALIGN_RIGHT);

            tablaPago.addCell(crearCelda("TOTAL:", boldFont, 2));
            tablaPago.addCell(crearCelda(InterVentas.txt_total_pagar.getText(), boldFont, 2));

            tablaPago.addCell(crearCelda("FORMA DE PAGO:", boldFont, 2));
            tablaPago.addCell(crearCelda(formaDePago, boldFont, 2));

            doc.add(tablaPago);

            doc.add(new Paragraph("\n\n"));

            Paragraph gracias = new Paragraph("¡Gracias por su compra!", boldFont);
            gracias.setAlignment(Element.ALIGN_CENTER);
            doc.add(gracias);

            doc.close();

            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            System.out.println("Error PDF: " + e);
        }
    }

    // ==============================
    // CELDAS AUXILIARES
    // ==============================
    private PdfPCell crearCelda(String texto, Font fuente, int alineacion) {

        PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
        celda.setPadding(6);
        celda.setBorder(0);

        if (alineacion == 1) {
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        } else if (alineacion == 2) {
            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
        }

        return celda;
    }

    private PdfPCell crearCeldaHeader(String texto, Font fuente, BaseColor fondo) {

        PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
        celda.setBackgroundColor(fondo);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(8);

        return celda;
    }
}