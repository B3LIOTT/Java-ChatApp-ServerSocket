package com.mycompany.chatapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Boutton extends JButton {
    
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorOnClick;
    int radius = 0;
    
    public boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColorOver() {
        return colorOver;
    }
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }
    public Color getColorClick() {
        return colorOnClick;
    }
    public void setColorClick(Color colorOnClick) {
        this.colorOnClick = colorOnClick;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public Boutton() {

        setColor(Color.WHITE);
        colorOver = new Color(200,200,200);
        colorOnClick = new Color(155, 174, 188);
        setContentAreaFilled(false);

        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
                over = true;
                
            }
            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                over = false;
                
            }
            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorOnClick);
                
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                if(over) setBackground(colorOver);
                else setBackground(color);
            } 
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(2, 2,getWidth()-2, getHeight()-2, radius, radius);
        
        super.paintComponent(g);
    }
}
