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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;

/**
 * Gives some tools to read a file to a BufferedOutputStream
 */

public class ReadingFromFile {

    static int[] byteAmmounts = new int[256];
    static int nodeCount = 0;
    public static BufferedInputStream is;

    public static BufferedInputStream readFile(String fileName){
        File theFile = new File(fileName);
        is = null;

        try{
            is = new BufferedInputStream(new FileInputStream(theFile));
        }
        catch(FileNotFoundException error){
            System.out.println("File could not be opened. Sorry. Start again & check your input. kthxbye.");
        }
        return is;
    }

    public static void readZeFile(String fileName) throws IOException{

        File theFile = new File(fileName);
        is = null;

        try{
            is = new BufferedInputStream(new FileInputStream(theFile));
        }
        catch(FileNotFoundException error){
            System.out.println("File could not be opened. Sorry. Start again & check your input. kthxbye.");
        }

        int value;

        while ((value = is.read()) != -1){
            nodeCount++;
            byteAmmounts[value] += 1;
            }

    }
}
