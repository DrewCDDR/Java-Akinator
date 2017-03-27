/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import Structures.DualNode;
import Structures.InfoNode;
import Structures.SimpleNode;
import Util.ReWi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

/**
 *
 * @author cddr
 */
public class Game extends javax.swing.JFrame{

    private boolean winner, looser;
    private int score, nigma, count;
    private ReWi ques,ans, playe;
    private InfoNode player, ptr;
    private DualNode actual, root, possible, a1, b1, c1, d1, e1;
    private javax.swing.Timer timer;
    private javax.swing.JLabel time, nQuestion, respuesta, pregunta;
    private javax.swing.JTextArea question, decide;
    private javax.swing.JButton yes, no, maybeYes, maybeNo, dunno, scores,
            playermn, exit, ok;
    private javax.swing.JTextField respuestaText, preguntaText;
    private javax.swing.JCheckBox a, b, c, d, e;
    
    public Game(DualNode root) {
        
        this.root = root;
        this.actual = root;
        this.nigma = 1;
        this.winner = false;
        this.looser = false;
        this.playe = new ReWi(1);
        this.ques = new ReWi(2);
        this.ans = new ReWi(3);
        
        setSize(315, 405);
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
        
        maybeYes = new javax.swing.JButton();
        maybeYes.setText("Probablemente si");
        maybeYes.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                MaybeYesActionPerformed(evt);
            }
        });
        maybeYes.setSize(140, 30);
        maybeYes.setLocation(85, 170);
        maybeYes.setVisible(true);
        add(maybeYes);
        
        dunno = new javax.swing.JButton();
        dunno.setText("No lo se");
        dunno.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                DunnoActionPerformed(evt);
            }
        });
        dunno.setSize(140, 30);
        dunno.setLocation(85, 220);
        dunno.setVisible(true);
        add(dunno);
        
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
        
        no = new javax.swing.JButton();
        no.setText("No");
        no.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                NoActionPerformed(evt);
            }
        });
        no.setSize(140, 30);
        no.setLocation(85, 320);
        no.setVisible(true);
        add(no);

        // LABELS
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
        
        // FINAL GUI
        
        scores = new javax.swing.JButton();
        scores.setText("Puntajes");
        scores.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ScoresActionPerformed(evt);
            }
        });
        scores.setSize(140, 30);
        scores.setLocation(85, 220);
        scores.setVisible(true);
        
        playermn = new javax.swing.JButton();
        playermn.setText("Menu jugador");
        playermn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                PlayerActionPerformed(evt);
            }
        });
        playermn.setSize(140, 30);
        playermn.setLocation(85, 270);
        playermn.setVisible(true);
        
        exit = new javax.swing.JButton();
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ExitActionPerformed(evt);
            }
        });
        exit.setSize(140, 30);
        exit.setLocation(85, 320);
        exit.setVisible(true);
        
        // Learning GUI
        respuesta = new javax.swing.JLabel();
        pregunta = new javax.swing.JLabel();
        decide = new javax.swing.JTextArea();
        respuesta.setSize(80, 20);
        pregunta.setSize(80, 20);
        decide.setSize(200, 40);
        respuesta.setLocation(360, 60);
        pregunta.setLocation(360, 100);
        decide.setLocation(360, 140);
        respuesta.setForeground(Color.white);
        respuesta.setBackground(Color.black);
        pregunta.setForeground(Color.white);
        pregunta.setBackground(Color.black);
        decide.setForeground(Color.white);
        decide.setBackground(Color.black);
        respuesta.setFont(new Font("Arial",Font.BOLD, 12));
        pregunta.setFont(new Font("Arial",Font.BOLD, 12));
        decide.setFont(new Font("Arial",Font.BOLD, 12));
        respuesta.setText("Respuesta:");
        pregunta.setText("Pregunta:");
        decide.setText("Que responderia para llegar a su respuesta?:");
        decide.setEditable(false);
        decide.setLineWrap(true);
        decide.setWrapStyleWord(true);
        
        preguntaText = new javax.swing.JTextField();
        respuestaText = new javax.swing.JTextField();
        preguntaText.setText("");
        respuestaText.setText("");
        preguntaText.setSize(120, 20);
        respuestaText.setSize(120, 20);
        respuestaText.setLocation(450, 60);
        preguntaText.setLocation(450, 100);
        
        a = new javax.swing.JCheckBox("Si");
        b = new javax.swing.JCheckBox("Probablemente si");
        c = new javax.swing.JCheckBox("No lo sé");
        d = new javax.swing.JCheckBox("Probablemente no");
        e = new javax.swing.JCheckBox("No");
        a.setForeground(Color.white);
        b.setForeground(Color.white);
        c.setForeground(Color.white);
        d.setForeground(Color.white);
        e.setForeground(Color.white);
        a.setBackground(Color.black);
        b.setBackground(Color.black);
        c.setBackground(Color.black);
        d.setBackground(Color.black);
        e.setBackground(Color.black);
        a.setSize(140, 20);
        b.setSize(140, 20);
        c.setSize(140, 20);
        d.setSize(140, 20);
        e.setSize(140, 20);
        a.setLocation(370, 180);
        b.setLocation(370, 200);
        c.setLocation(370, 220);
        d.setLocation(370, 240);
        e.setLocation(370, 260);
        
        ok = new javax.swing.JButton();
        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                OkActionPerformed(evt);
            }
        });
        ok.setSize(140, 30);
        ok.setLocation(395, 320);
        ok.setVisible(true);
    }
    
    public void updateGUI(){
        setSize(315, 405);
        setLocationRelativeTo(null);
        remove(maybeNo);
        remove(maybeYes);
        remove(dunno);
        no.setLocation(85, 170);
        add(scores);
        add(playermn);
        add(exit);
    }
    
    public void learnGUI(){
        setSize(625, 405); 
        setLocationRelativeTo(null);
        add(ok);
        add(respuesta);
        add(pregunta);
        add(decide);
        add(respuestaText);
        add(preguntaText);
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);

    }
    
    public void updateInfo(){
        nQuestion.setText("Pregunta #" +nigma +":" );
        question.setText(actual.text);
        if (nigma > 15) {
            timer.stop();
        }
        if (winner) {
            question.setText("Al menos adivine esa!\nSu puntaje es: 0");
        }
        if (looser) {
            score = nigma;
            question.setText("No pude adivinar, ahora tienes que enseñarme. Su puntaje es: " +score);
        }
    }
    
    public void savePlayerInfo(){
        if (winner) {
            score = 0;
        }else if(looser){
            score = nigma;
        } 
        float total;
        total = Integer.parseInt(player.timesPlayed) * Float.parseFloat(player.averageScore);
        total = total +score;
        player.timesPlayed = Integer.toString(Integer.parseInt(player.timesPlayed) +1);
        total = total/Integer.parseInt(player.timesPlayed);
        player.averageScore = Float.toString(total);
        if (score > Integer.parseInt(player.highScore)) {
            player.highScore = Integer.toString(score);
        }
        player.time = Integer.toString(Integer.parseInt(player.time) +count);
        player.numberOfQuestions = Integer.toString(Integer.parseInt(player.numberOfQuestions) +nigma);
        
    }
    
    public void YesActionPerformed(java.awt.event.ActionEvent evt){
        if(!winner && !looser)
            if(actual != null){
                if (actual.yes != null) {
                    actual = actual.yes;
                    nigma++;
                }else{
                    timer.stop();
                    if (nigma > 15) {
                        looser = true;
                    }else{
                        winner = true;
                    }
                    savePlayerInfo();
                    updateGUI();
                }
            }
        updateInfo();
    }
    
    public void NoActionPerformed(java.awt.event.ActionEvent evt){
        if(!winner && !looser){
            if(actual != null){
                if (actual.no != null) {
                    actual = actual.no;
                    nigma++;
                }else{
                    timer.stop();
                    looser = true;
                    savePlayerInfo();
                    learnGUI();
                }
            }
        }
        updateInfo();
    }
    
    public void DunnoActionPerformed(java.awt.event.ActionEvent evt){
        if(!winner && !looser){
            if(actual != null){
                if (actual.dunno != null) {
                    actual = actual.dunno;
                    nigma++;
                }else{

                }
            }
        }
        updateInfo();
    }
    
    public void MaybeYesActionPerformed(java.awt.event.ActionEvent evt){
        if(!winner && !looser){
            if(actual != null){
                if(actual != null){
                    if (actual.maybe != null) {
                        actual = actual.maybe;
                        nigma++;
                    }else{

                    }
                }
            }
        }
        updateInfo();
    }
    
    public void MaybeNoActionPerformed(java.awt.event.ActionEvent evt){
        if(!winner && !looser){
            if(actual != null){
                if (actual.maybeNot != null) {
                    actual = actual.maybeNot;
                    nigma++;
                }else{

                }
            }
        }
        updateInfo();
    }
    
    public void ScoresActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    
    public void PlayerActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    
    public void ExitActionPerformed(java.awt.event.ActionEvent evt){
        saveTxts();
        this.dispose();
    }
    
    public void OkActionPerformed(java.awt.event.ActionEvent evt){
        /*
            HAY QUE HACER QUE APRENDA 
        */
        String t1, t2;
        t1 = respuestaText.getText();
        t2 = preguntaText.getText();
        if (!"".equals(t1) && !"".equals(t2)) {
            t1 = "Estaba pensando en " +t1 +"?";
            if (!t2.contains("?")) {
                t2 = t2 +"?";
            }
            if (!t2.contains("Su personaje")) {
                t2 = "Su personaje " + t2.toLowerCase();
            }
            if (a.isSelected()) {
                a1 = new DualNode(t1);
//                System.out.println("RLLY?");
            }else{
                a1 = new DualNode(actual.text);
            }
            if (b.isSelected()) {
                b1 = new DualNode(t1);
            }else{
                b1 = new DualNode(actual.text);
            }
            if (c.isSelected()) {
                c1 = new DualNode(t1);
            }else{
                c1 = new DualNode(actual.text);
            }
            if (d.isSelected()) {
                d1 = new DualNode(t1);
            }else{
                d1 = new DualNode(actual.text);
            }
            if (e.isSelected()) {
                e1 = new DualNode(t1);
            }else{
                e1 = new DualNode(actual.text);
            }
            actual.text = t2;
            actual.setSons(a1, b1, c1, d1, e1);
//            remove(ok);
            remove(respuesta);
            remove(pregunta);
            remove(decide);
            remove(respuestaText);
            remove(preguntaText);
            remove(a);
            remove(b);
            remove(c);
            remove(d);
            remove(e);
            updateGUI();
        }
        
        
    }

    
    public void saveTxts(){
        SimpleNode qPTR = new SimpleNode(true);
        SimpleNode aPTR = new SimpleNode(true);
        root.treeToList(qPTR, aPTR);
        qPTR.questionsToString(aPTR);
        aPTR.answersToString();
        qPTR.prinTreeNodeInfo();
        qPTR.printInfo();
        ques.save_QnA(qPTR);
        ans.save_QnA(aPTR);
        playe.savePlayers(ptr);
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
