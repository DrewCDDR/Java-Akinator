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

    public SimpleNode(DualNode treeNode) {
        this.treeNode = treeNode;
        this. ptr = false;
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
        if (t.endsWith("Su personaje es de DC Comics?")) {
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
}
