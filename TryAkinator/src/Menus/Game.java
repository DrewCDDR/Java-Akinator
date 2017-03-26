/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import Structures.DualNode;
import Structures.InfoNode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author cddr
 */
public class Game extends javax.swing.JFrame{

    private int score, nigma, count;
    private InfoNode player, ptr;
    private DualNode actual, root;
    private javax.swing.Timer timer;
    private javax.swing.JLabel time, nQuestion;
    private javax.swing.JTextArea question;
    private javax.swing.JButton yes, no, maybeYes, maybeNo, dunno;
    
    public Game(DualNode root) {

        this.root = root;
        this.actual = root;
        this.nigma = 1;
        
        setSize(315, 355);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setTitle("Try Akinator!");
        getContentPane().setBackground(Color.black);
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon);
        init();
        this.count = 0;
        timer = new Timer(1000, new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                count++;
                System.out.println("Seconds: " +count);
////                Date date = new Date(count *1000);
//                DateFormat df = new SimpleDateFormat("HH:mm:ss");
//                String t = df.format(date);
//                time.setText("Tiempo: " +timeToFormat(Integer.toString((count *1000))));
                time.setText("Tiempo: " +secondsToTime(count));
            }
        });
        timer.start();
        setVisible(true);
    }
    
    public void init(){
        yes = new javax.swing.JButton();
        yes.setText("Si");
        yes.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                YesActionPerformed(evt);
            }
        });
        yes.setSize(140, 30);
        yes.setLocation(85, 120);
        yes.setVisible(true);
        add(yes);
        
        no = new javax.swing.JButton();
        no.setText("No");
        no.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                NoActionPerformed(evt);
            }
        });
        no.setSize(140, 30);
        no.setLocation(85, 170);
        no.setVisible(true);
        add(no);
        
        maybeYes = new javax.swing.JButton();
        maybeYes.setText("Probablemente si");
        maybeYes.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                MaybeYesActionPerformed(evt);
            }
        });
        maybeYes.setSize(140, 30);
        maybeYes.setLocation(85, 220);
        maybeYes.setVisible(true);
        add(maybeYes);
        
        maybeNo = new javax.swing.JButton();
        maybeNo.setText("Probablemente no");
        maybeNo.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                MaybeNoActionPerformed(evt);
            }
        });
        maybeNo.setSize(140, 30);
        maybeNo.setLocation(85, 270);
        maybeNo.setVisible(true);
        add(maybeNo);
        
        time = new javax.swing.JLabel();
        nQuestion = new javax.swing.JLabel();
        question = new javax.swing.JTextArea();
        time.setSize(100, 20);
        nQuestion.setSize(120, 20);
        question.setSize(240, 40);
        time.setLocation(195, 20);
        nQuestion.setLocation(20, 20);
        question.setLocation(40, 60);
        time.setForeground(Color.white);
        nQuestion.setForeground(Color.white);
        question.setForeground(Color.white);
        time.setBackground(Color.black);
        nQuestion.setBackground(Color.black);
        question.setBackground(Color.black);
        time.setBackground(Color.black);
        time.setText("Tiempo: 00:00:00");
        nQuestion.setText("Pregunta #" +nigma +":");
        question.setFont(new Font("Arial",Font.BOLD, 12));
        question.setText(actual.text);
        question.setEditable(false);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        add(time);
        add(nQuestion);
        add(question);
    }
    
    public void updateInfo(){
        nQuestion.setText("Pregunta #" +nigma +":" );
        question.setText(actual.text);
    }
    
    public void YesActionPerformed(java.awt.event.ActionEvent e){
        
        if (actual.yes != null) {
            actual = actual.yes;
            nigma++;
        }
        updateInfo();
    }
    
    public void NoActionPerformed(java.awt.event.ActionEvent e){
        if (actual.no != null) {
            actual = actual.no;
            nigma++;
        }
        updateInfo();
    }
    
    public void MaybeYesActionPerformed(java.awt.event.ActionEvent e){
        if (actual.maybe != null) {
            actual = actual.maybe;
            nigma++;
        }
        updateInfo();
    }
    
    public void MaybeNoActionPerformed(java.awt.event.ActionEvent e){
        if (actual.maybeNot != null) {
            actual = actual.maybeNot;
            nigma++;
        }
        updateInfo();
    }

    public String secondsToTime(int t){
        String date = "";
        int s = t;
        int h = s/3600;
        s = s%3600;
        int m = s/60;
        s = s%60;
        if (h <10) {
            date = date +"0" +h +":";
        }else{
            date = date +Integer.toString(h) +":";
        }
        if (m <10) {
            date = date +"0" +m +":";
        }else{
            date = date +Integer.toString(m) +":";
        }
        if (s <10) {
            date = date +"0" +s;
        }else{
            date = date +s;
        }
        return date;
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

    public DualNode getActual() {
        return actual;
    }

    public void setActual(DualNode actual) {
        this.actual = actual;
    }

    public DualNode getRoot() {
        return root;
    }

    public void setRoot(DualNode root) {
        this.root = root;
    }
    
    
}
