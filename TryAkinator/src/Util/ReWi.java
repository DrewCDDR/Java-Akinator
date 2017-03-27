package Util;

import Structures.InfoNode;
import Structures.SimpleNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReWi {
    public File f ;
    
    
    public ReWi(int n) {
        switch(n){
            case 1: 
                f = new File("Files/Score.txt");
                break;
            case 2: 
                f = new File("Files/Questions.txt");
                break;
            case 3:
                f = new File("Files/Answers.txt");
                break;
        }
        
    }
    
    
    //PENDING
    public InfoNode read_QnA(){
        InfoNode ptr;
        String line;
        try{
            Scanner sc = new Scanner(f);
            line = sc.nextLine();
            InfoNode q = new InfoNode(line.split(";")[0], line.split(";")[1],
                line.split(";")[2], line.split(";")[3], line.split(";")[4],
                    line.split(";")[5]);
            ptr = q;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                InfoNode p = new InfoNode(line.split(";")[0], line.split(";")[1],
                line.split(";")[2], line.split(";")[3], line.split(";")[4],
                    line.split(";")[5]);
                ptr.add(p);
            }
        }catch(FileNotFoundException e){
            System.out.println("El archivo no se encontro");
            ptr = null;
        }
        return ptr;
    }

    public InfoNode ReadPlayers(){
        InfoNode ptr;
        String line;
        try{
            Scanner sc = new Scanner(f);
            line = sc.nextLine();
            InfoNode q = new InfoNode(line.split(";")[0], line.split(";")[1], 
                line.split(";")[2], line.split(";")[3], line.split(";")[4],
                line.split(";")[5], line.split(";")[6]);
            ptr = q;
            while (sc.hasNextLine()) {                
                line = sc.nextLine();
                InfoNode p = new InfoNode(line.split(";")[0], line.split(";")[1], 
                    line.split(";")[2], line.split(";")[3], line.split(";")[4],
                    line.split(";")[5], line.split(";")[6]);
                ptr.add(p);
            }    
        }catch(FileNotFoundException  e){
            System.out.println("El archivo no se encontro");
            ptr = null;
        }
        return ptr;
    }
    
    
    
    public void savePlayers(InfoNode ptr){
        InfoNode p = ptr;
        FileWriter fw = null;
        try{
            fw = new FileWriter(f);
            while(p != null){
                if (p.link != null) {
                        fw.append(p.username +";" +p.password +";" +p.highScore +";"
                        +p.numberOfQuestions +";" +p.time +";" +p.timesPlayed 
                        +";" +p.averageScore+"\n");
                    }else{
                        fw.append(p.username +";" +p.password +";" +p.highScore +";"
                        +p.numberOfQuestions +";" +p.time +";" +p.timesPlayed 
                        +";" +p.averageScore);
                    }
                p = p.link;
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            if (fw != null) {
                try{
                    fw.close();
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    public void save_QnA (SimpleNode ptr){
        SimpleNode p = ptr;
        FileWriter fw = null;
        try{
            fw = new FileWriter(f);
            while(p != null){
                if(!p.ptr){
                    if (p.link != null) {
                        fw.append(p.text +"\n");
                    }else{
                        fw.append(p.text);
                    }
                }
                    p = p.link;
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            if (fw != null) {
                try{
                    fw.close();
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }
        }
        
    }
}
