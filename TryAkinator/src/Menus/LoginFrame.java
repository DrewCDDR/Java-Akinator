package Menus;

import Structures.DualNode;
import Structures.InfoNode;
import Util.ReWi;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;

public class LoginFrame extends javax.swing.JFrame{

    private boolean uclick = true, pclick = true; 
    private int e = 0;
    private ReWi rw;
    private InfoNode ptr;
    private DualNode root;
    private javax.swing.JButton ok;
    private javax.swing.JButton back;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelPass;
    private javax.swing.JTextArea areaErrors;
    private javax.swing.JTextField textUser;
    private javax.swing.JPasswordField textPass;
    
    public LoginFrame() { // SE CONSTRUYE EL FRAME
        rw = new ReWi(1);
        setSize(415, 405);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu Log In");
        getContentPane().setBackground(Color.black);
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon);
        init();
        setVisible(true);
    }
    
    public void init(){ // SE AÑADEN TODOS LOS OBJETOS QUE SE USARAN EN EL JFRAME
        ok = new javax.swing.JButton();
        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                OkActionPerformed(evt);
            }
        });
        ok.setSize(70, 30);
        ok.setLocation(330, 340);
        ok.setVisible(true);
        this.add(ok);
        
        back = new javax.swing.JButton();
        back.setText("Inicio");
        back.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                BackActionPerformed(evt);
            }
        });
        back.setSize(70, 30);
        back.setLocation(10, 340);
        back.setVisible(true);
        this.add(back);
        
        labelUser = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        labelUser.setText("Usuario:");
        labelPass.setText("Contraseña:");
        labelUser.setLocation(100, 90);
        labelPass.setLocation(100, 240);
        labelUser.setSize(80, 20);
        labelPass.setSize(80, 20);
        labelUser.setForeground(Color.white);
        labelPass.setForeground(Color.white);
        labelUser.setVisible(true);
        labelPass.setVisible(true);
        this.add(labelUser);
        this.add(labelPass);
        
        areaErrors = new javax.swing.JTextArea();
        areaErrors.setLocation(90, 160);
        areaErrors.setSize(230, 40);
        areaErrors.setEditable(false);
        areaErrors.setBackground(Color.black);
        areaErrors.setForeground(Color.red);
        areaErrors.setLineWrap(true);
        areaErrors.setWrapStyleWord(true);
        areaErrors.setVisible(true);
        this.add(areaErrors);
        
        textUser = new javax.swing.JTextField();
        textPass = new javax.swing.JPasswordField();
        textUser.setText("Type your username");
        textPass.setEchoChar((char) 0);
        textPass.setText("Type your password");
        textUser.setLocation(180, 90);
        textPass.setLocation(180, 240);
        textUser.setSize(120, 20);
        textPass.setSize(120, 20);
//        textUser.setFocusable(false);
//        textPass.setFocusable(false);
        textUser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (uclick) {
                    textUser.setText("");
                    uclick = false;
                }
            }
        });
        textPass.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (pclick) {
                    textPass.setEchoChar('*');
                    textPass.setText("");
                    pclick = false;
                }
            }
        });
        textUser.setVisible(true);
        textPass.setVisible(true);
        this.add(textUser);
        this.add(textPass);
        
    }
    
    public String TransforCharsIntoString(char[] c){
        int l = c.length;
        String a = "";
        for (int i = 0; i < l; i++) {
            a = a + c[i];
        }
        return a;
    }
    
    public void setErrors(int n){
        switch(n){
            case 0:
                areaErrors.setText("");
            case 1:
                areaErrors.setText("No se escribio en el campo el usuario");
                break;
            case 2:
                areaErrors.setText("No se escribio en el campo de la contraseña");
                break;
            case 3:
                areaErrors.setText("No se escribio en ningun campo");
                break;
            case 4:
                areaErrors.setText("Cliquee el campo del usuario");
                break;
            case 5:
                areaErrors.setText("Cliquee el campo de la contraseña");
                break;
            case 6:
                areaErrors.setText("Cliquee ambos campos");
                break;
            case 7:
                areaErrors.setText("La contraseña ingresada es incorrecta");
                break;
            case  8:
                areaErrors.setText("Su usuario no puede tener más de 7 caracteres");
                break;
            case  9:
                areaErrors.setText("Su usuario no puede tener caracteres especiales!");
                break;
        }
    }
    
    private void OkActionPerformed(java.awt.event.ActionEvent evt){
        InfoNode player;
        e = 0;
        String password = TransforCharsIntoString(textPass.getPassword());
        String username = textUser.getText();
        int l = username.length();
        areaErrors.setText("");
        Pattern p = Pattern.compile("[^a-zA-Z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(username);
        boolean b = m.find();
        if ((username.equals(""))) {
            e = 1;
        }
        
        if ((password.equals(""))) {
            if(e == 1){
                e = 3;
            }else if(e == 0){
                e = 2;
            }
        }
        
        if (username.equals("Type your username")) {
            e = 4;
        }
        
        if (password.equals("Type your password")) {
            if (e == 4) {
                e = 6;
            }else if (e == 0){
                e = 5;
            }
        }
        
        if (username.length() > 7) {
            e = 8;
        }
        
        if (b) {
            e = 9;
        }
        
        if (e == 0) {
            if (ptr.verifyIfUsernameExists(username)) {
                if (ptr.verifyIfUserPasswordIsCorrect(username, password)) {
                    int n = ptr.getMeTheIndexOf(username);
                    player = ptr.getMeNodeNumber(n);
                    PlayerMenu plm = new PlayerMenu();
                    plm.setPlayer(player);
                    plm.setPtr(ptr);
                    plm.setRoot(root);
                    this.dispose();
                }else{
                    e = 7;
                }
            }else{
                InfoNode z = new InfoNode(username, password, "0", "0", "0",
                        "0", "0");
                player = z;
                ptr.add(z);
                ptr.organizeByHighscore();
                rw.savePlayers(ptr);
                PlayerMenu plm = new PlayerMenu();
                plm.setPlayer(player);
                plm.setPtr(ptr);
                plm.setRoot(root);
                this.dispose();
            }
        }
        setErrors(e);
    }
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt){ 
        MainMenu mm = new MainMenu();
        mm.setP_PTR(this.getPtr());
        mm.setRoot(root);
        this.dispose();
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
