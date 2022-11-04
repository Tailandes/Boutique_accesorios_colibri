/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.PanelUI;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Alexg
 */
public final class AltaCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaCliente
     */
    int renglon;
    public AltaCliente() {
        initComponents();
        botonTransparente();
       llenarTabla();
    
    }
    public void botonTransparente(){
      guardaCliente.setOpaque(false);
        guardaCliente.setContentAreaFilled(false);
        guardaCliente.setBorderPainted(false);
        /*
        guardarModificacion.setOpaque(false);
        guardarModificacion.setContentAreaFilled(false);
        guardarModificacion.setBorderPainted(false);
        */
        guardarEliminar.setOpaque(false);
        guardarEliminar.setContentAreaFilled(false);
        guardarEliminar.setBorderPainted(false);
    }
    public void borraTabla(){
        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaClientes.getModel();
        modelo_tabla.setRowCount(0);
    }
    public final void llenarTabla(){
        renglon=0;
       Properties datos = new Properties();
        String servidor;
        String driver;
        datos.put("user", "u7tuhhfbmthsu53c");
        datos.put("password", "Nw5nMTEHvX2U2r3gVAYj");
        servidor = "jdbc:mysql://bosgnclh26bmxuw456hf-mysql.services.clever-cloud.com:3306/bosgnclh26bmxuw456hf";
        driver = "com.mysql.jdbc.Driver";
        String cl_nombre,cl_direccion,cl_RFC,cl_email;
        short cl_sexo,cl_edoCivil, cl_enviarCorreo;
        Date cl_fechaNacimiento, cl_fechaRegistro;
        int claveProducto;
        String cadenasql;
        cadenasql ="Select * from Clientes";
        System.out.println(cadenasql);
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
                    claveProducto= datos_cliente.getInt("cl_clv");
                    cl_nombre= datos_cliente.getString("cl_nombre");
                    cl_direccion= datos_cliente.getString("cl_direccion");
                    cl_RFC= datos_cliente.getString("cl_RFC");
                    cl_sexo= datos_cliente.getShort("cl_sexo");
                    cl_fechaNacimiento= datos_cliente.getDate("cl_fecha_de_naciemiento");
                    cl_fechaRegistro = datos_cliente.getDate("cl_fecha_de_registro");
                    cl_edoCivil = datos_cliente.getShort("cl_edo_civil");
                    cl_email = datos_cliente.getString("cl_email");
                    cl_enviarCorreo = datos_cliente.getShort("cl_enviar_correo");
                    Object vector[]={claveProducto, cl_nombre, cl_direccion, cl_RFC, cl_sexo,cl_fechaNacimiento, cl_fechaRegistro, cl_edoCivil, cl_email, cl_enviarCorreo};
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreClienteAlta = new javax.swing.JTextField();
        guardaCliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        clienteEmail = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        guardarEliminar = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
        setAutoscrolls(true);
        setFocusable(false);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imagexxcf_103507.png"))); // NOI18N
        setVisible(true);

        tablaClientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id de compra", "Nombre cliente", "Total de compra", "Cantidad pagada", "Cantidad restante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        jTabbedPane1.setAutoscrolls(true);

        jToolBar1.setBackground(new java.awt.Color(153, 153, 153));
        jToolBar1.setAutoscrolls(true);
        jToolBar1.setEnabled(false);
        jToolBar1.setOpaque(false);
        jToolBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToolBar1MouseClicked(evt);
            }
        });

        jPanel1.setAutoscrolls(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/persona.png"))); // NOI18N
        jLabel2.setText("Introduce el nombre del cliente");

        txtNombreClienteAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteAltaActionPerformed(evt);
            }
        });

        guardaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/notificacion si.png"))); // NOI18N
        guardaCliente.setText("Guardar");
        guardaCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/echo.png"))); // NOI18N
        guardaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaClienteActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/email.png"))); // NOI18N
        jLabel10.setText("Introduce el numero de telefono");

        jLabel20.setText("Cantidad de abono");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Id de compra:");

        jLabel4.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(guardaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(346, 346, 346))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreClienteAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(clienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreClienteAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(guardaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );

        jToolBar1.add(jPanel1);

        jTabbedPane1.addTab("Abono", new javax.swing.ImageIcon(getClass().getResource("/iconos/mas.png")), jToolBar1, ""); // NOI18N

        jToolBar3.setRollover(true);
        jToolBar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToolBar3MouseClicked(evt);
            }
        });

        jPanel3.setBackground(java.awt.SystemColor.window);
        jPanel3.setAutoscrolls(true);

        lbl.setText("Introduce la clave de compra a eliminar");

        guardarEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        guardarEliminar.setText("Eliminar");
        guardarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarEliminarActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guardarEliminar))
                .addGap(0, 527, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(guardarEliminar)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jToolBar3.add(jPanel3);

        jTabbedPane1.addTab("Revertir", new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png")), jToolBar3); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/busqueda (1).png"))); // NOI18N

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:
        /*int renglon;
        DefaultTableModel modelo_tabla = (DefaultTableModel)this.tablaClientes.getModel();
        renglon = tablaClientes.getSelectedRow();
        this.lbl_eliminar.setText(""+modelo_tabla.getValueAt(renglon, 0));
         this.lbl_modificar.setText(""+modelo_tabla.getValueAt(renglon, 0));
       String temp = (String) modelo_tabla.getValueAt(renglon, 1);
        this.txtNombreClienteModificar.setText(temp);
        temp = (String) modelo_tabla.getValueAt(renglon, 2);
        this.txtDireccionClienteModificar.setText(temp);
        temp = (String) modelo_tabla.getValueAt(renglon, 3).toString();
        this.clienteRfcModificar.setText(temp);
        temp = (String) modelo_tabla.getValueAt(renglon, 4).toString();
        if (temp.equals("0")) {
            masculinoModificar.setSelected(true);
        }else if (temp.equals("1")) {
            femeninoModificar.setSelected(true);
        }else if (temp.equals("2")) {
            otro1.setSelected(true);
        }
        Date fecha = (Date) modelo_tabla.getValueAt(renglon, 5);
        this.clienteFechaNacimientoModificar.setDate(fecha);
        fecha = (Date)modelo_tabla.getValueAt(renglon, 6);
        this.clienteFechaRegistroModificar.setDate(fecha);
        temp = (String) modelo_tabla.getValueAt(renglon, 7).toString();
        //0 para soltero
        //1 para casado
        //2 para otro
        if (temp.equals("0")) {
            clienteSolteroModificar.setSelected(true);
            
        }else if (temp.equals("1")) {
            clienteCasadoModificar.setSelected(true);
            
        }else if (temp.equals("2")) {
            clienteOtroModificar.setSelected(true);
            
        }
        
         temp = (String) modelo_tabla.getValueAt(renglon, 8).toString();
         this.clienteEmailModificar.setText(temp);
          temp = (String) modelo_tabla.getValueAt(renglon, 9).toString();
          if (temp.equals("0")) {
            clienteNoModificar.setSelected(true);
        }else if (temp.equals("1")) {
            clienteSiModificar.setSelected(true);
        }
       */
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jToolBar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToolBar3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jToolBar3MouseClicked

    private void guardarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarEliminarActionPerformed
        // TODO add your handling code here:
        //int clave;
        //clave= Integer.parseInt(this.lbl_eliminar.getText());
        //String cadenasql= "Delete from Clientes where cl_clv="+clave;
        Properties datos =  new  Properties();
        String servidor;
        String driver;
        datos.put("user", "u7tuhhfbmthsu53c");
        datos.put("password", "Nw5nMTEHvX2U2r3gVAYj");
        servidor = "jdbc:mysql://bosgnclh26bmxuw456hf-mysql.services.clever-cloud.com:3306/bosgnclh26bmxuw456hf";
        driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {

                System.out.println("elimino");
                Statement exe = con.createStatement();
                //exe.execute(cadenasql);
                con.close();

            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog( this , "El valor fue eliminado correctamente" , "Eliminacion" , JOptionPane.INFORMATION_MESSAGE );
        //lbl_eliminar.setText("");
        borraTabla();
        llenarTabla();
    }//GEN-LAST:event_guardarEliminarActionPerformed

    private void jToolBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToolBar1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jToolBar1MouseClicked

    private void guardaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaClienteActionPerformed
        // TODO add your handling code here:
        Properties datos = new Properties();
        String servidor;
        String driver;
        datos.put("user", "u7tuhhfbmthsu53c");
        datos.put("password", "Nw5nMTEHvX2U2r3gVAYj");
        servidor = "jdbc:mysql://bosgnclh26bmxuw456hf-mysql.services.clever-cloud.com:3306/bosgnclh26bmxuw456hf";
        driver = "com.mysql.jdbc.Driver";
        String nombre,direccion,rfc,cl_fechaNacimiento,cl_fechaRegistro, cl_email;
        String cadenasql;
        short cl_sexo=0,cl_edoCivil=0, cl_enviarCorreo;
/*
        nombre = this.txtNombreClienteAlta.getText();
        direccion =  this.txtDireccionClienteAlta.getText();
        rfc = this.clienteRfcAlta.getText();
        Date fechaNac=this.clienteFechaNacimientoAlta.getDate();
        cl_fechaNacimiento=""+(fechaNac.getYear() +1900)+"-"+(fechaNac.getMonth()+1)+"-"+(fechaNac.getDay());
        Date fechaRe =  this.clienteFechaRegistroAlta.getDate();
        cl_fechaRegistro = ""+(fechaRe.getYear() +1900)+"-"+(fechaRe.getMonth()+1)+"-"+(fechaRe.getDay());
        cl_email = this.clienteEmail.getText();

        //         pd_fecha = ""+(fecha.getYear() + 1900)+"-"+(fecha.getMonth() +1)+"-"+(fecha.getDay());
        if (this.femenino.isSelected()) {
            cl_sexo=1;
        }else if (this.masculino.isSelected()) {
            cl_sexo=0;
        }else if (this.otro.isSelected()) {
            cl_sexo=2;
        }
        //0 para soltero
        //1 para casado
        //2 para otro
        if (this.clienteCasado.isSelected()) {
            cl_edoCivil=1;
        }else if (this.clienteSoltero.isSelected()) {
            cl_edoCivil=0;
        }else if (this.clienteOtroEdoCivil.isSelected()) {
            cl_edoCivil=2;
        }
        //1 para si
        //0 para no
        if (this.clienteSi.isSelected()) {
            cl_enviarCorreo=1;
        }else {
            cl_enviarCorreo=0;
        }
        cadenasql = "insert into Clientes  (cl_nombre,cl_direccion,cl_RFC,cl_sexo,cl_fecha_de_naciemiento,cl_fecha_de_registro,cl_edo_civil,cl_email,cl_enviar_correo) values ('";
        cadenasql = cadenasql+ nombre+"','";
        cadenasql = cadenasql+ direccion + "','";
        cadenasql = cadenasql+ rfc + "',";
        cadenasql =cadenasql+ cl_sexo +",'";
        cadenasql = cadenasql+ cl_fechaNacimiento+ "','";
        cadenasql = cadenasql+ cl_fechaRegistro+"',";
        cadenasql = cadenasql+ cl_edoCivil +",'";
        cadenasql = cadenasql+ cl_email +"',";
        cadenasql = cadenasql+ cl_enviarCorreo+ ")";
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
        this.txtNombreClienteAlta.setText("");
        */

        this.clienteEmail.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
        borraTabla();
        llenarTabla();
        JOptionPane.showMessageDialog( this , "El valor fue agregado correctamente" , "Alta" , JOptionPane.INFORMATION_MESSAGE );
    }//GEN-LAST:event_guardaClienteActionPerformed

    private void txtNombreClienteAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteAltaActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTextField clienteEmail;
    private javax.swing.JButton guardaCliente;
    private javax.swing.JButton guardarEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel lbl;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtNombreClienteAlta;
    // End of variables declaration//GEN-END:variables
}
