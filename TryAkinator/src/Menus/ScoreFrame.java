package Menus;

import Structures.DualNode;
import Structures.InfoNode;
import Util.ReWi;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class ScoreFrame extends javax.swing.JFrame{

    public int s;
    private ReWi rw;
    private InfoNode player, ptr;
    private DualNode root;
    private javax.swing.JTable score;
    private javax.swing.table.DefaultTableModel dtm; 
    private javax.swing.JButton back, plmn, exit;
    
    public ScoreFrame(int n, InfoNode ptr) {
        
        setSize(490, 405);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Tabla de Puntajes");
        getContentPane().setBackground(Color.black);
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon);
        this.ptr = ptr;
        rw = new ReWi(1);
        switch  (n){
            case 1:
                initFromMainMenu(ptr.lenght());
                break;
            case 2:
                initFromEndOfTheGame(ptr.lenght());
                break;
            
        }
        score.setModel(rw.fill(score));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        score.setDefaultRenderer(String.class, centerRenderer);
        for(int x = 0; x < score.getColumnCount(); x++){
            score.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        /*score.setModel(new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        });*/
        setVisible(true);
    }
    
    public void initFromMainMenu(int rows){
        dtm = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
        };
        
        score = new javax.swing.JTable(0, 2);
        score.setSize(440, 355);
        score.setDragEnabled(false);
        score.setForeground(Color.white);
        score.setBackground(Color.black);
        score.setGridColor(Color.white);
        score.setLocation(25, 25);
//        score.setModel(dtm);
        add(score);   
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    public void initFromEndOfTheGame(int rows){
        /*dtm = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };*/
        score = new javax.swing.JTable(0, 2);
        score.setSize(440, 300);
        score.setDragEnabled(false);
       
        score.setForeground(Color.white);
        score.setBackground(Color.black);
        score.setGridColor(Color.white);
        score.setLocation(25, 25);
        add(score);
        
        back = new javax.swing.JButton();
        back.setText("Menu Principal");
        back.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                BackActionPerformed(evt);
            }
        });
        back.setSize(140, 30);
        back.setLocation(25, 335);
        back.setVisible(true);
        this.add(back);
        
        plmn = new javax.swing.JButton();
        plmn.setText("Menu del Jugador");
        plmn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                PlayerActionPerformed(evt);
            }
        });
        plmn.setSize(140, 30);
        plmn.setLocation(175, 335);
        plmn.setVisible(true);
        this.add(plmn);
        
        exit = new javax.swing.JButton();
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ExitActionPerformed(evt);
            }
        });
        exit.setSize(140, 30);
        exit.setLocation(325, 335);
        exit.setVisible(true);
        this.add(exit);
    }
    
    public void BackActionPerformed(java.awt.event.ActionEvent evt){
        MainMenu mn = new MainMenu();
        dispose();
        
    }
    
    public void PlayerActionPerformed(java.awt.event.ActionEvent evt){
        PlayerMenu pm = new PlayerMenu();
        pm.setPlayer(player);
        pm.setRoot(root);
        pm.setPtr(ptr);
        dispose();        
    }
    
    public void ExitActionPerformed(java.awt.event.ActionEvent evt){
        dispose();
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

    public DualNode getRoot() {
        return root;
    }

    public void setRoot(DualNode root) {
        this.root = root;
    }
}
