/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PRIV4
 */
public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    public Inventario() throws ClassNotFoundException, SQLException {
        initComponents();
        String Cadena = "jdbc:mysql://127.0.0.1/boutique_accesorios_colibri";
    String Driver = "com.mysql.jdbc.Driver";
    String Usuario = "root";
    String Contraseña = "";
    
    
        int IdProducto;
        String Nombre;
        int Categoria, Existencia;
        String cadenasql;
        
        cadenasql= "Select * from inventario";
        
        System.out.println(cadenasql);
        ResultSet datos_productos;
        DefaultTableModel modelo_tabla=(DefaultTableModel)this.jTable1.getModel();
        try {
            Class.forName(Driver);//Utilizar un driver de tercero (el driver)
            java.sql.Connection con = DriverManager.getConnection(Cadena, Usuario, Contraseña);
            if(con!= null)
                    {
                        System.out.println("conecto");
                        Statement exe = con.createStatement();
                        datos_productos=exe.executeQuery(cadenasql);
                        while(datos_productos.next())
                        {
                            IdProducto=datos_productos.getInt("IdProducto");
                            Nombre=datos_productos.getString("Nombre");
                            Categoria=datos_productos.getInt("Categoria");
                            Existencia=datos_productos.getInt("Existencia")
                                    ;
                            Object vector[]={IdProducto,Nombre,Categoria,Existencia};
                            modelo_tabla.addRow(vector);
                        }
                        con.close();
                    }
                    else
                    {
                        System.out.println("Error");
                    }
        } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (SQLException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVENTARIO");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdProducto", "Nombre", "Categoria", "Existencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        int renglon;
//        DefaultTableModel modelo_tabla=(DefaultTableModel)this.jTable1.getModel();
//        renglon = jTable1.getSelectedRow();
//        this.Claves.setText("Clave: "+ modelo_tabla.getValueAt(renglon, 0));
//        String temp=(String)modelo_tabla.getValueAt(renglon, 1);
//        this.Txt_Nombre.setText(temp);
//        temp=(String)modelo_tabla.getValueAt(renglon, 2);
//        this.Txt_Descripcion.setText(temp);
//        temp=modelo_tabla.getValueAt(renglon, 3).toString();
//        this.Txt_Precio_cmp.setText(temp);
//        temp=modelo_tabla.getValueAt(renglon, 4).toString();
//        this.Txt_Precio_vnt.setText(temp);
//        temp=(String)modelo_tabla.getValueAt(renglon, 5);
//        this.Txt_Fecha.setText(temp);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inventario().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}