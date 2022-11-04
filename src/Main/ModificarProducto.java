/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexg
 */
public final class ModificarProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form ModificarProducto
     */
    public ModificarProducto() {
        initComponents();
        guardarCambios.setOpaque(false);
        guardarCambios.setContentAreaFilled(false);
        guardarCambios.setBorderPainted(false);
        llenarTabla();
    }
    public void eliminarTabla(){
        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaModificacionProductos.getModel();
        modelo_tabla.setRowCount(0);
    }

    public void llenarTabla(){
        Properties datos = new Properties();
        String servidor;
        String driver;
        datos.put("user", "u7tuhhfbmthsu53c");
        datos.put("password", "Nw5nMTEHvX2U2r3gVAYj");
        servidor = "jdbc:mysql://bosgnclh26bmxuw456hf-mysql.services.clever-cloud.com:3306/bosgnclh26bmxuw456hf";
        driver = "com.mysql.jdbc.Driver";
        String pd_nombre, pd_descripcion;
        double pd_compra, pd_venta;
        String pd_fecha;
        int cableProducto;
        String cadenasql;
        cadenasql = "Select * from Productos";
        System.out.println(cadenasql);
        ResultSet datos_productos;

        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaModificacionProductos.getModel();

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_productos = exe.executeQuery(cadenasql);
                while (datos_productos.next()) {
                    cableProducto = datos_productos.getInt("pd_clv");
                    pd_nombre = datos_productos.getString("pd_nombre");
                    pd_descripcion = datos_productos.getString("pd_descripcion");
                    pd_compra = datos_productos.getDouble("pd_precio_cmp");
                    pd_venta = datos_productos.getDouble("pd_precio_vnt");
                    pd_fecha = datos_productos.getString("pd_fecha_cmp");
                    Object vector[] = {cableProducto, pd_nombre, pd_descripcion, pd_compra, pd_venta, pd_fecha};
                    modelo_tabla.addRow(vector);
                }

                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        lbl_id = new javax.swing.JLabel();
        guardarCambios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaModificacionProductos = new javax.swing.JTable();
        nuevoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nuevaDescripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nuevoPrecioCompra = new javax.swing.JTextField();
        nuevoPrecioVenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

        setBorder(new javax.swing.border.MatteBorder(null));
        setClosable(true);
        setForeground(java.awt.Color.lightGray);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar producto");
        setAutoscrolls(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imagexxcf_103507.png"))); // NOI18N
        setOpaque(true);
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVerifyInputWhenFocusTarget(false);
        setVisible(true);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        lbl_id.setText("Id de producto a modificar: ");

        guardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        guardarCambios.setText("Guardar cambios");
        guardarCambios.setEnabled(false);
        guardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCambiosActionPerformed(evt);
            }
        });

        tablaModificacionProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Precio de compra", "Precio de venta", "Fecha de registro", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaModificacionProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaModificacionProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaModificacionProductos);

        nuevoNombre.setEnabled(false);
        nuevoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoNombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Nuevo nombre");

        jLabel3.setText("Nueva descripcion");

        nuevaDescripcion.setEnabled(false);

        jLabel4.setText("Nuevo precio de compra");

        nuevoPrecioCompra.setEnabled(false);

        nuevoPrecioVenta.setEnabled(false);

        jLabel5.setText("Nuevo precio de venta");

        jLabel1.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Bienvenido a la modificacion de productos");

        jLabel7.setText("Nueva cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_id)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(431, 431, 431)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(guardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(nuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(nuevaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(361, 361, 361)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nuevoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nuevoPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                                .addGap(70, 70, 70)))))))
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nuevoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(nuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nuevaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nuevoPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(2, 2, 2)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(guardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void nuevoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoNombreActionPerformed

    private void tablaModificacionProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaModificacionProductosMouseClicked
        // TODO add your handling code here:

        int renglon;
        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaModificacionProductos.getModel();
        renglon = tablaModificacionProductos.getSelectedRow();
        this.lbl_id.setText("Id de producto a modificar:  " + modelo_tabla.getValueAt(renglon, 0));
        String temp = (String) modelo_tabla.getValueAt(renglon, 1);
        this.nuevoNombre.setText(temp);
        temp = (String) modelo_tabla.getValueAt(renglon, 2);
        this.nuevaDescripcion.setText(temp);
        temp = (String) modelo_tabla.getValueAt(renglon, 3).toString();
        this.nuevoPrecioCompra.setText(temp);
        temp = (String) modelo_tabla.getValueAt(renglon, 4).toString();
        this.nuevoPrecioVenta.setText(temp);
        guardarCambios.setEnabled(true);
        nuevoNombre.setEnabled(true);
        nuevaDescripcion.setEnabled(true);
        nuevoPrecioCompra.setEnabled(true);
        nuevoPrecioVenta.setEnabled(true);


    }//GEN-LAST:event_tablaModificacionProductosMouseClicked

    private void guardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarCambiosActionPerformed
        // TODO add your handling code here:
        Properties datos = new Properties();
        String servidor;
        String driver;
        datos.put("user", "u7tuhhfbmthsu53c");//Guarda el usuario es la cadena dos
        datos.put("password", "Nw5nMTEHvX2U2r3gVAYj");
        servidor = "jdbc:mysql://bosgnclh26bmxuw456hf-mysql.services.clever-cloud.com:3306/bosgnclh26bmxuw456hf";
        driver = "com.mysql.jdbc.Driver";
        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaModificacionProductos.getModel();

        String pd_nombre, pd_descripcion;
        double pd_compra, pd_venta;
        String pd_fecha;
        int pd_clv;
        pd_nombre = this.nuevoNombre.getText();
        pd_descripcion = this.nuevaDescripcion.getText();
        pd_venta = Double.parseDouble(nuevoPrecioVenta.getText());
        pd_compra = Double.parseDouble(nuevoPrecioCompra.getText());
        pd_clv = (int) modelo_tabla.getValueAt(tablaModificacionProductos.getSelectedRow(), 0);
        String cadenasql;
        cadenasql = "update  Productos set pd_nombre='" + pd_nombre + " ',pd_descripcion='" + pd_descripcion + " ' , pd_precio_cmp=" +pd_venta + ", pd_precio_vnt=" + pd_compra + " where pd_clv=" + pd_clv;
        System.out.println(cadenasql);
        
        
        try {
            Class.forName(driver);//Utilizar un driver de tercero (el driver)
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("conecto");
                Statement exe = con.createStatement();
                exe.execute(cadenasql);
                System.out.println("Modificado");
                con.close();
                nuevoNombre.setEnabled(false);
                nuevaDescripcion.setEnabled(false);
                nuevoPrecioCompra.setEnabled(false);
                nuevoPrecioVenta.setEnabled(false);
                guardarCambios.setEnabled(false);
            } else {
                System.out.println("Error");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog( this , "El valor fue modificado correctamente" , "Modificacion" , JOptionPane.INFORMATION_MESSAGE );
        eliminarTabla();
        llenarTabla();
    }//GEN-LAST:event_guardarCambiosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarCambios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JTextField nuevaDescripcion;
    private javax.swing.JTextField nuevoNombre;
    private javax.swing.JTextField nuevoPrecioCompra;
    private javax.swing.JTextField nuevoPrecioVenta;
    private javax.swing.JTable tablaModificacionProductos;
    // End of variables declaration//GEN-END:variables
}
