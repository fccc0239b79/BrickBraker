
package brickbraker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Pawel Szymczyk
 */
public class Paddle extends Common implements Init {
    
    private double xDir;
    
    public Paddle(double width, double height, double posX, double posY) {
        
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        
        resetState();
    }
    
    public double getXDir() {
        return xDir;
    }
     
    public void setXDir(double xDir) {
        this.xDir = xDir;
    }
    
    public void paintComponent(Graphics g){
     
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        Rectangle2D paddle = new Rectangle2D.Double(posX, posY, width, height);
        g2d.fill(paddle);        
    }
     
    public void move() {
        
        if(posX <= 0) {
            posX = 0;
        } else if(posX >= SCREEN_WIDTH - width) {
            posX = SCREEN_WIDTH - width;
        }
        
        posX += xDir;
    }
    
    public void left() {
        xDir = -1;
    }
    
    public void right() {
        xDir = 1; 
    }
     
    private void resetState(){
        posX = PADDLE_INIT_POS_X;
        posY = PADDLE_INIT_POS_Y;
    }
    
}
