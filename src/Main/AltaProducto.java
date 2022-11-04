/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Alexg
 */
public class AltaProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaProducto
     */
    public AltaProducto() {
        initComponents();
        
        guardarProducto.setOpaque(false);
        guardarProducto.setContentAreaFilled(false);
        guardarProducto.setBorderPainted(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionProducto = new javax.swing.JTextArea();
        fechaCompra = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        guardarProducto = new javax.swing.JButton();
        precioVenta = new javax.swing.JSpinner();
        precioCompra = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imagexxcf_103507.png"))); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 67, -1, -1));

        jLabel2.setText("Descripcion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 162, -1, -1));

        jLabel3.setText("Precio de venta");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 301, -1, -1));

        jLabel5.setText("Fecha de registro");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));
        getContentPane().add(nombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 99, 263, -1));

        jScrollPane2.setAutoscrolls(true);

        descripcionProducto.setColumns(20);
        descripcionProducto.setRows(5);
        jScrollPane2.setViewportView(descripcionProducto);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 182, 292, -1));
        getContentPane().add(fechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 131, -1));

        jLabel6.setText("Precio de compra");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 352, -1, -1));

        guardarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/echo.png"))); // NOI18N
        guardarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        guardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(guardarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 90, 70));

        precioVenta.setModel(new javax.swing.SpinnerNumberModel(100.0d, null, null, 1.0d));
        getContentPane().add(precioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        precioCompra.setModel(new javax.swing.SpinnerNumberModel(100.0d, null, null, 1.0d));
        getContentPane().add(precioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel4.setText("Cantidad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, -1, -1));
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Alta de producto");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 200, -1));

        getAccessibleContext().setAccessibleName("AltaProducto");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProductoActionPerformed
        // TODO add your handling code here:
        Properties datos = new Properties();
        String servidor;
        String driver;
        datos.put("user", "u7tuhhfbmthsu53c");
        datos.put("password", "Nw5nMTEHvX2U2r3gVAYj");
        servidor = "jdbc:mysql://bosgnclh26bmxuw456hf-mysql.services.clever-cloud.com:3306/bosgnclh26bmxuw456hf";
         driver = "com.mysql.jdbc.Driver";
        String pd_nombre,pd_descripcion;
        double pd_compra,pd_venta;
        String pd_fecha;
        String cadenasql;
        pd_nombre =this.nombreProducto.getText();
        pd_descripcion =  this.descripcionProducto.getText();
        pd_compra = (Double)this.precioCompra.getValue();
        pd_venta = (Double) this.precioVenta.getValue();
        Date fecha = this.fechaCompra.getDate();
        pd_fecha = ""+(fecha.getYear() + 1900)+"-"+(fecha.getMonth() +1)+"-"+(fecha.getDay());
        
        cadenasql = "insert into Productos  (pd_nombre,pd_descripcion,pd_precio_cmp, pd_precio_vnt, pd_fecha_cmp) values ('";
       cadenasql  = cadenasql + pd_nombre+" ',' ";
       cadenasql =  cadenasql + pd_descripcion + "', ";
       cadenasql =cadenasql + pd_compra + ",";
       cadenasql =  cadenasql + pd_venta + ", ' ";
       cadenasql = cadenasql  + pd_fecha+"' )";
        System.out.println(cadenasql);
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                exe.execute(cadenasql);
                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog( this , "El valor fue agregado correctamente" , "Alta" , JOptionPane.INFORMATION_MESSAGE );
    }//GEN-LAST:event_guardarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea descripcionProducto;
    private com.toedter.calendar.JDateChooser fechaCompra;
    private javax.swing.JButton guardarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JSpinner precioCompra;
    private javax.swing.JSpinner precioVenta;
    // End of variables declaration//GEN-END:variables
}
