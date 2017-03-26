/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author cddr
 */
public class HelpFrame extends javax.swing.JFrame{

    private javax.swing.JLabel aiuda;
    private javax.swing.JButton next, back;
    public HelpFrame() {
        setSize(415, 405);
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
        next = new javax.swing.JButton();
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                NextActionPerformed(evt);
            }
        });
        next.setSize(70, 30);
        next.setLocation(330, 340);
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
        back.setLocation(10, 340);
        back.setVisible(true);
        this.add(back);
        
        /*aiuda = new javax.swing.JLabel();
        aiuda.setSize(200, 300);
        aiuda.setFont(new Font("Arial", Font.BOLD, 16));
        aiuda.setForeground(Color.white);
        aiuda.setBackground(Color.black);
        aiuda.setLocation(100, 25);
        aiuda.setText("User Manual: click \"next\"");
        this.add(aiuda);
        */
    }
    
    public void BackActionPerformed(java.awt.event.ActionEvent e){
        
    }
    public void NextActionPerformed(java.awt.event.ActionEvent e){
        
    }
}
