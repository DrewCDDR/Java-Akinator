package Menus;

import Structures.DualNode;
import Structures.InfoNode;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class PlayerMenu extends javax.swing.JFrame {

    private InfoNode ptr;
    private InfoNode player;
    private DualNode root;
    private javax.swing.JLabel username;
    private javax.swing.JLabel highscore;
    private javax.swing.JLabel timesPlayed;
    private javax.swing.JLabel nQuestions;
    private javax.swing.JLabel average;
    private javax.swing.JLabel timePlayed;
    private javax.swing.JLabel amountOfTime;
    private javax.swing.JButton play;
    private javax.swing.JButton exit;
    private javax.swing.JButton logOut;
    private javax.swing.JButton playerInfo;
    private javax.swing.JButton hide;
    
    public PlayerMenu() throws HeadlessException {
        setSize(235, 255);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu del jugador");
        getContentPane().setBackground(Color.black);
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon);
        init();
        setVisible(true);
    }
    
    public void init(){
        play = new javax.swing.JButton();
        play.setText("Jugar");
        play.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                PlayActionPerformed(evt);
            }
        });
        play.setSize(120, 30);
        play.setLocation(50, 20);
        play.setVisible(true);
        add(play);
        
        playerInfo = new javax.swing.JButton();
        playerInfo.setText("Informacion");
        playerInfo.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                PlayerInfoActionPerformed(evt);
            }
        });
        playerInfo.setSize(120, 30);
        playerInfo.setLocation(50, 70);
        playerInfo.setVisible(true);
        add(playerInfo);
        
        logOut = new javax.swing.JButton();
        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                LogOutActionPerformed(evt);
            }
        });
        logOut.setSize(120, 30);
        logOut.setLocation(50, 120);
        logOut.setVisible(true);
        add(logOut);
        
        exit = new javax.swing.JButton();
        exit.setText("Menu de inicio");
        exit.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ExitActionPerformed(evt);
            }
        });
        exit.setSize(120, 30);
        exit.setLocation(50, 170);
        exit.setVisible(true);
        add(exit);
    }
    
    public void reInit(){
        username = new javax.swing.JLabel();
        username.setSize(150, 20);
        username.setLocation(250, 20);
        username.setForeground(Color.white);
        username.setText("Jugador: " +player.username);
        username.setVisible(true);
        add(username);
        
        timesPlayed = new javax.swing.JLabel();
        timesPlayed.setSize(150, 20);
        timesPlayed.setLocation(250, 40);
        timesPlayed.setForeground(Color.white);
        timesPlayed.setText("Numero de partidas: " +player.timesPlayed);
        timesPlayed.setVisible(true);
        add(timesPlayed);
        
        highscore = new javax.swing.JLabel();
        highscore.setSize(150, 20);
        highscore.setLocation(250, 60);
        highscore.setForeground(Color.white);
        highscore.setText("Mejor puntaje: " +player.highScore);
        highscore.setVisible(true);
        add(highscore);
        
        average = new javax.swing.JLabel();
        average.setSize(150, 20);
        average.setLocation(250, 80);
        average.setForeground(Color.white);
        average.setText("Promedio: " +player.averageScore);
        average.setVisible(true);
        add(average);
        
        nQuestions = new javax.swing.JLabel();
        nQuestions.setSize(150, 20);
        nQuestions.setLocation(250, 100);
        nQuestions.setForeground(Color.white);
        nQuestions.setText("Numero de preguntas: " +player.numberOfQuestions);
        nQuestions.setVisible(true);
        add(nQuestions);
        
        timePlayed = new javax.swing.JLabel();
        timePlayed.setSize(150, 20);
        timePlayed.setLocation(250, 120);
        timePlayed.setForeground(Color.white);
        timePlayed.setText("Tiempo jugado: ");
        timePlayed.setVisible(true);
        add(timePlayed);
        
        amountOfTime = new javax.swing.JLabel();
        amountOfTime.setSize(150, 20);
        amountOfTime.setLocation(250, 140);
        amountOfTime.setForeground(Color.white);
        amountOfTime.setText("             => " +player.secondsToTime(Integer.parseInt(player.time)));
        amountOfTime.setVisible(true);
        add(amountOfTime);
        
        hide = new javax.swing.JButton();
        hide.setText("Esconder");
        hide.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                HideActionPerformed(evt);
            }
        });
        hide.setSize(120, 30);
        hide.setLocation(250, 170);
        hide.setVisible(true);
        this.add(hide);
    }
    
    public void UpdateGUI(){
        remove(username);
        remove(timesPlayed);
        remove(highscore);
        remove(nQuestions);
        remove(average);
        remove(timePlayed);
        remove(amountOfTime);
        remove(hide);
    }
    
    public void PlayActionPerformed(java.awt.event.ActionEvent evt){
        Game g = new Game(this.root);
//        player.timesPlayed = Integer.toString(Integer.parseInt(player.timesPlayed) +1);
        g.setPlayer(player);
        g.setPtr(ptr);
        this.dispose();
    }
    
    public void PlayerInfoActionPerformed(java.awt.event.ActionEvent evt){
        setSize(445, 255);
        setLocationRelativeTo(null);
        reInit();
    }
    
    public void LogOutActionPerformed(java.awt.event.ActionEvent evt){
        LoginFrame lf = new LoginFrame();
        lf.setPtr(ptr);
        this.dispose();
    }
    
    public void ExitActionPerformed(java.awt.event.ActionEvent evt){
        MainMenu mn = new MainMenu();
        mn.setP_PTR(ptr);
        this.dispose();
    }
    
    public void HideActionPerformed(java.awt.event.ActionEvent evt){
        UpdateGUI();
        setSize(215, 255);
        setLocationRelativeTo(null);
        init();
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
