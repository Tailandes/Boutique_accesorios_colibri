/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexg
 */
public class ProcesarCompraCredito extends javax.swing.JFrame {
    Ventas infoVenta = new Ventas();
    Properties datos = new Properties();
            String servidor;
            String driver;
    boolean bandera =  false;
            
    /**
     * Creates new form ProcesarCompraCredito
     */
    public ProcesarCompraCredito() {
        initComponents();
        llenarTabla();
         datos.put("user", "root");
        datos.put("password", "");
        servidor = "jdbc:mysql://127.0.0.1/boutique_accesorios_colibri";
        driver = "com.mysql.jdbc.Driver";
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        procesarCompra = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textNameClient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textPago1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textTel = new javax.swing.JTextField();
        textClientes = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Compra a credito");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/busqueda (1).png"))); // NOI18N

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "nombre", "tel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(350);
        }

        procesarCompra.setText("Procesar");
        procesarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarCompraActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nombre del cliente:");

        textNameClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameClientActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad de primer pago:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Numero de telefono:");

        textTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelActionPerformed(evt);
            }
        });

        textClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textClientesKeyReleased(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(procesarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(textNameClient, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(textPago1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(textTel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(textClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(procesarCompra)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textClientes))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(textNameClient, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textPago1)
                            .addComponent(textTel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNameClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(textPago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(procesarCompra)
                            .addComponent(jButton2))
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNameClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameClientActionPerformed

    private void procesarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarCompraActionPerformed
        // TODO add your handling code here:
       
        String nombre= textNameClient.getText(),tel= textTel.getText();
        float pago =0;
        pago= Float.parseFloat(textPago1.getText());
        //infoVenta.obtenerDatosVenta();
        //Object info [][] =infoVenta.getVenta();
        
        
        LocalDate fechaVenta = LocalDate.now();
        String fecha = (String) fechaVenta.toString();
       int idinventario=1;
        int user=1;
        Ventas objeto = new Ventas();
        if (!nombre.equals("") && !tel.equals("") && pago !=0) {
            int idVentaC = obtenerIdVenta();
            idVentaC++;
            
            /*
            for (int i = 0; i < info.length; i++) {
             
            //int idVenta = infoVenta.obtenerIdVenta();
             //idVenta++;
             String cadenasql = "select idinventario from inventarios where productos_idproducto = '" + info[i][0] + "'";
                ResultSet datos_cliente;
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(servidor, datos);
                    if (con != null) {

                        Statement exe = con.createStatement();
                        datos_cliente = exe.executeQuery(cadenasql);
                        while (datos_cliente.next()) {
                            idinventario = datos_cliente.getInt("idinventario");

                        }
                        con.close();

                    } else {
                        System.out.println("No conecto");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                cadenasql = "INSERT INTO `ventas`(`idventa`, `totalventa`, `fechaventa`, `tipoventa`, `estatusventa`, `users_idusuario`, `inventarios_idinventario`, `num_venta`, `cantProd`) VALUES ('" + getid("select MAX(idventa) from ventas") + "','" + infoVenta.ObtenerCuenta() + "','" + fecha + "','Credito','En proceso','" + user + "','" + idinventario + "', '" + infoVenta.obtenerReferenciaVenta() + "','"+info[i][1]+"')";
                String cadenasql1= "UPDATE inventarios set cantidadvendida = (SELECT cantidadvendida from inventarios WHERE idinventario ="+idinventario+" )+ "+info[i][1]+" where idinventario= "+idinventario;
                String sql1="UPDATE productos set existencia = existencia- "+info[i][1]+"  WHERE idproducto="+info[i][0];
                System.out.println(cadenasql);
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(servidor, datos);
                    if (con != null) {
                        System.out.println("Conectobusqueda");
                        Statement exe = con.createStatement();
                        exe.executeUpdate(cadenasql);
                        exe.executeUpdate(cadenasql1);
                        exe.executeUpdate(sql1);
                        con.close();

                    } else {
                        System.out.println("No conecto");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
            //String cadenasql = "SELECT MAX(idabonos) id FROM abonos";
            String credito ="INSERT INTO `abonos`(`idabono`, `cantidad_abono`) VALUES ("+getid("SELECT MAX(idabono) id FROM abonos")+","+pago+")";
            String cliente = "INSERT INTO `clientes`(`idcliente`, `tel`, `nombre`, `deudatotal`) VALUES ("+getid("SELECT MAX(idcliente)id from clientes")+","+tel+",'"+nombre+"',0)";
            String venta_credito ="INSERT INTO `ventas_credito`(`idventacredito`, `clientes_idcliente`, `ventas_idventa`, `abonos_idabono`, `deudarestante`) VALUES ("+idVentaC+","+getid("SELECT MAX(idcliente)id from clientes")+","+getid("select (MAX(idventa)-1)id from ventas")+","+getid("SELECT MAX(idabono)id  FROM abonos")+",0)";
            String sql = ("UPDATE `ventas` SET `estatusventa`='En proceso' WHERE num_venta = (SELECT num_venta from ventas WHERE (SELECT MAX(idventa) FROM ventas) = idventa)");
             try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(servidor, datos);
                    if (con != null) {
                        System.out.println("conecto credito");
                        Statement exe = con.createStatement();
                        exe.executeUpdate(credito);
                        exe.executeUpdate(cliente);
                        exe.executeUpdate(venta_credito);
                        exe.executeUpdate(sql);
                        con.close();
                        objeto.bandera=false;
                    } else {
                        System.out.println("No conecto");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        textNameClient.setText("");
        textPago1.setText("");
        textTel.setText("");
        borraTabla();
        llenarTabla();
        JOptionPane.showMessageDialog(rootPane, "La compra a credito ha sido exitosa");
    }//GEN-LAST:event_procesarCompraActionPerformed

    
    public int getid(String sql){
        int id = 0;
        String cadenasql = sql;
        ResultSet datos_cliente;

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conectobusqueda");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    id = datos_cliente.getInt("id");

                }

                con.close();

            } else {
                System.out.println("No conecto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        id++;
        return id;
    }
    private void textTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelActionPerformed

    private void textClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textClientesKeyReleased
        // TODO add your handling code here:
         
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) {
            borraTabla();
            buscar();
        }
    }//GEN-LAST:event_textClientesKeyReleased
    
    public void buscar(){
        //borraTabla(); 
        String textoBusqueda = textClientes.getText();
        String nombre,tel;
        int id;
        Properties datos = new Properties();
        String servidor;
        String driver;
        datos.put("user", "root");
        datos.put("password", "");
        servidor = "jdbc:mysql://127.0.0.1/boutique_accesorios_colibri";
        driver = "com.mysql.jdbc.Driver";

        String cadenasql = "SELECT idcliente, nombre, tel from clientes where nombre like '" + textoBusqueda + "%'";
        ResultSet datos_cliente;
        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaClientes.getModel();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conectobusqueda");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    id = datos_cliente.getInt("idcliente");
                    nombre = datos_cliente.getString("nombre");
                    tel = datos_cliente.getString("tel");
                    Object vector[] = {id, nombre, tel};
                    modelo_tabla.addRow(vector);

                }

                con.close();
                
            } else {
                System.out.println("No conecto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int obtenerIdVenta() {
        
        int id = 0;
        String cadenasql = "SELECT MAX(idventacredito) id FROM ventas_credito";
        ResultSet datos_cliente;

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conectobusqueda");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    id = datos_cliente.getInt("id");

                }

                con.close();

            } else {
                System.out.println("No conecto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
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
            java.util.logging.Logger.getLogger(ProcesarCompraCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcesarCompraCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcesarCompraCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcesarCompraCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcesarCompraCredito().setVisible(true);
            }
        });
    }
   public void llenarTabla(){
       Properties datos = new Properties();
        String servidor;
        String driver;
        datos.put("user", "root");
        datos.put("password", "");
        servidor = "jdbc:mysql://127.0.0.1/boutique_accesorios_colibri";
        driver = "com.mysql.jdbc.Driver";
        String nombre,tel;
        int idventacredito;
        String cadenasql="SELECT v.idventacredito, (SELECT c.nombre FROM clientes c WHERE v.clientes_idcliente = c.idcliente) nombre, (SELECT c.tel FROM clientes c WHERE v.clientes_idcliente = c.idcliente) tel from ventas_credito v";
        
        ResultSet datos_cliente;
        
        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaClientes.getModel();
        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente= exe.executeQuery(cadenasql);
                while (datos_cliente.next()){
                    idventacredito = datos_cliente.getInt("idventacredito");
                    nombre = datos_cliente.getString("nombre");
                    tel = datos_cliente.getString("tel");
                    
                    Object vector[]={idventacredito,nombre,tel};
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
   
   public void borraTabla(){
        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaClientes.getModel();
        modelo_tabla.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton procesarCompra;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField textClientes;
    private javax.swing.JTextField textNameClient;
    private javax.swing.JTextField textPago1;
    private javax.swing.JTextField textTel;
    // End of variables declaration//GEN-END:variables
}