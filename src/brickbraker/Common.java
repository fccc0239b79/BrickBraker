/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbraker;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Pawel Szymczyk
 */
public class Common {
    
    protected double width, height;
    protected double posX, posY;
    
    
    //SETTORS
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public void setPosX(double posX) {
        this.posX = posX;
    }
    
    public void setPosY(double posY) {
        this.posY = posY;
    }
    
    // GETTORS
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getPosX() {
        return posX;
    }
    
    public double getPosY() {
        return posY;
    }
    
   public Rectangle2D getBounds() {
       return new Rectangle2D.Double(getPosX(), getPosY(), getWidth(), getHeight());
    }
}
