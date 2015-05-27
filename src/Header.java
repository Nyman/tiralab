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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * Header is responsible of either creating the needed and included metadata of
 * the compression or reading and using it to decompress the .hff file.
 */

public class Header{

    private static int weight;
    private static String bits[];
    private static Heap deHuffHeap = new Heap(256);
    private static Tree tree;

    /**
     * Reads from the beginning of the file in decompression. The values read are
     * then used to reconstruct the Tree needed to decode the .hff file in question
     * The .hff contains a marker of four consecutive bytes of 0's to mark the
     * end of the header and beginning of the actual data to be extracted.
     * @param bin
     * @throws IOException
     */

    public static void headerReader(BufferedInputStream bin) throws IOException{

        while(true){
            int first = bin.read();
            int second = bin.read();
            int third = bin.read();
            int fourth = bin.read();
            int value = bin.read();
            if(first == 0 && second == 0 && third == 0 && fourth == 0 ){
                break;
            }
            first = (int) (first * java.lang.Math.pow(2, 24));
            second = (int) (second * java.lang.Math.pow(2, 16));
            third = (int) (third * java.lang.Math.pow(2, 8));
            int total = first+second+third+fourth;
            Node node = new Node(total, value);
            deHuffHeap.insert(node);
        }

        while(deHuffHeap.getPointer() > 1){
            int kertaa = 1;
            for(int i = 1; i <= deHuffHeap.getPointer(); i++){
            }
            kertaa++;
            deHuffHeap.mergeNodes(); 
        }
        tree = new Tree(deHuffHeap.getTreeNode());
        DeHuff.setTree(tree);
    }

    /**
     * Writes the meta information to the .hff needed to decode it later
     * @param bout
     * @throws IOException
     */

    public static void headerWriter(BufferedOutputStream bout) throws IOException{

        for(int i = 0; i < Header.bits.length-1; i++){
            if(Header.bits[i] != null){
                Huff.binStringToBooleanChar(Header.bits[i], bout);
                bout.write(i);
            }
        }
        Huff.binStringToBooleanChar(Header.bits[256], bout);
        bout.write(255);
    }

    /**
     * Tool to generate exactly 4 byte long representations of the amounts of a
     * character found in the file to be encoded
     * @param weights
     */

    public static void headerBuilder(int[] weights){

        bits = new String[weights.length+1];
        for(int i = 0; i < weights.length; i++){
            if(weights[i] > 0){
                bits[i] = fourByteBuilder(weights[i]);
            }
        }
        bits[weights.length] = "00000000000000000000000000000000";
    }

    /**
     * Unsophisticated way to make sure any given number from 0 to (2^32)-1 will
     * be in a 4 byte long representation. Not a nice nor short way to program
     * this, but fast to write and easy to understand.
     * @param origweight
     * @return
     */

    public static String fourByteBuilder(int origweight){

        String first = "00000000", second = "00000000", third = "00000000", fourth = "00000000";
        weight = origweight;
        if(weight >= java.lang.Math.pow(2, 24)){
            first = firstByte();
        }
        if(weight >= java.lang.Math.pow(2, 16)){
            second = secondByte();
        }
        if(weight >= java.lang.Math.pow(2, 8)){
            third = thirdByte();
        }
        if(weight >= java.lang.Math.pow(2, 0)){
            fourth = fourthByte();
        }
        return first+second+third+fourth;
    }

  public static String firstByte(){
      String firstbyte = "";
      if(weight >= java.lang.Math.pow(2,31)){
          firstbyte += 1;
          weight -= java.lang.Math.pow(2,31);
      }
      else{
          firstbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,30)){
          firstbyte += 1;
          weight -= java.lang.Math.pow(2,30);
      }
      else{
          firstbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,29)){
          firstbyte += 1;
          weight -= java.lang.Math.pow(2,29);
      }
      else{
          firstbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,28)){
          firstbyte += 1;
          weight -= java.lang.Math.pow(2,28);
      }
      else{
          firstbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,27)){
          firstbyte += 1;
          weight -= java.lang.Math.pow(2,27);
      }
      else{
          firstbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,26)){
          firstbyte += 1;
          weight -= java.lang.Math.pow(2,26);
      }
      else{
          firstbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,25)){
          firstbyte += 1;
          weight -= java.lang.Math.pow(2,25);
      }
      else{
          firstbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,24)){
          firstbyte += 1;
          weight -= java.lang.Math.pow(2,24);
      }
      else{
          firstbyte += 0;
      }
      return firstbyte;
  }

  public static String secondByte(){
      String secondbyte = "";
      if(weight >= java.lang.Math.pow(2,23)){
          secondbyte += 1;
          weight -= java.lang.Math.pow(2,23);
      }
      else{
          secondbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,22)){
          secondbyte += 1;
          weight -= java.lang.Math.pow(2,22);
      }
      else{
          secondbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,21)){
          secondbyte += 1;
          weight -= java.lang.Math.pow(2,21);
      }
      else{
          secondbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,20)){
          secondbyte += 1;
          weight -= java.lang.Math.pow(2,20);
      }
      else{
          secondbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,19)){
          secondbyte += 1;
          weight -= java.lang.Math.pow(2,19);
      }
      else{
          secondbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,18)){
          secondbyte += 1;
          weight -= java.lang.Math.pow(2,18);
      }
      else{
          secondbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,17)){
          secondbyte += 1;
          weight -= java.lang.Math.pow(2,17);
      }
      else{
          secondbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,16)){
          secondbyte += 1;
          weight -= java.lang.Math.pow(2,16);
      }
      else{
          secondbyte += 0;
      }
      return secondbyte;
  }

  public static String thirdByte(){
      String thirdbyte = "";
      if(weight >= java.lang.Math.pow(2,15)){
          thirdbyte += 1;
          weight -= java.lang.Math.pow(2,15);
      }
      else{
          thirdbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,14)){
          thirdbyte += 1;
          weight -= java.lang.Math.pow(2,14);
      }
      else{
          thirdbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,13)){
          thirdbyte += 1;
          weight -= java.lang.Math.pow(2,13);
      }
      else{
          thirdbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,12)){
          thirdbyte += 1;
          weight -= java.lang.Math.pow(2,12);
      }
      else{
          thirdbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,11)){
          thirdbyte += 1;
          weight -= java.lang.Math.pow(2,11);
      }
      else{
          thirdbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,10)){
          thirdbyte += 1;
          weight -= java.lang.Math.pow(2,10);
      }
      else{
          thirdbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,9)){
          thirdbyte += 1;
          weight -= java.lang.Math.pow(2,9);
      }
      else{
          thirdbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,8)){
          thirdbyte += 1;
          weight -= java.lang.Math.pow(2,8);
      }
      else{
          thirdbyte += 0;
      }
      return thirdbyte;
  }
  public static String fourthByte(){
      String fourthbyte = "";
      if(weight >= java.lang.Math.pow(2,7)){
          fourthbyte += 1;
          weight -= java.lang.Math.pow(2,7);
      }
      else{
          fourthbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,6)){
          fourthbyte += 1;
          weight -= java.lang.Math.pow(2,6);
      }
      else{
          fourthbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,5)){
          fourthbyte += 1;
          weight -= java.lang.Math.pow(2,5);
      }
      else{
          fourthbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,4)){
          fourthbyte += 1;
          weight -= java.lang.Math.pow(2,4);
      }
      else{
          fourthbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,3)){
          fourthbyte += 1;
          weight -= java.lang.Math.pow(2,3);
      }
      else{
          fourthbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,2)){
          fourthbyte += 1;
          weight -= java.lang.Math.pow(2,2);
      }
      else{
          fourthbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,1)){
          fourthbyte += 1;
          weight -= java.lang.Math.pow(2,1);
      }
      else{
          fourthbyte += 0;
      }
      if(weight >= java.lang.Math.pow(2,0)){
          fourthbyte += 1;
          weight -= java.lang.Math.pow(2,0);
      }
      else{
          fourthbyte += 0;
      }
      return fourthbyte;
  }
}