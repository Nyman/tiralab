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
 * Huff is resposible of the tools and operations needed for the selected file to
 * be compressed.
 *
 */
public class Huff{

    private static boolean[] bits = new boolean[8];
    private static int charcounter = 0;

    /**
     * Reads the original byte from file and then "walking" through the Tree
     * determents the new correct binary representation according to the Huffman
     * coding.
     * @param bin Inputstream from file to be huffed
     * @param bout Outputstream that will be the 'filename'.hff when done
     * @param tree Tree build from the inputstream
     * @throws IOException
     */
    public static void huffTheFile(BufferedInputStream bin, BufferedOutputStream bout, Tree tree) throws IOException{
        if( bin != null){
        }
        int value;

        while ((value = bin.read()) != -1){
            binStringToBooleanChar(Main.binaryStrings[value], bout);
        }
        flushBitsToFile(bout);
        int overlap;
        if(charcounter > 0){

            overlap = 8-charcounter;
            bout.write(overlap);
        }
        else{
            bout.write(0);
        }
    }


    public static void writeByter(int data, BufferedOutputStream bout) throws IOException{
        bout.write(data);
    }


    /**
     * @author Esa Junttila
     * source: http://www.cs.helsinki.fi/u/ejunttil/opetus/tiraharjoitus/bittiohje.txt
     * Converts the boolean array to an integer representation in value range [0, 255]
     * @param boolean[8] array
     * @return the integer representation built from the boolean[8] array
     * source: http://www.cs.helsinki.fi/u/ejunttil/opetus/tiraharjoitus/bittiohje.txt
     *
     */

    /**
	 * Muuttaa parametrina saadun bittitaulukon bitit
	 * vastaavaksi kokonaisluvuksi väliltä [0, 255].
	 *
	 * @param 8-paikkainen bittitaulukko, vähiten merkitsevä bitti
	 *        viimeisessä indeksissä.
	 * @return bittien kokonaislukuesitys väliltä [0, 255]
	 */

    public static int bitsToByte(boolean[] bits) {
		if (bits == null || bits.length != 8) {
			throw new IllegalArgumentException();
		}
		int data = 0;
		for (int i = 0; i < 8; i++) {
			if (bits[i]) data += (1 << (7-i));
		}
                return data;
	}

    /**
     * Converts a String consisting of 1's and 0's to boolean array. When and 8
     * bit boolean array is full, calls a function to write them to outputstream
     * as one byte valued between [0, 255]
     * @param binarystring
     * @param bout
     * @throws IOException
     */
    public static void binStringToBooleanChar(String binarystring, BufferedOutputStream bout) throws IOException{
        for(int i = 0; i<binarystring.length(); i++){
            
            if(binarystring.charAt(i) == '1'){
                bits[charcounter] = true;
            }
            else{
                bits[charcounter] = false;
            }
            charcounter++;
            if(charcounter == 8){
                charcounter = 0;
                writeByter(bitsToByte(bits), bout);

            }
        }
    }

    /**
     * If the last byte doesn't fill, flushing it fills the empty bits with 0's
     * and orders the flushed byte to be written in the outputstream
     * @param bout
     * @throws IOException
     */
    public static void flushBitsToFile(BufferedOutputStream bout) throws IOException{
        if(charcounter != 0){
            for(int i = charcounter; i < 8; i++){
                    bits[i] = false;
            }
            writeByter(bitsToByte(bits), bout);
        }
    }
}