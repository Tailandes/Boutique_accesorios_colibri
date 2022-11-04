/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.multi.MultiLookAndFeel;

/**
 *
 * @author Alexg
 */
public class Main {
    public static void main(String[] args) {
        try {
            User_sesion_Boutique_accesorios_colibri user_sesion = new User_sesion_Boutique_accesorios_colibri();
            // user_sesion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            UIManager.setLookAndFeel(new McWinLookAndFeel());
            user_sesion.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
