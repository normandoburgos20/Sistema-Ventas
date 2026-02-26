package Controlador;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author norma
 */
public class Reportes {

    /* ********************************************************************
    * metodo para crear reportes de los clientes registrados en el sistema
    *********************************************************************** */
    public void ReportesClientes() { // metodo que genera reporte PDF de clientes
        Document documento = new Document(); // crea objeto documento PDF
        try { // inicia bloque try
            String ruta = "C:\\Users\\norma\\OneDrive\\Documentos\\SistemaDeventasFinal\\src\\pdf\\"; // ruta donde se guardara el pdf
            File carpeta = new File(ruta); // crea objeto carpeta con la ruta
            if (!carpeta.exists()) { // verifica si la carpeta no existe
                carpeta.mkdirs(); // crea la carpeta
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Reporte_Clientes.pdf")); // crea archivo pdf
            Image header = Image.getInstance("src/img/header1.jpg"); // carga imagen encabezado
            header.scaleToFit(650, 1000); // ajusta tamaño de imagen
            header.setAlignment(Chunk.ALIGN_CENTER); // centra imagen
            Paragraph parrafo = new Paragraph(); // crea parrafo
            parrafo.setAlignment(Paragraph.ALIGN_CENTER); // centra parrafo
            parrafo.add("Reporte creado por \nSamuel Burgos\n\n"); // texto autor
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)); // formato letra
            parrafo.add("Reporte de Clientes \n\n"); // titulo reporte
            documento.open(); // abre documento
            documento.add(header); // agrega imagen
            documento.add(parrafo); // agrega parrafo
            PdfPTable tabla = new PdfPTable(5); // crea tabla de 5 columnas
            tabla.addCell("Codigo"); // encabezado columna
            tabla.addCell("Nombres"); // encabezado columna
            tabla.addCell("Dni"); // encabezado columna
            tabla.addCell("Telefono"); // encabezado columna
            tabla.addCell("Direccion"); // encabezado columna
            try { // segundo try
                Connection cn = Conexion.conectar(); // conexion BD
                PreparedStatement pst = cn.prepareStatement("select idCliente, concat(nombre, ' ', apellido) as nombres, dni, telefono, direccion from clientes"); // consulta sql
                ResultSet rs = pst.executeQuery(); // ejecuta consulta
                if (rs.next()) { // verifica si hay registros
                    do { // recorre registros
                        tabla.addCell(rs.getString(1)); // codigo
                        tabla.addCell(rs.getString(2)); // nombre completo
                        tabla.addCell(rs.getString(3)); // cedula
                        tabla.addCell(rs.getString(4)); // telefono
                        tabla.addCell(rs.getString(5)); // direccion
                    } while (rs.next()); // mientras existan datos
                    documento.add(tabla); // agrega tabla al pdf
                }
            } catch (SQLException e) { // captura error sql
                System.out.println("Error 4 en: " + e); // muestra error
            }
            documento.close(); // cierra documento
            JOptionPane.showMessageDialog(null, "Reporte creado"); // mensaje
        } catch (DocumentException e) { // error pdf
            System.out.println("Error 1 en: " + e); // muestra error
        } catch (FileNotFoundException ex) { // error archivo
            System.out.println("Error 2 en: " + ex); // muestra error
        } catch (IOException ex) { // error imagen
            System.out.println("Error 3 en: " + ex); // muestra error
        }
    }

    public void ReportesProductos() { // metodo que genera reporte PDF de productos
        Document documento = new Document(); // crea documento PDF
        try { // inicia try
            String ruta = "C:\\Users\\norma\\OneDrive\\Documentos\\SistemaDeventasFinal\\src\\pdf\\"; // ruta de guardado
            File carpeta = new File(ruta); // objeto carpeta
            if (!carpeta.exists()) { // verifica existencia carpeta
                carpeta.mkdirs(); // crea carpeta
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Reporte_Productos.pdf")); // crea archivo pdf
            Image header = Image.getInstance("src/img/header1.jpg"); // carga encabezado
            header.scaleToFit(650, 1000); // ajusta tamaño
            header.setAlignment(Chunk.ALIGN_CENTER); // centra imagen
            Paragraph parrafo = new Paragraph(); // crea parrafo
            parrafo.setAlignment(Paragraph.ALIGN_CENTER); // centra parrafo
            parrafo.add("Reporte creado por \nSamuel Burgos\n\n"); // autor
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)); // fuente
            parrafo.add("Reporte de Productos \n\n"); // titulo
            documento.open(); // abre documento
            documento.add(header); // agrega encabezado
            documento.add(parrafo); // agrega texto
            PdfPTable tabla = new PdfPTable(6); // tabla 6 columnas
            tabla.addCell("Codigo"); // encabezado
            tabla.addCell("Nombre"); // encabezado
            tabla.addCell("stock"); // encabezado
            tabla.addCell("Precio"); // encabezado
            tabla.addCell("Descripcion"); // encabezado
            tabla.addCell("Categoria"); // encabezado
            try { // segundo try
                Connection cn = Conexion.conectar(); // conexion BD
                PreparedStatement pst = cn.prepareStatement(
                        "select p.idProducto, \n"
                        + "       p.nombre, \n"
                        + "       p.stock, \n"
                        + "       p.precio, \n"
                        + "       p.descripcion, \n"
                        + "       c.descripcion as categoria\n"
                        + "from productos p \n"
                        + "inner join categoria c \n"
                        + "on p.idCategoria = c.idCategoria;"); // sql
                ResultSet rs = pst.executeQuery(); // ejecuta
                if (rs.next()) { // verifica datos
                    do { // recorrer filas
                        tabla.addCell(rs.getString(1)); // codigo
                        tabla.addCell(rs.getString(2)); // nombre
                        tabla.addCell(rs.getString(3)); // cantidad
                        tabla.addCell(rs.getString(4)); // precio
                        tabla.addCell(rs.getString(5)); // descripcion
                        tabla.addCell(rs.getString(6)); // categoria
                    } while (rs.next()); // mientras existan filas
                    documento.add(tabla); // agrega tabla
                }
            } catch (SQLException e) { // error sql
                System.out.println("Error 4 en: " + e); // muestra error
            }
            documento.close(); // cierra documento
            JOptionPane.showMessageDialog(null, "Reporte creado"); // mensaje
        } catch (DocumentException e) { // error documento
            System.out.println("Error 1 en: " + e); // muestra error
        } catch (FileNotFoundException ex) { // error archivo
            System.out.println("Error 2 en: " + ex); // muestra error
        } catch (IOException ex) { // error imagen
            System.out.println("Error 3 en: " + ex); // muestra error
        }
    }

    public void ReportesVentas() { // metodo que genera reporte PDF de ventas
        Document documento = new Document(); // crea documento
        try { // inicia try
            String ruta = "C:\\Users\\norma\\OneDrive\\Documentos\\SistemaDeventasFinal\\src\\pdf\\"; // ruta
            File carpeta = new File(ruta); // objeto carpeta
            if (!carpeta.exists()) { // valida
                carpeta.mkdirs(); // crea
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Reporte_Ventas.pdf")); // crea pdf
            Image header = Image.getInstance("src/img/header1.jpg"); // carga imagen
            header.scaleToFit(650, 1000); // tamaño
            header.setAlignment(Chunk.ALIGN_CENTER); // centra
            Paragraph parrafo = new Paragraph(); // parrafo
            parrafo.setAlignment(Paragraph.ALIGN_CENTER); // centra
            parrafo.add("Reporte creado por \nSamuel Burgos\n\n"); // autor
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)); // fuente
            parrafo.add("Reporte de Ventas \n\n"); // titulo
            documento.open(); // abre pdf
            documento.add(header); // agrega imagen
            documento.add(parrafo); // agrega texto
            PdfPTable tabla = new PdfPTable(5); // 5 columnas
            tabla.addCell("ID"); // encabezado
            tabla.addCell("Cliente"); // encabezado
            tabla.addCell("Total"); // encabezado
            tabla.addCell("Fecha"); // encabezado
            tabla.addCell("Estado"); // encabezado
            try { // segundo try
                Connection cn = Conexion.conectar(); // conexion
                PreparedStatement pst = cn.prepareStatement(
                        "select cv.idCabeceraVenta, concat(c.nombre,' ',c.apellido), cv.valorPagar, cv.fechaVenta, cv.estado "
                        + "from tb_cabecera_venta cv inner join tb_cliente c on cv.idCliente = c.idCliente"); // sql
                ResultSet rs = pst.executeQuery(); // ejecuta
                if (rs.next()) { // verifica
                    do { // recorrer
                        tabla.addCell(rs.getString(1)); // id
                        tabla.addCell(rs.getString(2)); // cliente
                        tabla.addCell(rs.getString(3)); // total
                        tabla.addCell(rs.getString(4)); // fecha
                        String estado = rs.getString(5); // estado
                        if (estado.equals("1")) { // activo
                            tabla.addCell("Activo"); // muestra
                        } else { // sino
                            tabla.addCell("Inactivo"); // muestra
                        }
                    } while (rs.next()); // mientras
                    documento.add(tabla); // agrega tabla
                }
            } catch (SQLException e) { // error sql
                System.out.println("Error 4 en: " + e); // imprime
            }
            documento.close(); // cierra pdf
            JOptionPane.showMessageDialog(null, "Reporte creado"); // mensaje
        } catch (DocumentException e) { // error documento
            System.out.println("Error 1 en: " + e); // imprime
        } catch (FileNotFoundException ex) { // error archivo
            System.out.println("Error 2 en: " + ex); // imprime
        } catch (IOException ex) { // error imagen
            System.out.println("Error 3 en: " + ex); // imprime
        }
    }

    public void ReportesCategorias() { // metodo que genera reporte PDF de categorias
        Document documento = new Document(); // crea documento PDF
        try { // inicia try
            String ruta = "C:\\Users\\norma\\OneDrive\\Documentos\\SistemaDeventasFinal\\src\\pdf\\"; // ruta guardado
            File carpeta = new File(ruta); // objeto carpeta
            if (!carpeta.exists()) { // valida carpeta
                carpeta.mkdirs(); // crea carpeta fechaActual
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Reporte_Categorias.pdf")); // crea pdf
            Image header = Image.getInstance("src/img/header1.jpg"); // carga imagen
            header.scaleToFit(650, 1000); // ajusta tamaño
            header.setAlignment(Chunk.ALIGN_CENTER); // centra

            LocalDateTime fechaHoraActual = LocalDateTime.now();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
            String fechaFormateada = fechaHoraActual.format(formatoFecha);
            String horaFormateada = fechaHoraActual.format(formatoHora);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte creado por \nSamuel Burgos\n\n\n");
            parrafo.add("Fecha de creación: " + fechaFormateada + "\n");
            parrafo.add("Hora de creacion: " + horaFormateada + "\n");
            parrafo.add("Reporte de Categorias \n\n");

            documento.open(); // abre pdf
            documento.add(header); // agrega imagen
            documento.add(parrafo); // agrega texto
            PdfPTable tabla = new PdfPTable(3); // 3 columnas
            tabla.addCell("ID"); // encabezado
            tabla.addCell("Descripcion"); // encabezado
            tabla.addCell("Estado"); // encabezado
            try { // segundo try
                Connection cn = Conexion.conectar(); // conexion bd
                PreparedStatement pst = cn.prepareStatement(
                        "select idCategoria, descripcion, estado from categoria"); // sql
                ResultSet rs = pst.executeQuery(); // ejecuta
                if (rs.next()) { // verifica datos
                    do { // recorrer filas
                        tabla.addCell(rs.getString(1)); // id
                        tabla.addCell(rs.getString(2)); // descripcion
                        String estado = rs.getString(3); // obtiene estado
                        if (estado.equals("1")) { // si es 1
                            tabla.addCell("Activo"); // muestra activo
                        } else { // sino
                            tabla.addCell("Inactivo"); // muestra inactivo
                        }
                    } while (rs.next()); // mientras filas
                    documento.add(tabla); // agrega tabla
                }
            } catch (SQLException e) { // error sql
                System.out.println("Error 4 en: " + e); // imprime
            }
            documento.close(); // cierra pdf
            JOptionPane.showMessageDialog(null, "Reporte creado"); // mensaje
        } catch (DocumentException e) { // error documento
            System.out.println("Error 1 en: " + e); // imprime
        } catch (FileNotFoundException ex) { // error archivo
            System.out.println("Error 2 en: " + ex); // imprime
        } catch (IOException ex) { // error imagen
            System.out.println("Error 3 en: " + ex); // imprime
        }
    }

}
