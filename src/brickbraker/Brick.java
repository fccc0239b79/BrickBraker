/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbraker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 *
 * @author Pawel Szymczyk
 */
public class Brick extends Common implements Init{
    
    private boolean hit;
    
    public Brick(double posX, double posY, double width, double height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        
        hit = false;
    }
    
    public boolean isHit() {
        return hit;
    }
    
    public void setHit(boolean hit) {
        this.hit = hit;
    }
    
    public void paintComponent(Graphics g){ 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
            Rectangle2D b = new Rectangle2D.Double(posX, posY, width, height);
            g2d.fill(b);
    }
    
}
