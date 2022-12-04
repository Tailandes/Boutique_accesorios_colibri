/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.sun.jdi.connect.spi.Connection;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PRIV4
 */


public class Conexion {

    String Cadena = "jdbc:mysql://127.0.0.1/boutique_accesorios_colibri";
    String Driver = "com.mysql.jdbc.Driver";
    String Usuario = "root";
    String Contraseña = "";
    
    public void Conexion() throws SQLException
    {
        try {
            Class.forName(Driver);//Utilizar un driver de tercero (el driver)
            java.sql.Connection con = DriverManager.getConnection(Cadena, Usuario, Contraseña);
            if(con!= null)
            {
                System.out.println("conecto");
                con.close();
            }
            else
            {
                System.out.println("Error");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
