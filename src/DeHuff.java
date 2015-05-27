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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DeHuff contains the needed tools to decompress a previously compressed .hff
 * file.
 */

public class DeHuff {
    
    private int read, lastbyte, temp = 0;
    private int[] buffer = new int[257];
    private boolean cont = true;
    private static Tree tree;
    private static Node node;
    private static BufferedOutputStream bout;

    public static void createBufferedOutputStream(String name) throws FileNotFoundException{
        bout = new BufferedOutputStream(new FileOutputStream(name));
    }

    public static void setTree(Tree treep){
        tree = treep;
        node = tree.getTreeNode();
    }

    /**
     * Reads bytes of data from the file in decompression and passes them to be
     * processed through the decoding steps.
     * @param bin
     * @throws IOException
     */

    public void dataDeHuffer(BufferedInputStream bin) throws IOException{
        int i = 0;
        temp = bin.read();
        while(cont){
            buffer[0] = temp;
            for(i = 1; i < 257 ; i++){
                if((read = bin.read()) != -1){
                    buffer[i] = read;
                    lastbyte = i;
                }
            }
            if(lastbyte == 256){
                temp = buffer[256];
                fromTreeBuider(buffer);
            }
            else{
                cont = false;
                fromTreeBuider(buffer);
            }
        }
    }

    /**
     * Converts a read byte to boolean[8] array and then uses it to decode the
     * information.
     * @param bytes
     * @throws IOException
     */

    public  void fromTreeBuider(int[] bytes) throws IOException{
        if(cont == true){
            for(int i = 0; i < 256 ; i++){
                boolean[] path = byteToBits(bytes[i]);
                treeDecoder(path, bout);
            }
        }
        else{
            for(int i = 0; i < lastbyte-1 ; i++){
                boolean[] path = byteToBits(bytes[i]);
                treeDecoder(path, bout);
            }
            boolean[] lastpath = byteToBits(bytes[lastbyte-1]);
            boolean[] truelast = new boolean[ 8- (bytes[lastbyte]) ];
            for(int i = 0; i < truelast.length ; i++ ){
                truelast[i] = lastpath[i];
            }
            treeDecoder(truelast, bout);
            bout.flush();
            bout.close();
        }
    }
    
    /**  
     * @author Esa Junttila
     * source: http://www.cs.helsinki.fi/u/ejunttil/opetus/tiraharjoitus/bittiohje.txt
     * Converts 8 last bits of and integer to boolean[8] array
     * @param data, integer ment to be in range of [0, 255]
     * @return returns the boolean array
    */
    /**
	 * Palauttaa parametrina saadun luvun 8 vähiten merkitsevää
	 * bittiä taulukossa (luvut [0, 255]).
	 *
	 * @param data muunnettava tavu, lukuarvo väliltä [0, 255]
	 * @return parametrin 8 vähiten merkitsevää bittiä taulukossa,
	 *         vähiten merkitsevä bitti on viimeisessä indeksissä.
	 */


    public static boolean[] byteToBits(int data) {

        if (data < 0 || 255 < data) {
                throw new IllegalArgumentException("" + data);
        }
        boolean[] bits = new boolean[8];
        for (int i=0; i < 8; i++) {
                bits[i] = ( (data & (1 << (7-i)) ) != 0 );
        }
        return bits;
    }

    /**
     * Moves through the reconstructed Tree accordingly bits read from the input
     * and writes a byte when hits a leafnode. Keeps track of which Node has been
     * under the processing and can continue from it with a new set of boolean[8]
     * arrays to come.
     * @param data
     * @param bout
     * @throws IOException
     */

    public void treeDecoder(boolean[] data, BufferedOutputStream bout) throws IOException{
        for(int i = 0; i < data.length ; i++){
            if(data[i] == false){
                node = node.getLeft();
            }
            else{
                node = node.getRight();
            }
            if(node.getLeft() == null && node.getRight() == null){
                bout.write(node.getOrigValue());
                node = tree.getTreeNode();
            }
        }
    }
}