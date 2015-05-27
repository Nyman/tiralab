package tiralabra;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jarkko Nyman
 */
public class TreeTest {

    private Node parent, left, right;
    private Tree tree;

    public TreeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Main.binaryStrings = new String[4];
        Main.binaryStrings[0] = "1";
        Main.binaryStrings[1] = "11";
        Main.binaryStrings[2] = "111";
        Main.binaryStrings[3] = "1111";
        Main.bitValue = new int[4];
        Main.bitValue[0] = 1;
        Main.bitValue[1] = 2;
        Main.bitValue[2] = 3;
        Main.bitValue[3] = 4;
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        parent = new Node(175);
        left = new Node(75, 1);
        right = new Node(100, 2);
        parent.setLeft(left);
        parent.setRight(right);
        tree = new Tree(parent);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of walkThruTree method, of class Tree.
     */
    @Test
    public void testWalkThruTree() {
        System.out.println("walkThruTree");
        Node node = parent;
        String binString = "";
        Tree instance = tree;
        instance.walkThruTree(node, binString);
    }

}