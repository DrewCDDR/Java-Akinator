package Structures;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static javafx.util.Duration.seconds;

public class InfoNode {

    public String username, password, highScore, numberOfQuestions, time,
            timesPlayed, averageScore, text, yes, maybe, dunno, maybeNot, no;
    public InfoNode link;
    
    
    // CONSTRUCTORS: Begins------------------------------------------------------
    public InfoNode(String username, String password, String highScore,
            String numberOfQuestions, String time, String timesPlayed,
            String averageScore) {
        this.username = username;
        this.password = password;
        this.highScore = highScore;
        this.numberOfQuestions = numberOfQuestions;
        this.time = time;
        this.timesPlayed = timesPlayed;
        this.averageScore = averageScore;
        this.link = null;
    }

    public InfoNode(String text, String yes, String maybe, String dunno,
            String maybeNot, String no) {
        this.text = text;
        this.yes = yes;
        this.maybe = maybe;
        this.dunno = dunno;
        this.maybeNot = maybeNot;
        this.no = no;
        this.link = null;
    }
    //CONSTRUCTORS: Ends---------------------------------------------------------
    
    // AÑADIR UN NODO
    public void add(InfoNode p){
        if (this.link == null) {
            this.link = p;
        }else{
            InfoNode q = this;
            while (q.link != null) {                
                q = q.link;
            }
            q.link = p;
        }
    }
    
    // VER SI EL STRING "u" ES EL NOMBRE DE ALGUN JUGADOR
    public boolean verifyIfUsernameExists(String u){
        boolean sw = true;
        InfoNode p = this;
        while(p != null && sw){
            if (p.username.equals(u)) {
                sw = false;
            }else{
                p = p.link;
            }
        }
        if (sw) {
            return false;
        }else{
            return true;
        }
    }
    
    //BUSCAR AL JUGADOR "j" PARA VERIFICAR SI SU CONTRASEÑA INGRESADA "p" ES CORRECTA. 
    public boolean verifyIfUserPasswordIsCorrect(String j, String p){
        boolean sw = true, c = false;
        InfoNode q = this;
        while(q.link == null && sw){
            if (q.username.equals(j)) {
                if (q.password.equals(p)) {
                    c = true;
                }
                sw = false;
            }else{
                q = q.link;
            }
        }
        if (c){
            return true;
        }else{
            return false;
        }
    }
    
    //RETORNA EL INDICE DEL NODO CON TEXTO "u".
    public int getMeTheIndexOf(String u){
        boolean sw = true;
        int n = 0;
        InfoNode p = this;
        while (p != null && sw) {            
            if (p.username.equals(u)) {
                sw = false;
            }else{
                p = p.link;
            }
            n++;
        }
        return n;
    }
    
    // REGRESA EL NODO CON LA POSICION NUMERO "n" EN LA LISTA.
    public InfoNode getMeNodeNumber(int n){
        boolean sw = true;
        int i = 0;
        int l = this.lenght();
        InfoNode p = this;
        if (n == 1) {
            return p;
        }else{
            while(p.link != null && i <= n && sw){
                i++;
                if (i == n) {
                    sw = false;
                }else{
                    p = p.link;
                }  
            }
            if(!sw){
                return p;
            }else{
                if (n == l) {
                    return p;
                }else{
                    return null;
                }
            }
        }
    }
    
    public InfoNode getPlayerNumber(int n){
        boolean sw = true;
        int i = 0;
        InfoNode p = this;
        if (n == 1) {
            return p;
        }else{
            while(p.link != null && i <= n && sw){
                i++;
                if (i == n) {
                    sw = false;
                }else{
                    p = p.link;
                }  
            }
            if(!sw){
                return p;
            }else{
                return null;
            }
        }
    }

    // ESCRIBE EL TIEMPO DADO EN MILISEGUNDOS EN FORMATO DE HORA:MINUTOS:SEGUNDOS.
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
    
    //RETORNA EL TAMAÑO DE LA LISTA.
    public int lenght(){
        InfoNode p = this;
        int n = 0;
        while (p != null) {                
            n++;
            p = p.link;
        }
        return n;
    }
}
