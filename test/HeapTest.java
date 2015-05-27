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
public class HeapTest {

    private Node firstnode, secondnode, thirdnode, comb;
    private Heap heap;

    public HeapTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        firstnode = new Node(200, 97);
        secondnode = new Node(100, 10);
        thirdnode = new Node(150, 20);
        comb = new Node(1,1);
        heap = new Heap(257);
        heap.insert(firstnode);
        heap.insert(secondnode);
        heap.insert(thirdnode);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTreeNode method, of class Heap.
     */
    @Test
    public void testGetTreeNode() {
        System.out.println("getTreeNode");
        Heap instance = heap;
        Node expResult = secondnode;
        Node result = instance.getTreeNode();
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class Heap.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Node node = firstnode;
        Heap instance = heap;
        instance.insert(node);
    }

    /**
     * Test of mergeNodes method, of class Heap.
     */
    @Test
    public void testMergeNodes() {
        System.out.println("mergeNodes");
        Heap instance = heap;
        instance.mergeNodes();
    }

    /**
     * Test of delMin method, of class Heap.
     */
    @Test
    public void testDelMin() {
        System.out.println("delMin");
        Node combo = comb;
        Heap instance = heap;
        instance.delMin(combo);
    }

    /**
     * Test of balanceOnAdding method, of class Heap.
     */
    @Test
    public void testBalanceOnAdding() {
        System.out.println("balanceOnAdding");
        int index = 2;
        Heap instance = heap;
        instance.balanceOnAdding(index);
    }

    /**
     * Test of heapify method, of class Heap.
     */
    @Test
    public void testHeapify() {
        System.out.println("heapify");
        int index = 3;
        Heap instance = heap;
        instance.heapify(index);
    }

    /**
     * Test of getPointer method, of class Heap.
     */
    @Test
    public void testGetPointer() {
        System.out.println("getPointer");
        Heap instance = heap;
        int expResult = 3;
        int result = instance.getPointer();
        assertEquals(expResult, result);
    }

}