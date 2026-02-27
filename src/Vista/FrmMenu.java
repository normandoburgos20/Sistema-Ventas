package Vista;

import Controlador.Reportes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author norma
 */
public class FrmMenu extends javax.swing.JFrame {

    public static JDesktopPane jDesktopPane_menu;
    

    public FrmMenu() {
        initComponents();

        this.setSize(new Dimension(1200, 700));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("SISTEMAS DE VENTAS");
        this.setLayout(null);

        jDesktopPane_menu = new JDesktopPane();
        

        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;

        jDesktopPane_menu.setBounds(0, 0, ancho, alto - 110);
        this.add(jDesktopPane_menu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        nuevo_proveedor = new javax.swing.JMenu();
        jMenuItem_nuevo_proveedor = new javax.swing.JMenuItem();
        nuevo_producto = new javax.swing.JMenu();
        jMenuItem_nuevo_producto = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem_nueva_Categoria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu_nueva_venta = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem_reportes_clientes = new javax.swing.JMenuItem();
        jMenuItem_reportes_categorias = new javax.swing.JMenuItem();
        jMenuItem_reportes_productos = new javax.swing.JMenuItem();
        jMenuItem_reportes_ventas = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();

        jMenuItem9.setText("jMenuItem9");

        jMenuItem18.setText("jMenuItem18");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nuevo_proveedor.setBackground(new java.awt.Color(255, 204, 255));
        nuevo_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/proveedores.jpg"))); // NOI18N
        nuevo_proveedor.setText("PROVEEDORES");
        nuevo_proveedor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nuevo_proveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nuevo_proveedor.setMinimumSize(new java.awt.Dimension(150, 30));
        nuevo_proveedor.setName(""); // NOI18N
        nuevo_proveedor.setPreferredSize(new java.awt.Dimension(180, 30));

        jMenuItem_nuevo_proveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem_nuevo_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jMenuItem_nuevo_proveedor.setText("Gestionar Proveedores");
        jMenuItem_nuevo_proveedor.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_nuevo_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevo_proveedorActionPerformed(evt);
            }
        });
        nuevo_proveedor.add(jMenuItem_nuevo_proveedor);

        jMenuBar1.add(nuevo_proveedor);

        nuevo_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prod.png"))); // NOI18N
        nuevo_producto.setText("PRODUCTO");
        nuevo_producto.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nuevo_producto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nuevo_producto.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevo_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem_nuevo_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-producto.png"))); // NOI18N
        jMenuItem_nuevo_producto.setText("Gestionar Productos");
        jMenuItem_nuevo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevo_productoActionPerformed(evt);
            }
        });
        nuevo_producto.add(jMenuItem_nuevo_producto);

        jMenuBar1.add(nuevo_producto);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorias.png"))); // NOI18N
        jMenu4.setText("CATEGORIA");
        jMenu4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nueva_Categoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem_nueva_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jMenuItem_nueva_Categoria.setText("Nueva Categoria");
        jMenuItem_nueva_Categoria.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_nueva_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nueva_CategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_nueva_Categoria);

        jMenuBar1.add(jMenu4);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cli.png"))); // NOI18N
        jMenu3.setText("CLIENTES");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setMinimumSize(new java.awt.Dimension(120, 50));
        jMenu3.setPreferredSize(new java.awt.Dimension(140, 50));

        jMenuItem7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cli.png"))); // NOI18N
        jMenuItem7.setText("Gestionar cliente");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu_nueva_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas2.png"))); // NOI18N
        jMenu_nueva_venta.setText("VENTAS");
        jMenu_nueva_venta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenu_nueva_venta.setMinimumSize(new java.awt.Dimension(120, 50));
        jMenu_nueva_venta.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jMenuItem11.setText("Nuevas Ventas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu_nueva_venta.add(jMenuItem11);

        jMenuBar1.add(jMenu_nueva_venta);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes2.png"))); // NOI18N
        jMenu6.setText("Reportes");
        jMenu6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_reportes_clientes.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem_reportes_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes2.png"))); // NOI18N
        jMenuItem_reportes_clientes.setText("Reportes Clientes");
        jMenuItem_reportes_clientes.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_reportes_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportes_clientesActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportes_clientes);

        jMenuItem_reportes_categorias.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem_reportes_categorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes2.png"))); // NOI18N
        jMenuItem_reportes_categorias.setText("Reportes Categorias");
        jMenuItem_reportes_categorias.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_reportes_categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportes_categoriasActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportes_categorias);

        jMenuItem_reportes_productos.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem_reportes_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes2.png"))); // NOI18N
        jMenuItem_reportes_productos.setText("Reportes Productos");
        jMenuItem_reportes_productos.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_reportes_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportes_productosActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportes_productos);

        jMenuItem_reportes_ventas.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem_reportes_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes2.png"))); // NOI18N
        jMenuItem_reportes_ventas.setText("Reportes Ventas");
        jMenuItem_reportes_ventas.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_reportes_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportes_ventasActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportes_ventas);

        jMenuBar1.add(jMenu6);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.png"))); // NOI18N
        jMenu8.setText("CERRAR SESIÓN");
        jMenu8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenu8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu8.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem19.setText("Cerrar Sesión");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem19);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        InterVentas interVentas = new InterVentas();
        jDesktopPane_menu.add(interVentas);
        interVentas.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem_nuevo_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevo_proveedorActionPerformed

        InterProveedores interProveedor = new InterProveedores();
        jDesktopPane_menu.add(interProveedor);
        interProveedor.setVisible(true);
    }//GEN-LAST:event_jMenuItem_nuevo_proveedorActionPerformed

    private void jMenuItem_nuevo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevo_productoActionPerformed
        InterProducto interProducto = new InterProducto();
        jDesktopPane_menu.add(interProducto);
        interProducto.setVisible(true);

    }//GEN-LAST:event_jMenuItem_nuevo_productoActionPerformed

    private void jMenuItem_nueva_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nueva_CategoriaActionPerformed

        InterCategoria interCategorias = new InterCategoria();
        jDesktopPane_menu.add(interCategorias);
        interCategorias.setVisible(true);
    }//GEN-LAST:event_jMenuItem_nueva_CategoriaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        InterCliente interCliente =new InterCliente();
        jDesktopPane_menu.add(interCliente);
        interCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem_reportes_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportes_clientesActionPerformed
        Reportes reporte = new Reportes();
        reporte.ReportesClientes();
    }//GEN-LAST:event_jMenuItem_reportes_clientesActionPerformed

    private void jMenuItem_reportes_categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportes_categoriasActionPerformed
        Reportes reporte = new Reportes();
        reporte.ReportesCategorias();
    }//GEN-LAST:event_jMenuItem_reportes_categoriasActionPerformed

    private void jMenuItem_reportes_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportes_productosActionPerformed
        Reportes reporte = new Reportes();
        reporte.ReportesProductos();
    }//GEN-LAST:event_jMenuItem_reportes_productosActionPerformed

    private void jMenuItem_reportes_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportes_ventasActionPerformed
        Reportes reporte = new Reportes();
        reporte.ReportesVentas();
    }//GEN-LAST:event_jMenuItem_reportes_ventasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem_nueva_Categoria;
    private javax.swing.JMenuItem jMenuItem_nuevo_producto;
    private javax.swing.JMenuItem jMenuItem_nuevo_proveedor;
    private javax.swing.JMenuItem jMenuItem_reportes_categorias;
    private javax.swing.JMenuItem jMenuItem_reportes_clientes;
    private javax.swing.JMenuItem jMenuItem_reportes_productos;
    private javax.swing.JMenuItem jMenuItem_reportes_ventas;
    private javax.swing.JMenu jMenu_nueva_venta;
    private javax.swing.JMenu nuevo_producto;
    private javax.swing.JMenu nuevo_proveedor;
    // End of variables declaration//GEN-END:variables
}
