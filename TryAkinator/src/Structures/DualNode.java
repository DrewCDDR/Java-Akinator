package Structures;

import java.awt.image.BufferedImage;

public class DualNode {
    
    public boolean did, visited;
    public DualNode yes, maybe, dunno, maybeNot, no;
    public String text;
    public java.awt.image.BufferedImage img;

    // CONSTRUCTORS Begins------------------------------------------------------
    public DualNode() {
    }
    
   
    public DualNode(BufferedImage img) {
        this.img = img;
        this.yes = null;
        this.no = null;   
    }
    
    public DualNode(String text){
        this.text = text;
        this.did = false;
        this.visited = false;
        this.yes = null;
        this.no = null;
    }

    public DualNode(String text, DualNode yes,DualNode maybe, DualNode dunno,
            DualNode maybeNot, DualNode no) {
        this.yes = yes;
        this.maybe = maybe;
        this.dunno = dunno;
        this.maybeNot = maybeNot;
        this.no = no;
        this.text = text;
        this.did = false;
        this.visited = false;
    }
    // CONSTRUCTORS Ends--------------------------------------------------------
    
    // DOUBLE LIST FUNCTIONS Begins:::::::::::::::::::::::::::::::::::::::::::::
    public void addDobuleList(DualNode q){
        DualNode p = this;
        if (p.no == null) {
            p.no = q;
            q.yes = p;
        }else{
            while (p.no != null) {                
                p = p.no;
            }
            p.no = q;
            q.yes = p;
        }
    }
    //DOUBLE LIST FUNCTIONS Ends::::::::::::::::::::::::::::::::::::::::::::::::
    
    //TREE FUNCTIONS Begins===================================================== 
    //RETURNS THE FATHER OF THE NODE "son"
    public DualNode findFather(DualNode son){
        DualNode a = this;
        if (a != null) {
            if (a.yes == son || a.maybe == son || a.dunno == son || 
                    a.maybeNot == son || a.no == son) {
                return a;
            }else{
                if (a.yes != null) {
                    a.yes.findFather(son);
                }else if(a.maybe != null){
                    a.maybe.findFather(son);
                }else if(a.dunno != null){
                    a.dunno.findFather(son);
                }else if(a.maybeNot != null){
                    a.maybeNot.findFather(son);
                }else if(a.no != null){
                    a.no.findFather(son);
                }
            }
        }
        return null;
    }
    
    // FINDS THE FIRST LEAVE OF A TREE
    public DualNode findHoja(){
        DualNode a = this;
        if (a != null) {
            if (a.yes == null && a.maybe == null && a.dunno == null &&
                    a.maybeNot == null && a.no == null) {
                return a;
            }else{
                a.yes.findHoja();
                a.maybe.findHoja();
                a.dunno.findHoja();
                a.maybeNot.findHoja();
                a.no.findHoja();
            }
        }
        return null;
    }
    
    public void fillWithT(SimpleNode T, String text){
        DualNode actual = this;
        if (text.equals("Su personaje es un heroe o es bueno?")) {
           int z = 2 ;
        }
        if (actual != null) {
            if (actual.text.equals(text)) {
                SimpleNode p = new SimpleNode(actual);
                T.add(p);
                return;
            }
            if(actual.yes != null)
                actual.yes.fillWithT(T, text);
            if(actual.maybe != null)
                actual.maybe.fillWithT(T, text);
            if(actual.dunno != null)
                actual.dunno.fillWithT(T, text);
            if(actual.maybeNot != null)
                actual.maybeNot.fillWithT(T, text);
            if(actual.no != null)
                actual.no.fillWithT(T, text);
        }
    }
    
    public void treeToList(SimpleNode qPTR, SimpleNode aPTR){
        DualNode actual = this;
        if (actual != null) {
            SimpleNode p = new SimpleNode(actual);
            if (actual.yes != null) {
                qPTR.add(p);
            }else{
                if (!aPTR.hasText(actual.text)) {
                    aPTR.add(p);
                }
            } 
            if(actual.yes != null)
                actual.yes.treeToList(qPTR, aPTR);
            if(actual.maybe != null)
                actual.maybe.treeToList(qPTR, aPTR);
            if(actual.dunno != null)
                actual.dunno.treeToList(qPTR, aPTR);
            if(actual.maybeNot != null)
                actual.maybeNot.treeToList(qPTR, aPTR);
            if(actual.no != null)
                actual.no.treeToList(qPTR, aPTR);
        }
    }
    //TREE FUNCTIONS Ends=======================================================
    
    ////////////////////////////////////////////////////////////////////////////
    public void setSons(DualNode yes, DualNode maybe, DualNode dunno,
            DualNode maybeNot, DualNode no){
        this.yes = yes;
        this.maybe = maybe;
        this.dunno = dunno;
        this.maybeNot = maybeNot;
        this.no = no;
    }
}
