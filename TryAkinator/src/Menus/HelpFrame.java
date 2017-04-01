/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author cddr
 */
public class HelpFrame extends javax.swing.JFrame{

    public int s, i;
//    private 
    ImageIcon icon;
    private javax.swing.JLabel output;
    private javax.swing.JButton next, back;
    
    public HelpFrame() {
        setSize(475, 425);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("User Manual");
        getContentPane().setBackground(Color.black);
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon);
        init();
        setVisible(true);
    }
    
    public void init(){
        i = 1;
        next = new javax.swing.JButton();
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                NextActionPerformed(evt);
            }
        });
        next.setSize(70, 30);
        next.setLocation(390, 360);
        next.setVisible(true);
        this.add(next);
        
        back = new javax.swing.JButton();
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                BackActionPerformed(evt);
            }
        });
        back.setSize(70, 30);
        back.setLocation(10, 360);
        back.setVisible(true);
        this.add(back);
        
        output = new javax.swing.JLabel();
        output.setLocation(10,10);
        output.setSize(450, 350);
        icon = new ImageIcon("Images/Guia 0" +i +".png");
        
        output.setIcon(icon);
        this.add(output);
        
    }
    
    public void BackActionPerformed(java.awt.event.ActionEvent e){
        if (i > 1) {
            i--;
        }
        icon = new ImageIcon("Images/Guia 0" +i +".png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(450, 340,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        output.setIcon(icon);
    }
    public void NextActionPerformed(java.awt.event.ActionEvent e){
        if (i < 8) {
            i++;
        }
        icon = new ImageIcon("Images/Guia 0" +i +".png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(450, 340,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        output.setIcon(icon);
    }
}
