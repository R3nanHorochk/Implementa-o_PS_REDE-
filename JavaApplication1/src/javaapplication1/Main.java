/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                sessao sessaoInstancia = new sessao();
                try {
                     Login enter = new Login(sessaoInstancia);
                     enter.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
         
    }
    
}
