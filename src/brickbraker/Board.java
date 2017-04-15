/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbraker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Pawel Szymczyk
 */
public class Board extends JPanel implements Init, ActionListener,  KeyListener {
    
    private Ball ball;
    private Paddle paddle;
    private Brick bricks[];
    private Timer timer;
    private boolean isGameOver = false;
    
    
    public Board() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
      
        timer = new Timer(5, this);
        
        initGame();
    }  
    int index; 
    public void initGame() {
        ball = new Ball(BALL_WIDTH, BALL_HEIGHT, BALL_INIT_POS_X, BALL_INIT_POS_Y);
        paddle = new Paddle(PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_INIT_POS_X, PADDLE_INIT_POS_Y);
        bricks = new Brick[BRICKS_NUMBER];
        // block of bricks distance pos X and Y
        index = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 9; j++) {
                bricks[index] = new Brick(j * 60 + 30, i * 30 + 50, BRICK_WIDTH, BRICK_HEIGHT);
                index++;
            }
        }
        
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.WHITE);
        
        ball.paintComponent(g);
        paddle.paintComponent(g);
        
        if(!isGameOver) {
            for(int i = 0; i < BRICKS_NUMBER; i++) {
                if(!bricks[i].isHit()) {
                    bricks[i].paintComponent(g);
                }
            }
        }
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        ball.move();
        paddle.move();
        checkCollision();
    }
    
    /**
     * checkCollision - checks collision between:
     * ball and paddle - if there was a collision, direction of ball is changing on opposite.
     * ball and brick - if there was a collision, direction of ball is changing on opposite and removes ball from a list
     * ball and line below paddle - if there was a collision, it stops a game, and prints out message "GAME OVER"
     */
    public void checkCollision() {
        if(ball.getBounds().getMaxY() >= GAMEOVER_LINE )  {
            System.out.println("GAME OVER");
            gameOver();
        } else if(ball.getBounds().intersects(paddle.getBounds())) {
            ball.setYDir(-1);
        }
        
        for (int i = 0, j = 0; i < BRICKS_NUMBER; i++) {
            if(bricks[i].isHit()) {
                j++;
                System.out.println(j);
            } else if (j == Init.BRICKS_NUMBER) {
                System.out.println("VICTORY !");
            }
        }
        
        for (int i = 0; i < BRICKS_NUMBER; i++) {
            
            if(ball.getBounds().intersects(bricks[i].getBounds())) {
               
                int ballLeft = (int) ball.getBounds().getMinX();
                int ballHeight = (int) ball.getBounds().getHeight();
                int ballWidth = (int) ball.getBounds().getWidth();
                int ballTop = (int) ball.getBounds().getMinY();
                
                Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                Point pointTop = new Point(ballLeft, ballTop - 1);
                Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
                
                if(!bricks[i].isHit()) {
                    
                    if(bricks[i].getBounds().contains(pointRight)) {
                        ball.setXDir(-1);
                    } else if (bricks[i].getBounds().contains(pointLeft)) {
                        ball.setXDir(1);
                    }
                    
                    if(bricks[i].getBounds().contains(pointTop)) {
                        ball.setYDir(1);
                    } else if (bricks[i].getBounds().contains(pointBottom)) {
                        ball.setYDir(-1);
                    }
                    
                    bricks[i].setHit(true);
                }
            }
        }
    }
    
    public void gameOver() {
        isGameOver = true;
        timer.stop();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
      
        if(code == KeyEvent.VK_RIGHT) {
            paddle.right();
        } else if(code == KeyEvent.VK_LEFT) {
            paddle.left();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {
        paddle.setXDir(0);
    }
    
    
}
