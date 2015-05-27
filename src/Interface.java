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

import java.io.IOException;
import java.util.Scanner;

/**
 * Plain old lil class for the text based user interface of the program.
 * Nothing interesting here =P
 *
 */

public class Interface{

    public static Scanner reader = new Scanner(System.in);
    public static String filename;

    public static int operate() throws IOException{
        System.out.println("---Compress a file or decompress a *.hff file");
        System.out.println("Compress a file : 1");
        System.out.println("Decompress a .hff file : 2");

        int choice = reader.nextInt();
        String carbage = reader.nextLine();
        System.out.println("The file is expected to be located in the project directory. Give the full name and type of the file e.g. 'test.txt' ");

        if(choice == 1){
            System.out.print("Give the name of the file you want compressed : ");
            filename = reader.nextLine();
            //file.toString();
            return 1;
            }


        else if(choice == 2){
            System.out.print("Give the name of the .hff file you want decompressed : ");
            filename = reader.nextLine();
            //file.toString();
            return 2;
        }
        return 0;






    }
}