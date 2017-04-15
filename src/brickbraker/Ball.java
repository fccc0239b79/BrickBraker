/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbraker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Pawel Szymczyk
 */
public class Ball extends Common implements Init {
    
    private double xDir, yDir;
    
    public Ball(double width, double height, double posX, double posY) {
        
        xDir = 1;
        yDir = -1;
        
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        
        resetState();
    }
       
    public double getYDir() {
        return yDir;
    }
    
    public double getXDir() {
        return xDir;
    }
    
    public void setYDir(double yDir) {
        this.yDir = yDir;
    }
    
    public void setXDir(double xDir) {
        this.xDir = xDir;
    }
    
    private void resetState(){
        posX = BALL_INIT_POS_X;
        posY = BALL_INIT_POS_Y;
    }
     
    public void move() {
        
      if(posX < 0 || posX > (SCREEN_WIDTH - width - 5)) {
          xDir = -xDir;
      } else if (posY < 0 || posY > (SCREEN_HEIGHT - height - 20)) {
          yDir = -yDir;
      }
      
      posX += xDir;
      posY += yDir;
    }
    
     public void paintComponent(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        
        Ellipse2D ball = new Ellipse2D.Double(posX, posY, width, height);
        g2d.fill(ball);
        
    }
     
    
}
