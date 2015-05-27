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
 * Tree is the representation of the processed Min-Heap after combining all the
 * Nodes in it. So basicly its the last combination of Nodes that were in a Min-Heap
 * but were combined to one big Node that contains a path of references to every
 * other Node once in the heap.
 *
 */

public class Tree {

    private Node tree;
    int[] result = new int[256];
    int ammount = 0;

    public Tree(Node treeNode){
        this.tree = treeNode;
    }

    /**
     * Recursively goes through the built tree and assigns every node a string
     * representing the path to it in binary. Strores the representation and its
     * original value to a static array in Main class
     * @param node Node that is under inspection and processing
     * @param binString The bit representation thats been constructed so far
     */
    public void walkThruTree(Node node, String binString){
        String ownBinString = binString;
        node.setBinString(binString);
        if(node.getLeft() != null){
            ownBinString += "0";
            walkThruTree(node.getLeft(), ownBinString);
        }
        if(node.getRight() != null){
            walkThruTree(node.getRight(), binString += "1");
        }
        if(node.getLeft() == null && node.getLeft() == null){
            Main.binaryStrings[node.getOrigValue()] = ownBinString;
            Main.bitValue[node.getOrigValue()] = node.getOrigValue();
        }
    }

    public Node getTreeNode(){
        return tree;
    }
}