package tiralabra;

/**
 * Huffman Compression
 *
 * University of Helsinki
 * Department of Computer Science
 * Data Structures Project
 * Course code: 58161
 *
 * @author Jarkko Nyman
 *
 */

/**
 * Node is the basic object class that is used in containing original read data
 * and as assisting object in the building of the heap.
 *
 */


public class Node{


     private int origValue, nodeValue;
     private String binString;
     private Node left, right;


    public int getOrigValue() {
        return origValue;
    }

    public void setOrigValue(int origValue) {
        this.origValue = origValue;
    }

     public Node(int nodeValue, int origValue){
         this.origValue = origValue;
         this.nodeValue = nodeValue;
     }

     public Node(int nodeValue){
         this.nodeValue = nodeValue;
     }

     public void setLeft(Node node){
         this.left = node;
     }

     public void setRight(Node node){
         this.right = node;
     }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue += nodeValue;
    }

     public int getNodeValue(){
         return this.nodeValue;
     }

    public String getBinString() {
        return binString;
    }

    public void setBinString(String binString) {
        this.binString = binString;
    }


}