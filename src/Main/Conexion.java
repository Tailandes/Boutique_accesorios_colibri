/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexg
 */
public class Conexion {

    public Conexion() {
        Properties datos = new Properties();
        String servidor;
        String driver;
        datos.put("user", "u7tuhhfbmthsu53c");
        datos.put("password", "Nw5nMTEHvX2U2r3gVAYj");
        servidor = "jdbc:mysql://bosgnclh26bmxuw456hf-mysql.services.clever-cloud.com:3306/bosgnclh26bmxuw456hf";
//        String pd_nombre,pd_descripcion;
//        double pd_compra,pd_venta;
//        String pd_fecha;
//        String cadenasql;
        driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor, datos);
            if (con != null) {
                System.out.println("Conecto");
                con.close();
            } else {
                System.out.println("No conecto");
            }
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
