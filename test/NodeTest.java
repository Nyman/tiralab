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
public class NodeTest {

    private Node testnode, parentnode, leftnode, rightnode;
    public NodeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        testnode = new Node(200, 97);
        leftnode = new Node(100, 10);
        rightnode = new Node(150, 20);
        parentnode = new Node(250);

        parentnode.setLeft(leftnode);
        parentnode.setRight(rightnode);

        testnode.setBinString("010101");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getOrigValue method, of class Node.
     */
    @Test
    public void testGetOrigValue() {
        System.out.println("getOrigValue");
        Node instance = testnode;
        int expResult = 97;
        int result = instance.getOrigValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrigValue method, of class Node.
     */
    @Test
    public void testSetOrigValue() {
        System.out.println("setOrigValue");
        int origValue = 9;
        Node instance = testnode;
        instance.setOrigValue(origValue);
    }

    /**
     * Test of setLeft method, of class Node.
     */
    @Test
    public void testSetLeft() {
        System.out.println("setLeft");
        Node node = leftnode;
        Node instance = parentnode;
        instance.setLeft(node);
    }

    /**
     * Test of setRight method, of class Node.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        Node node = rightnode;
        Node instance = parentnode;
        instance.setRight(node);
    }

    /**
     * Test of getLeft method, of class Node.
     */
    @Test
    public void testGetLeft() {
        System.out.println("getLeft");
        Node instance = parentnode;
        Node expResult = leftnode;
        Node result = instance.getLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRight method, of class Node.
     */
    @Test
    public void testGetRight() {
        System.out.println("getRight");
        Node instance = parentnode;
        Node expResult = rightnode;
        Node result = instance.getRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNodeValue method, of class Node.
     */
    @Test
    public void testSetNodeValue() {
        System.out.println("setNodeValue");
        int nodeValue = 1;
        Node instance = testnode;
        instance.setNodeValue(nodeValue);
    }

    /**
     * Test of getNodeValue method, of class Node.
     */
    @Test
    public void testGetNodeValue() {
        System.out.println("getNodeValue");
        Node instance = testnode;
        int expResult = 200;
        int result = instance.getNodeValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBinString method, of class Node.
     */
    @Test
    public void testGetBinString() {
        System.out.println("getBinString");
        Node instance = testnode;
        String expResult = "010101";
        String result = instance.getBinString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBinString method, of class Node.
     */
    @Test
    public void testSetBinString() {
        System.out.println("setBinString");
        String binString = "111111";
        Node instance = testnode;
        instance.setBinString(binString);
    }

}