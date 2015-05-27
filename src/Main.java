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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Main invokes the text based user interface Interface and accordingly
 * does the tricks needed either to compress or decompress the file given by
 * the user.
 */

public class Main {

    public static int[] result;
    public static String[] binaryStrings;
    public static int[] bitValue;

    public static void main(String[] args) throws IOException {

        int choice = Interface.operate();

        if(choice == 1){
            ReadingFromFile.readZeFile(Interface.filename);

            Heap h = new Heap(ReadingFromFile.byteAmmounts.length+1);

            for(int i = 0; i < ReadingFromFile.byteAmmounts.length; i++){
                Node node = new Node(ReadingFromFile.byteAmmounts[i], i);
                if(node.getNodeValue()!= 0){
                    h.insert(node);
                }
            }

            int times = 1;
            while(h.getPointer() > 1){
                times++;
                h.mergeNodes();
            }

            Tree tree = new Tree(h.getTreeNode());

            binaryStrings = new String[256];
            bitValue = new int[256];
            tree.walkThruTree(tree.getTreeNode(), "");

            Header.headerBuilder(ReadingFromFile.byteAmmounts);
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(Interface.filename + ".hff"));
            Header.headerWriter(bout);
            Huff.huffTheFile(ReadingFromFile.readFile(Interface.filename), bout, tree);
            bout.flush();
            bout.close();
        }

        else if(choice == 2){
            DeHuff open = new DeHuff();
            String openthis = Interface.filename;
            openthis = openthis.substring(0, openthis.length()-4);
            DeHuff.createBufferedOutputStream(openthis);
            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(Interface.filename));
            Header.headerReader(bin);
            open.dataDeHuffer(bin);
        }
        else{
            System.out.println("Choose from 1 or 2. Can't be that hard. Try again");
            System.exit(0);
        }
    }
}



