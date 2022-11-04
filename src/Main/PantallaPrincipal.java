/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Alexg
 */
public final class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        transparentes();
    }

    public void transparentes() {
        toggleproducto.setOpaque(false);
        toggleproducto.setContentAreaFilled(false);
        toggleproducto.setBorderPainted(false);
        clientesBoton.setOpaque(false);
        clientesBoton.setContentAreaFilled(false);
        clientesBoton.setBorderPainted(false);
        ventaBoton.setOpaque(false);
        ventaBoton.setContentAreaFilled(false);
        ventaBoton.setBorderPainted(false);
        reportesBoton.setOpaque(false);
        reportesBoton.setContentAreaFilled(false);
        reportesBoton.setBorderPainted(false);
        agregarProductoBoton.setOpaque(false);
        agregarProductoBoton.setContentAreaFilled(false);
        agregarProductoBoton.setBorderPainted(false);
        agregarProductoBoton.setVisible(false);
        cambiarProductoBoton.setOpaque(false);
        cambiarProductoBoton.setContentAreaFilled(false);
        cambiarProductoBoton.setBorderPainted(false);
        cambiarProductoBoton.setVisible(false);
        deleteProductoBoton.setOpaque(false);
        deleteProductoBoton.setContentAreaFilled(false);
        deleteProductoBoton.setBorderPainted(false);
        deleteProductoBoton.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu6 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        toggleproducto = new javax.swing.JToggleButton();
        agregarProductoBoton = new javax.swing.JButton();
        cambiarProductoBoton = new javax.swing.JButton();
        deleteProductoBoton = new javax.swing.JButton();
        clientesBoton = new javax.swing.JButton();
        ventaBoton = new javax.swing.JButton();
        reportesBoton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        producto = new javax.swing.JMenu();
        altaProducto = new javax.swing.JMenuItem();
        modificacionCliente = new javax.swing.JMenuItem();
        eliminarProducto = new javax.swing.JMenuItem();
        cliente = new javax.swing.JMenu();
        datoCliente = new javax.swing.JMenuItem();
        ventas = new javax.swing.JMenu();
        reportes = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();
        info = new javax.swing.JMenu();

        jMenu6.setText("jMenu6");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar4.add(jMenu5);

        jMenu7.setText("Edit");
        jMenuBar4.add(jMenu7);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);

        escritorio.setBackground(new java.awt.Color(255, 255, 255));
        escritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        escritorio.setToolTipText("");
        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        escritorio.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        escritorio.setFocusCycleRoot(false);
        escritorio.setFocusable(false);
        escritorio.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/BIENVENIDO.png"))); // NOI18N
        jLabel1.setText("Bienvenido");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setFocusCycleRoot(true);
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        toggleproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/producto.png"))); // NOI18N
        toggleproducto.setToolTipText("");
        toggleproducto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toggleproductoStateChanged(evt);
            }
        });
        toggleproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleproductoActionPerformed(evt);
            }
        });

        agregarProductoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        agregarProductoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoBotonActionPerformed(evt);
            }
        });

        cambiarProductoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        cambiarProductoBoton.setToolTipText("");
        cambiarProductoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarProductoBotonActionPerformed(evt);
            }
        });

        deleteProductoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        deleteProductoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductoBotonActionPerformed(evt);
            }
        });

        clientesBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clientes.png"))); // NOI18N
        clientesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesBotonActionPerformed(evt);
            }
        });

        ventaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/venta.png"))); // NOI18N
        ventaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaBotonActionPerformed(evt);
            }
        });

        reportesBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/reporte.png"))); // NOI18N
        reportesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesBotonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("Productos");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("Credito");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Ventas");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Reportes");

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(toggleproducto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(agregarProductoBoton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cambiarProductoBoton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(deleteProductoBoton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(clientesBoton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(ventaBoton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(reportesBoton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(agregarProductoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cambiarProductoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteProductoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toggleproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientesBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ventaBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reportesBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clientesBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ventaBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportesBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(toggleproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cambiarProductoBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteProductoBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarProductoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(371, Short.MAX_VALUE))
        );

        producto.setText("Producto");
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });

        altaProducto.setText("Alta");
        altaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaProductoActionPerformed(evt);
            }
        });
        producto.add(altaProducto);

        modificacionCliente.setText("Modificar");
        modificacionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificacionClienteActionPerformed(evt);
            }
        });
        producto.add(modificacionCliente);

        eliminarProducto.setText("Eliminar");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });
        producto.add(eliminarProducto);

        jMenuBar1.add(producto);

        cliente.setText("Clientes");

        datoCliente.setText("Datos");
        datoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datoClienteActionPerformed(evt);
            }
        });
        cliente.add(datoCliente);

        jMenuBar1.add(cliente);

        ventas.setText("Ventas");
        jMenuBar1.add(ventas);

        reportes.setText("Reportes");
        jMenuBar1.add(reportes);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        menuSalir.add(salir);

        jMenuBar1.add(menuSalir);

        info.setText("Info");
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoMouseClicked(evt);
            }
        });
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        jMenuBar1.add(info);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed
        try {
            // TODO add your handling code here:
            EliminarProducto eliminar = new EliminarProducto();
            this.escritorio.add(eliminar);
            eliminar.setVisible(true);
            eliminar.setSize(escritorio.getSize());
            eliminar.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eliminarProductoActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_menuSalirActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
int resp = JOptionPane.showConfirmDialog(escritorio, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp ==0) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_productoActionPerformed

    private void datoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datoClienteActionPerformed
        try {
            // TODO add your handling code here:
            AltaCliente nuevoCliente = new AltaCliente();
            this.escritorio.add(nuevoCliente);
            nuevoCliente.setVisible(true);
            nuevoCliente.setSize(escritorio.getSize());
            nuevoCliente.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_datoClienteActionPerformed

    private void altaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaProductoActionPerformed
        try {
            // TODO add your handling code here:
            AltaProducto nuevoProducto = new AltaProducto();
            this.escritorio.add(nuevoProducto);
            nuevoProducto.setVisible(true);
            nuevoProducto.setSelected(true);
//            nuevoProducto.moveToFront();
            
            escritorio.repaint();
            nuevoProducto.setSize(escritorio.getSize());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_altaProductoActionPerformed

    private void modificacionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificacionClienteActionPerformed
        try {
            // TODO add your handling code here:
            ModificarProducto modificarProducto = new ModificarProducto();
            this.escritorio.add(modificarProducto);
            modificarProducto.setVisible(true);
            modificarProducto.setSelected(true);
            modificarProducto.setSize(escritorio.getSize());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificacionClienteActionPerformed

    private void agregarProductoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductoBotonActionPerformed
        // TODO add your handling code here:
        altaProductoActionPerformed(evt);
        toggleproducto.doClick();
    }//GEN-LAST:event_agregarProductoBotonActionPerformed

    private void cambiarProductoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarProductoBotonActionPerformed
        // TODO add your handling code here:
        modificacionClienteActionPerformed(evt);
        toggleproducto.doClick();
    }//GEN-LAST:event_cambiarProductoBotonActionPerformed

    private void ventaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaBotonActionPerformed
        // TODO add your handling code here:
        Ventas ventas= new Ventas();
        ventas.setVisible(true);
    }//GEN-LAST:event_ventaBotonActionPerformed

    private void toggleproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleproductoActionPerformed
        // TODO add your handling code here:
        if (toggleproducto.isSelected()) {
            agregarProductoBoton.setVisible(true);
            cambiarProductoBoton.setVisible(true);
            deleteProductoBoton.setVisible(true);
        } else {
            agregarProductoBoton.setVisible(false);
            cambiarProductoBoton.setVisible(false);
            deleteProductoBoton.setVisible(false);
        }


    }//GEN-LAST:event_toggleproductoActionPerformed

    private void toggleproductoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toggleproductoStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_toggleproductoStateChanged

    private void deleteProductoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductoBotonActionPerformed
        // TODO add your handling code here:
        eliminarProductoActionPerformed(evt);
        toggleproducto.doClick();
    }//GEN-LAST:event_deleteProductoBotonActionPerformed

    private void reportesBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesBotonActionPerformed
        // TODO add your handling code here:
                Reportes repo = new Reportes();
                repo.setVisible(true);

    }//GEN-LAST:event_reportesBotonActionPerformed

    private void clientesBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesBotonActionPerformed
        // TODO add your handling code here:
        datoClienteActionPerformed(evt);
    }//GEN-LAST:event_clientesBotonActionPerformed

    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_infoActionPerformed

    private void infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog( this , "Ivan Alejandro Gallegos Martinez.\nJose Guadalupe Espinoza Flores" , "Alumnos 4-B ISC" , JOptionPane.OK_OPTION );
    }//GEN-LAST:event_infoMouseClicked

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarProductoBoton;
    private javax.swing.JMenuItem altaProducto;
    private javax.swing.JButton cambiarProductoBoton;
    private javax.swing.JMenu cliente;
    private javax.swing.JButton clientesBoton;
    private javax.swing.JMenuItem datoCliente;
    private javax.swing.JButton deleteProductoBoton;
    private javax.swing.JMenuItem eliminarProducto;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu info;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenuItem modificacionCliente;
    private javax.swing.JMenu producto;
    private javax.swing.JMenu reportes;
    private javax.swing.JButton reportesBoton;
    private javax.swing.JMenuItem salir;
    private javax.swing.JToggleButton toggleproducto;
    private javax.swing.JButton ventaBoton;
    private javax.swing.JMenu ventas;
    // End of variables declaration//GEN-END:variables
}
