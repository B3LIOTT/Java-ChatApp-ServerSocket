package com.mycompany.chatapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextPane;

//classe qui permet de creer les zones de chat (-> bulles)
public class Chat extends JTextPane {
    
    private Color border = Color.BLACK;
    private Color bg = Color.BLUE;
    
    public Color getBorderColor() {
        return border;
    }
    public void setBorderColor(Color border) {
        this.border = border;
    }
    public Color getBgColor() {
        return bg;
    }
    public void setBgColor(Color bg) {
        this.bg = bg;
    }
    
    
    public Chat() {
        setBackground(new Color(0,0,0,0));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(bg);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        g2d.setColor(border);
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
        super.paintComponent(g);
    }
    
}
