/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexg
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    Properties datos = new Properties();
    String servidor;
    String driver;

    public Reportes() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        datos.put("user", "root");
        datos.put("password", "");
        servidor = "jdbc:mysql://127.0.0.1/boutique_accesorios_colibri";
        driver = "com.mysql.jdbc.Driver";
        llenadoTablaInventario();
        llenadoTablaVentas();
        piezaMayorStock();
        TablaDeudores();

    }
    public void llenadoTablaVentas(){
        int id;
        String productos,categoria,fecha;
        float total;
        
        String cadenasql="SELECT v.num_venta,v.fechaventa,p.nombre, p.categoria, v.totalventa from ventas v, productos p, inventarios i WHERE  v.inventarios_idinventario = i.idinventario and i.productos_idproducto = p.idproducto ORDER by v.num_venta DESC";
        ResultSet datos_cliente;

        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaVentas.getModel();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    id = datos_cliente.getInt("v.num_venta");
                    productos= datos_cliente.getString("p.nombre");
                    categoria = datos_cliente.getString("p.categoria");
                    fecha= datos_cliente.getString("v.fechaventa");
                    total= datos_cliente.getFloat("v.totalventa");
                    
                    

                    Object vector[] = {id,productos, categoria, fecha, total};
                    modelo_tabla.addRow(vector);
                }

                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalVendido();
        
    }
    public void totalVendido(){
        float total = 0;
        String cadenasql="SELECT v.totalventa vt from ventas v GROUP BY v.num_venta ";
        
        ResultSet datos_cliente;

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    total += datos_cliente.getFloat("vt");
                    
                }
                totalV.setText(String.valueOf(total));
                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        CantVendida();
    }
    public void CantVendida(){
    int unidadesVendidas = 0, unidades=0;
    String nombre = "", nombretemp = "";
    Object vector1[];
    
        String cadenasql="SELECT SUM(i.cantidadvendida)cv, p.nombre from productos p, inventarios i WHERE i.productos_idproducto =  p.idproducto GROUP by p.categoria ";
        
        ResultSet datos_cliente;

        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    unidadesVendidas = datos_cliente.getInt("cv");
                    nombre = datos_cliente.getString("p.nombre");
                    
                    if (unidadesVendidas > unidades) {
                        unidades = unidadesVendidas;
                        nombretemp= nombre;
                    }
                }
                tipProd.setText(nombretemp);
                cantProd.setText(String.valueOf(unidades));
                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public void llenadoTablaInventario() {
        int id;
        String nombre, fechaRegistro;
        float precioVenta, precioCompra;

        String cadenasql = "SELECT idproducto,nombre,fecharegistro, precioventa,preciocompra, existencia from productos order by  existencia DESC";

        ResultSet datos_cliente;

        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaInventario.getModel();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    id = datos_cliente.getInt("idproducto");
                    nombre = datos_cliente.getString("nombre");
                    fechaRegistro = datos_cliente.getString("fecharegistro");
                    precioVenta = datos_cliente.getFloat("precioventa");
                    precioCompra = datos_cliente.getFloat("preciocompra");

                    Object vector[] = {id, nombre, fechaRegistro, precioVenta, precioCompra};
                    modelo_tabla.addRow(vector);
                }

                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalInvertido();
    }
   public void piezaMayorStock(){
       int existencia = 0, unidades=0;
       float precioCompra=0, precioComp=0;
    String nombre = "", nombretemp="";
    Object vector1[];
    
        String cadenasql="select p.nombre, p.existencia, p.preciocompra from productos p order BY p.existencia DESC";
        
        ResultSet datos_cliente;

        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    nombre = datos_cliente.getString("p.nombre");
                    existencia = datos_cliente.getInt("p.existencia");
                    precioComp =  datos_cliente.getFloat("p.preciocompra");
                    
                    
                    if (existencia > unidades) {
                        unidades = existencia;
                        nombretemp= nombre;
                        precioCompra = precioComp;
                    }
                }
                pzaMaStock.setText(nombretemp);
                cantStock.setText(String.valueOf(unidades));
                precioComp= precioCompra*unidades;
                preMaStock.setText(String.valueOf(precioComp));
                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }        
   }
    public void totalInvertido() {
        String lap = (String) lapso.getSelectedItem();
        String me= (String) mes.getSelectedItem();
        String cadenasql="select SUM(p.existencia * p.preciocompra)total from productos p order BY p.existencia DESC;";
        
        
        float total = 0;
        ResultSet datos_cliente;

        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaInventario.getModel();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    total = datos_cliente.getFloat("total");
                }
                tInver.setText(String.valueOf(total));
                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void InvertidoPiezaMayorsTOCK(){
         String cadenasql = "SELECT idproducto,nombre,fecharegistro, precioventa,preciocompra, existencia from productos order by  existencia DESC";
        float precioCompra = 0;
        ResultSet datos_cliente;

        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaInventario.getModel();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    precioCompra += datos_cliente.getFloat("preciocompra");
                }
                tInver.setText(String.valueOf(precioCompra));
                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void TablaDeudores(){
        String cadenasql="SELECT v.idventa, c.nombre, c.deudatotal FROM ventas v, clientes c, ventas_credito vc WHERE v.idventa = vc.ventas_idventa and vc.clientes_idcliente = c.idcliente";
        int id,i=0;
        
        String cnombre;
        float deuda, deudaTotal=0,deudaTotalUsuario=0;
        ResultSet datos_cliente;

        DefaultTableModel modelo_tabla = (DefaultTableModel) this.tablaDeudores.getModel();
        int ids[]= new int[modelo_tabla.getRowCount()];
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                Statement exe = con.createStatement();
                datos_cliente = exe.executeQuery(cadenasql);
                while (datos_cliente.next()) {
                    i++;
                    id = datos_cliente.getInt("v.idventa");
                    cnombre= datos_cliente.getString("c.nombre");
                    deuda = datos_cliente.getFloat("c.deudatotal");
                    deudaTotal+=deuda;
                    /*
                    ids[i]= id;
                    for (int j = 0; j < ids.length; j++) {
                        if (ids[j]==id) {
                            deudaTotalUsuario+= deuda;
                        }
                    }
*/
                    Object vector[] = {id,cnombre, deuda, deudaTotalUsuario};
                    modelo_tabla.addRow(vector);
                }
                deudaActual.setText(String.valueOf(deudaTotal));

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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tipProd = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cantProd = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalV = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        pzaMaStock = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cantStock = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        preMaStock = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tInver = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDeudores = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        deudaActual = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lapso = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        mes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido a reportes");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setOpaque(true);

        jToolBar1.setRollover(true);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Productos", "categoria", "fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaVentas.getTableHeader().setResizingAllowed(false);
        tablaVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaVentas);
        if (tablaVentas.getColumnModel().getColumnCount() > 0) {
            tablaVentas.getColumnModel().getColumn(0).setResizable(false);
            tablaVentas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaVentas.getColumnModel().getColumn(1).setResizable(false);
            tablaVentas.getColumnModel().getColumn(1).setPreferredWidth(450);
            tablaVentas.getColumnModel().getColumn(2).setResizable(false);
            tablaVentas.getColumnModel().getColumn(2).setPreferredWidth(250);
            tablaVentas.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tipo de producto mas vendido:");

        tipProd.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Cantidad de productos vendidos:");

        cantProd.setText("0");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total vendido en el periodo:");

        totalV.setText("0.0");

        jDesktopPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(tipProd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(cantProd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(totalV, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipProd, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cantProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(287, 287, 287)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalV)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(totalV))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tipProd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cantProd))
                        .addGap(18, 18, 18))))
        );

        jToolBar1.add(jDesktopPane2);

        jTabbedPane1.addTab("Ventas", jToolBar1);

        jToolBar2.setRollover(true);

        jDesktopPane3.setEnabled(false);
        jDesktopPane3.setRequestFocusEnabled(false);

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Fecha de registro", "Precio de venta", "Precio de compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInventario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaInventario.setEnabled(false);
        tablaInventario.getTableHeader().setResizingAllowed(false);
        tablaInventario.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaInventario);
        if (tablaInventario.getColumnModel().getColumnCount() > 0) {
            tablaInventario.getColumnModel().getColumn(0).setResizable(false);
            tablaInventario.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaInventario.getColumnModel().getColumn(1).setResizable(false);
            tablaInventario.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablaInventario.getColumnModel().getColumn(2).setResizable(false);
            tablaInventario.getColumnModel().getColumn(3).setResizable(false);
            tablaInventario.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Pieza con mayor stock:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Cantidad de stock:");

        cantStock.setText("0");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Invertido en pieza con mayor stock:");

        preMaStock.setText("0.0");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Total Invertido:");

        tInver.setText("0.0");

        jDesktopPane3.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(pzaMaStock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cantStock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(preMaStock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(tInver, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(cantStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(pzaMaStock, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(preMaStock)
                        .addGap(206, 206, 206)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(tInver, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
            .addComponent(jScrollPane2)
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(pzaMaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(preMaStock)
                        .addComponent(jLabel15)
                        .addComponent(tInver)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cantStock, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jToolBar2.add(jDesktopPane3);

        jTabbedPane1.addTab("Inventario", jToolBar2);

        jToolBar3.setRollover(true);

        tablaDeudores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id venta", "Nombre", "Deuda total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDeudores.getTableHeader().setResizingAllowed(false);
        tablaDeudores.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaDeudores);
        if (tablaDeudores.getColumnModel().getColumnCount() > 0) {
            tablaDeudores.getColumnModel().getColumn(0).setResizable(false);
            tablaDeudores.getColumnModel().getColumn(1).setResizable(false);
            tablaDeudores.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Nombre del maximo deudor:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Deuda actual:");

        deudaActual.setText("0.0");

        jDesktopPane4.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(deudaActual, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(deudaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(deudaActual))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jToolBar3.add(jDesktopPane4);

        jTabbedPane1.addTab("Deudores", jToolBar3);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/excel.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Por lapso");

        lapso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "1 mes", "2 meses", "3 meses", "4 meses", "5 meses", "6 meses", "7 meses", "8 meses", "9 meses", "10 meses", "11 meses", "1 año", "2 años", "3 años", "5 años" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Por mes:");

        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lapso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(mes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lapso, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lapso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cantProd;
    private javax.swing.JLabel cantStock;
    private javax.swing.JLabel deudaActual;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JComboBox<String> lapso;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JLabel preMaStock;
    private javax.swing.JLabel pzaMaStock;
    private javax.swing.JLabel tInver;
    private javax.swing.JTable tablaDeudores;
    private javax.swing.JTable tablaInventario;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JLabel tipProd;
    private javax.swing.JLabel totalV;
    // End of variables declaration//GEN-END:variables
}
