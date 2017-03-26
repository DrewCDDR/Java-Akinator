package Menus;

import Structures.InfoNode;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ScoreFrame extends javax.swing.JFrame{

    private InfoNode player, ptr;
    private javax.swing.JTable score;
    private javax.swing.table.DefaultTableModel dtm; 
    private javax.swing.JButton back;
    
    public ScoreFrame(int n, InfoNode ptr) {
        
        setSize(415, 405);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Score Table");
        getContentPane().setBackground(Color.black);
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon);
        this.ptr = ptr;
        switch  (n){
            case 1:
                initFromMainMenu(ptr.lenght());
                break;
            case 2:
                initFromEndOfTheGame(ptr.lenght());
                break;
            
        }
        setVisible(true);
    }
    
    public void initFromMainMenu(int rows){
        dtm = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        score = new javax.swing.JTable(rows, 2);
        score.setSize(360, 330);
        score.setDragEnabled(false);
//        score.setForeground(Color.white);
//        score.setBackground(Color.black);
//        score.setGridColor(Color.white);
        score.setLocation(25, 25);
//        score.setModel(dtm);
        score.setVisible(true);
        add(score);
    }
    
    
    public void initFromEndOfTheGame(int rows){
        dtm = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        score = new javax.swing.JTable(rows, 2);
        score.setSize(360, 295);
        score.setDragEnabled(false);
//        score.setForeground(Color.white);
//        score.setBackground(Color.black);
//        score.setGridColor(Color.white);
        score.setLocation(25, 25);
//        score.setModel(dtm);
        score.setVisible(true);
        add(score);
        
        back = new javax.swing.JButton();
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                BackActionPerformed(evt);
            }
        });
        back.setSize(70, 30);
        back.setLocation(175, 335);
        back.setVisible(true);
        this.add(back);
    }
    
    public void BackActionPerformed(java.awt.event.ActionEvent e){
        
    }
    
    public void fillTable(InfoNode ptr){
        
    }

    ////////////////////////////////////////////////////////////////////////////
    
    public InfoNode getPlayer() {
        return player;
    }

    public void setPlayer(InfoNode player) {
        this.player = player;
    }

    public InfoNode getPtr() {
        return ptr;
    }

    public void setPtr(InfoNode ptr) {
        this.ptr = ptr;
    }
}
