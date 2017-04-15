/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbraker;

/**
 *
 * @author Pawel Szymczyk
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Pawel Szymczyk
 */
public class BrickBraker extends JFrame {
    public BrickBraker() {
        
        // Frame parameters
        setTitle("Brick Braker");
        setSize(Init.SCREEN_WIDTH, Init.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        setResizable(false);
        setVisible(true);
        
        
        // Window Listeners
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // Add Panels
        Container panelContainer = getContentPane();
        panelContainer.add(new Board());
        
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
		JFrame frame = new BrickBraker();
                frame.show();
            }
        });     
    }
}
