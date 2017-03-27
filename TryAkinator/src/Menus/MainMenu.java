package Menus;

import Structures.DualNode;
import Structures.InfoNode;
import Structures.SimpleNode;
import Util.ReWi;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class MainMenu extends javax.swing.JFrame{

    private javax.swing.JButton logIn;
    private javax.swing.JButton help;
    private javax.swing.JButton scores;
    private ReWi playerReader;
    private ReWi questionsReader;
    private ReWi answersReader;
    private InfoNode pPTR, qPTR, aPTR;
    private DualNode root;
    
    public MainMenu() {
        setSize(155, 205);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(" Menu Principal ");
        getContentPane().setBackground(Color.black);
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon);
        initUI();
        initData();
        setVisible(true);
        System.out.println("Current time: " + (System.currentTimeMillis()/100));
    }
    
    public void initUI(){
        logIn = new javax.swing.JButton();
        logIn.setText("Log in");
        logIn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                LogInActionPerformed(evt);
            }
        });
        logIn.setSize(80, 30);
        logIn.setLocation(35, 20);
        logIn.setVisible(true);
        this.add(logIn);
        
        scores = new javax.swing.JButton();
        scores.setText("Score");
        scores.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ScoresActionPerformed(evt);
            }
        });
        scores.setSize(80, 30);
        scores.setLocation(35, 70);
        scores.setVisible(true);
        this.add(scores);
        
        help = new javax.swing.JButton();
        help.setText("Guia");
        help.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                HelpActionPerformed(evt);
            }
        });
        help.setSize(80, 30);
        help.setLocation(35, 120);
        help.setVisible(true);
        this.add(help);
    }
    
    public void initData(){
        playerReader = new ReWi(1); 
        questionsReader = new ReWi(2); 
        answersReader = new ReWi(3);
        pPTR = playerReader.ReadPlayers();
        qPTR = questionsReader.read_QnA();
        aPTR = answersReader.read_QnA();
        initTree();
    }
    
    public void initTree(){
        int indexOfYes = Integer.parseInt(qPTR.yes.split(",")[1]);
        int indexOfMaybe = Integer.parseInt(qPTR.maybe.split(",")[1]);
        int indexOfDunno = Integer.parseInt(qPTR.dunno.split(",")[1]);
        int indexOfMaybeNot = Integer.parseInt(qPTR.maybeNot.split(",")[1]);
        int indexOfNo = Integer.parseInt(qPTR.no.split(",")[1]);
        DualNode yes = new DualNode(qPTR.getMeNodeNumber(indexOfYes).text);
        DualNode maybe = new DualNode(qPTR.getMeNodeNumber(indexOfMaybe).text);
        DualNode dunno = new DualNode(qPTR.getMeNodeNumber(indexOfDunno).text);
        DualNode maybeNot = new DualNode(qPTR.getMeNodeNumber(indexOfDunno).text);
        DualNode no =  new DualNode(qPTR.getMeNodeNumber(indexOfDunno).text);
        root = new DualNode(qPTR.text, yes, maybe, dunno, maybeNot, no);
        
        InfoNode p = qPTR.link;  
        String text;
        int c = 0;
        
        while (p != null) {    
            c++;
            System.out.println("he entrado: " +c +" veces...");
            text = p.text;
            System.out.println("P: " +p.text +"\n\tYes: " +p.yes +"\n\tMaybe: " 
                    +p.maybe +"\n\tDunno: " +p.dunno +"\n\tMaybe Not: " +p.maybeNot
                    +"\n\tNo: " +p.no);
            SimpleNode T = new SimpleNode(true);
            root.fillWithT(T, text);
            if (T.findsAnUnvisitedNode(text)) {
                indexOfYes = Integer.parseInt(p.yes.split(",")[1]);
                indexOfMaybe = Integer.parseInt(p.maybe.split(",")[1]);
                indexOfDunno = Integer.parseInt(p.dunno.split(",")[1]);
                indexOfMaybeNot = Integer.parseInt(p.maybeNot.split(",")[1]);
                indexOfNo = Integer.parseInt(p.no.split(",")[1]);
                if (p.yes.split(",")[0].equals("q")) {
                    yes = new DualNode(qPTR.getMeNodeNumber(indexOfYes).text);
                }else{
                    yes = new DualNode(aPTR.getMeNodeNumber(indexOfYes).text);
                }
                if (p.maybe.split(",")[0].equals("q")) {
                    maybe = new DualNode(qPTR.getMeNodeNumber(indexOfMaybe).text);
                }else{
                    maybe = new DualNode(aPTR.getMeNodeNumber(indexOfMaybe).text);
                }
                if (p.dunno.split(",")[0].equals("q")) {
                    dunno = new DualNode(qPTR.getMeNodeNumber(indexOfDunno).text);
                }else{
                    dunno = new DualNode(aPTR.getMeNodeNumber(indexOfDunno).text);
                }
                if (p.maybeNot.split(",")[0].equals("q")) {
                    maybeNot= new DualNode(qPTR.getMeNodeNumber(indexOfMaybeNot).text);
                }else{
                    maybeNot = new DualNode(aPTR.getMeNodeNumber(indexOfMaybeNot).text);
                }
                if (p.no.split(",")[0].equals("q")) {
                    no = new DualNode(qPTR.getMeNodeNumber(indexOfNo).text);
                }else{
                    no = new DualNode(aPTR.getMeNodeNumber(indexOfNo).text);
                }
                T.findSonlessNode(text).setSons(yes, maybe, dunno, maybeNot, no);
//                root.find(text).setSons(yes, maybe, dunno, maybeNot, no);
                p = p.link;
                System.out.println("--------P has entered to the tree--------");
            }else{
                p = p.link;
            }
        }
        int a = 1;
    }
    
    public void LogInActionPerformed(java.awt.event.ActionEvent evt){
        LoginFrame lf = new LoginFrame();
        lf.setPtr(this.getP_PTR());
        lf.setRoot(root);
        this.dispose();
    }
    
    public void ScoresActionPerformed(java.awt.event.ActionEvent evt){
        ScoreFrame sf = new ScoreFrame(1, pPTR);
    }
    
    public void HelpActionPerformed(java.awt.event.ActionEvent evt){
        HelpFrame hf = new HelpFrame();
    }
    
    ////////////////////////////////////////////////////////////////////////////

    public InfoNode getP_PTR() {
        return pPTR;
    }

    public void setP_PTR(InfoNode pPTR) {
        this.pPTR = pPTR;
    }

    public InfoNode getQ_PTR() {
        return qPTR;
    }

    public void setQ_PTR(InfoNode qPTR) {
        this.qPTR = qPTR;
    }

    public InfoNode getA_PTR() {
        return aPTR;
    }

    public void setA_PTR(InfoNode aPTR) {
        this.aPTR = aPTR;
    }

    public DualNode getRoot() {
        return root;
    }

    public void setRoot(DualNode root) {
        this.root = root;
    }
    
    
}
