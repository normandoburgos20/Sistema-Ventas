package Vista;

import Modelo.Proveedor;
import Controlador.Ctrl_Proveedor;
import conexion.Conexion;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class InterProveedores extends javax.swing.JInternalFrame {

    private Ctrl_Proveedor proveedor = new Ctrl_Proveedor();
    private DefaultTableModel modelo;

    public InterProveedores() {
        initComponents();
        this.CargarComboProductos();
        this.setTitle("Gestión de Proveedores");

        modelo = new DefaultTableModel(
                new Object[]{"ID", "Nombre", "Provincia", "País", "Contacto", "idProducto"}, 0);
        tablaProveedores.setModel(modelo);

        listar();
    }

    // ================= LISTAR =================
    void listar() {

        List<Proveedor> lista = proveedor.listar();
        modelo.setRowCount(0); // limpiar tabla

        Object[] ob = new Object[6];

        for (Proveedor p : lista) {
            ob[0] = p.getId_proveedor();
            ob[1] = p.getNombre();
            ob[2] = p.getProvincia();
            ob[3] = p.getPais();
            ob[4] = p.getContacto();
            ob[5] = p.getIdProducto();   

            modelo.addRow(ob);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        lblPrecio2 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        lblPrecio3 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        lblPrecio4 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jComboBox_producto = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 206, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 206, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 206, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 206, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 206, -1, -1));

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 125, -1));

        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });
        txtProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProvinciaKeyPressed(evt);
            }
        });
        getContentPane().add(txtProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 125, -1));

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaProveedores);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 271, -1, 268));

        lblPrecio2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrecio2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecio2.setText("Pais:");
        getContentPane().add(lblPrecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaisKeyPressed(evt);
            }
        });
        getContentPane().add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 125, -1));

        lblPrecio3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrecio3.setText("Provincia: ");
        getContentPane().add(lblPrecio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        txtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactoKeyPressed(evt);
            }
        });
        getContentPane().add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 125, -1));

        lblPrecio4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrecio4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecio4.setText("Contacto:");
        getContentPane().add(lblPrecio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        lblPrecio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrecio.setText("Producto");
        getContentPane().add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jComboBox_producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4", " " }));
        jComboBox_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Proveedor proveedor = new Proveedor();
        Ctrl_Proveedor controlProveedor = new Ctrl_Proveedor();

        // ================= VALIDAR CAMPOS =================
        if (txtNombre.getText().trim().isEmpty()
                || txtProvincia.getText().trim().isEmpty()
                || txtPais.getText().trim().isEmpty()
                || txtContacto.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Complete todos los campos");

            txtNombre.setBackground(Color.red);
            txtProvincia.setBackground(Color.red);
            txtPais.setBackground(Color.red);
            txtContacto.setBackground(Color.red);
            return;
        }

        // ================= VALIDAR PRODUCTO =================
        if (jComboBox_producto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
            return;
        }

        // ================= VALIDAR SI EXISTE =================
        if (controlProveedor.existeProveedor(txtNombre.getText().trim())) {
            JOptionPane.showMessageDialog(null, "El proveedor ya existe en la Base de Datos");
            return;
        }

        try {
            // ================= SETEAR DATOS =================
            proveedor.setNombre(txtNombre.getText().trim());
            proveedor.setProvincia(txtProvincia.getText().trim());
            proveedor.setPais(txtPais.getText().trim());
            proveedor.setContacto(txtContacto.getText().trim());

            // ================= ID PRODUCTO =================
            this.IdProducto(); // obtiene el id desde el combo
            proveedor.setIdProducto(obtenerIdProductoCombo);

            // ================= GUARDAR =================
            if (controlProveedor.guardar(proveedor)) {

                JOptionPane.showMessageDialog(null, "Proveedor guardado correctamente");

                txtNombre.setBackground(Color.green);
                txtProvincia.setBackground(Color.green);
                txtPais.setBackground(Color.green);
                txtContacto.setBackground(Color.green);

                Limpiar();
                listar();

            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar proveedor");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = tablaProveedores.getSelectedRow();

        // ================= VALIDAR SELECCIÓN =================
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor para actualizar");
            return;
        }

        // ================= VALIDAR CAMPOS =================
        if (txtNombre.getText().trim().isEmpty()
                || txtProvincia.getText().trim().isEmpty()
                || txtPais.getText().trim().isEmpty()
                || txtContacto.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        // ================= VALIDAR PRODUCTO =================
        if (jComboBox_producto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
            return;
        }

        try {
            // ================= ID PROVEEDOR =================
            int idProveedor = Integer.parseInt(
                    tablaProveedores.getValueAt(fila, 0).toString()
            );

            // ================= OBTENER ID PRODUCTO =================
            this.IdProducto();

            // ================= CREAR OBJETO =================
            Proveedor p = new Proveedor();
            p.setId_proveedor(idProveedor);   // 🔴 CLAVE
            p.setNombre(txtNombre.getText().trim());
            p.setProvincia(txtProvincia.getText().trim());
            p.setPais(txtPais.getText().trim());
            p.setContacto(txtContacto.getText().trim());
            p.setIdProducto(obtenerIdProductoCombo);  // ✅ CORRECTO

            // ================= ACTUALIZAR =================
            Ctrl_Proveedor controlProveedor = new Ctrl_Proveedor();
            controlProveedor.actualizar(p);

            listar();
            Limpiar();

            JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar proveedor: " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaProveedores.getSelectedRow();

        // ================= VALIDAR SELECCIÓN =================
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor para eliminar");
            return;
        }

        // ================= CONFIRMACIÓN =================
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea eliminar este proveedor?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {

            // ================= OBTENER ID =================
            int idProveedor = Integer.parseInt(
                    tablaProveedores.getValueAt(fila, 0).toString()
            );

            // ================= ELIMINAR =================
            Ctrl_Proveedor controlProveedor = new Ctrl_Proveedor();
            controlProveedor.eliminar(idProveedor);

            listar();
            Limpiar();

            JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea cerrar sesión?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            this.dispose();               // Cierra InterProveedores
            new Vista.FrmMenu().setVisible(true); // Vuelve al menú principal
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked

        int fila = tablaProveedores.getSelectedRow();

    if (fila >= 0) {
        txtNombre.setText(tablaProveedores.getValueAt(fila, 1).toString());
        txtProvincia.setText(tablaProveedores.getValueAt(fila, 2).toString());
        txtPais.setText(tablaProveedores.getValueAt(fila, 3).toString());
        txtContacto.setText(tablaProveedores.getValueAt(fila, 4).toString());

        //  SELECCIONAR PRODUCTO EN EL COMBO
        String producto = tablaProveedores.getValueAt(fila, 5).toString();
        jComboBox_producto.setSelectedItem(producto);
    }
    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void jComboBox_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_productoActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        //METODO O ACCION PARA QUE AL DAR ENTER CAMBIE DE CAMPO DE INGRESO DE DATOS
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtProvincia.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtProvinciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProvinciaKeyPressed
       //METODO O ACCION PARA QUE AL DAR ENTER CAMBIE DE CAMPO DE INGRESO DE DATOS
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtPais.requestFocus();
        }
    }//GEN-LAST:event_txtProvinciaKeyPressed

    private void txtPaisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyPressed
        //METODO O ACCION PARA QUE AL DAR ENTER CAMBIE DE CAMPO DE INGRESO DE DATOS
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtContacto.requestFocus();
        }
    }//GEN-LAST:event_txtPaisKeyPressed

    private void txtContactoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtContacto.transferFocus();   
    }
    
    }//GEN-LAST:event_txtContactoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecio2;
    private javax.swing.JLabel lblPrecio3;
    private javax.swing.JLabel lblPrecio4;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtProvincia;
    // End of variables declaration//GEN-END:variables

    private void CargarComboProductos() {

    Connection cn = Conexion.conectar();
    String sql = "SELECT nombre FROM productos";

    try (Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        jComboBox_producto.removeAllItems();
        jComboBox_producto.addItem("Seleccione producto");

        while (rs.next()) {
            jComboBox_producto.addItem(rs.getString("nombre"));
        }

    } catch (SQLException e) {
        System.out.println("Error al cargar productos: " + e);
    }
}

    private int obtenerIdProductoCombo = 0;

    private int IdProducto() {

        String sql = "SELECT idProducto FROM productos "
                + "WHERE nombre = '" + this.jComboBox_producto.getSelectedItem() + "'";

        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                obtenerIdProductoCombo = rs.getInt("idProducto");
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener id producto");
        }

        return obtenerIdProductoCombo;
    }

    private void Limpiar() {

        txtNombre.setText("");
        txtProvincia.setText("");
        txtPais.setText("");
        txtContacto.setText("");
        jComboBox_producto.setSelectedIndex(0);

    }

}
