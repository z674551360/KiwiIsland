package nz.ac.aut.ense701.main;

import javax.swing.JFrame;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gui.KiwiCountUI;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.*;  
import javax.swing.*; 
import nz.ac.aut.ense701.gui.Demo;

/**
 * Kiwi Count Project
 * 
 * @author AS
 * @version 2011
 */
public class Main 
{
    /**
     * Main method of Kiwi Count.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // create the game object
        final Game game = new Game();
        // create the GUI for the game
        final KiwiCountUI  gui  = new KiwiCountUI(game);
        // make the GUI visible
        
        //invoke timer
        Demo mydemo = new Demo();  
        mydemo.setTitle("Timer");  
        mydemo.setSize(200, 200);  
        mydemo.setLocationRelativeTo(null);  
        mydemo.setVisible(true);  
        mydemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //time end
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                gui.setVisible(true);
            }
        });
    }

}
