/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

/**
 *
 * @author cddr
 */
public class SimpleNode {
    public DualNode treeNode;
    public SimpleNode link;
    public boolean ptr;
    public boolean b;
    public String text = "";

    public SimpleNode(DualNode treeNode) {
        this.treeNode = treeNode;
        this. ptr = false;
        this.b = false;
        this.link = null;
    }

    public SimpleNode(boolean ptr) {
        this.ptr = ptr;
    }
    
    public void add(SimpleNode q){
        SimpleNode p = this;
        if (p.link == null) {
            p.link = q;
        }else{
            while (p.link != null) {                
                p = p.link;
            }
            p.link = q;
        }
    }
    
    public int lenght(){
        int l = 0;
        SimpleNode p = this;
        while(p != null){
            l++;
            p = p.link;
        }
        return l;
    }
    
    public SimpleNode getMeNodeNumber(int n){
        boolean sw = true;
        int i = 0;
        int l = this.lenght();
        SimpleNode p = this;
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
    
    public boolean findsAnUnvisitedNode(String t){
        SimpleNode p = this;
        boolean sw = true;
        if (t.endsWith("Su personaje es un heroe o es bueno?")) {
            int z = 2;
        }
        while (p != null && sw){
            if(!p.ptr){
                if (p.treeNode.text.equals(t)) {
                    if (!p.treeNode.did) {
                        p.treeNode.did = true;
                        sw = false;
                    }else{
                        p = p.link;
                    }
                }else{
                    p = p.link;
                }
            }else{
                p = p.link;
            }
        }
        if (!sw) {
            return true;
        }else{
            return false;
        }
    }
    
    public DualNode findSonlessNode(String t){
        SimpleNode p = this;
        boolean sw = true;
        if (t.endsWith("Su personaje es de DC Comics?")) {
            int z = 2;
        }
        while (p != null && sw){
            if(!p.ptr){
                if (p.treeNode.text.equals(t)) {
                    if (!p.treeNode.visited) {
                        p.treeNode.visited = true;
                        sw = false;
                    }else{
                        p = p.link;
                    }
                }else{
                    p = p.link;
                }
            }else{
                p = p.link;
            }
        }
        if (!sw) {
            return p.treeNode;
        }else{
            return null;
        }
    }
    
    public boolean hasText(String t){
        boolean sw = false;
        SimpleNode p = this;
        while(p != null && !sw){
            if (!p.ptr) {
                if (p.treeNode.text.equals(t)) {
                    sw = true;
                }
                p = p.link;
            }else{
                p = p.link;
            }
        }
        
        return sw;
    }
    
    public int findTheIndexOf(SimpleNode q){
        SimpleNode p = this;
        int n = 0;
        boolean sw = true;
        while (p != null && sw) {
            if (!p.ptr) {
                n++;
                if (p == q) {
                    sw = false;
                }else{
                    p = p.link;
                }
            }else{
                p = p.link;
            }
        }
        return n;
    }
    
    public int findTheIndexOf(String t){
        SimpleNode p = this;
        int n = 0;
        boolean sw = true;
        while (p != null && sw) {
            if(!p.ptr){
                n++;
                if (p.treeNode.text == t) {
                    sw = false;
                }else{
                    p = p.link;
                }
            }else{
                p = p.link;
            }
        }
        return n;
    }
    
    public void setBs(){
        SimpleNode p = this;
        while(p != null){
            if (!p.ptr) {
                p.b = false;
            }
            p = p.link;
        }
    }
    
    public void questionsToString(SimpleNode aPTR){
        SimpleNode ptr1 = this;
        SimpleNode chisme = aPTR;
        SimpleNode p = this;
        while (p != null) {            
            if (!p.ptr) {
                String a = "", b = "", c = "", d = "", e = "";
                ptr1.setBs();
                SimpleNode q = p.link;
                SimpleNode ptr2 = aPTR.link;
                while (q != null) {                
                    if (!q.b) {
                        q.b = true;
                        if (p.treeNode.yes.equals(q.treeNode)) {
                                a = ";q," +ptr1.findTheIndexOf(q);
                        }
                        if (p.treeNode.maybe.equals(q.treeNode)) {
                                b = ";q," +ptr1.findTheIndexOf(q);
                        }
                        if (p.treeNode.dunno.equals(q.treeNode)) {
                                c = ";q," +ptr1.findTheIndexOf(q);
                        }
                        if (p.treeNode.maybeNot.equals(q.treeNode)) {
                                d = ";q," +ptr1.findTheIndexOf(q);
                        }
                        if (p.treeNode.no.equals(q.treeNode)) {
                                e = ";q," +ptr1.findTheIndexOf(q);
                        }
                    }
                    q = q.link;
                }
                while(ptr2 != null){
                    if (p.treeNode.yes.text.equals(ptr2.treeNode.text)) {
                        a = ";a," +chisme.findTheIndexOf(ptr2);
                    }
                    if (p.treeNode.maybe.text.equals(ptr2.treeNode.text)) {
                        b = ";a," +chisme.findTheIndexOf(ptr2);
                    }
                    if (p.treeNode.dunno.text.equals(ptr2.treeNode.text)) {
                        c = ";a," +chisme.findTheIndexOf(ptr2);
                    }
                    if (p.treeNode.maybeNot.text.equals(ptr2.treeNode.text)) {
                        d = ";a," +chisme.findTheIndexOf(ptr2);
                    }
                    if (p.treeNode.no.text.equals(ptr2.treeNode.text)) {
                        e = ";a," +chisme.findTheIndexOf(ptr2);
                    }
                    ptr2 = ptr2.link;
                }
                p.text = p.treeNode.text +a +b +c +d +e;
            }
            p = p.link;
        }
    }
    
    public void answersToString(){
        SimpleNode p = this;
        while (p != null) {            
            if (!p.ptr) {
                p.text = p.treeNode.text +";null;null;null;null;null";
            }
            p = p.link;
        }
    }
    
    public void prinTreeNodeInfo(){
        SimpleNode p = this;
        while (p != null) {            
            if (!p.ptr) {
                System.out.println("Texto: " +p.treeNode.text);      
            }
            p = p.link;
        }
    }
    
    public void printInfo(){
        SimpleNode p = this;
        while (p != null) {            
            if (!p.ptr) {
                System.out.println("Linea: " +p.text);      
            }
            p = p.link;
        }
    }
}
