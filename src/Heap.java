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
 * Heap is heap =P
 * The class gives tools for the program to create its own heap using Node-objects
 * In this case the heap is a binary Min-Heap
 *
 */

public class Heap {

    private int pointer = 0;
    private Node[] heap;
    private Node tempNode, tempNode2, comboNode;


    public Heap(int size){
        this.heap = new Node[size+1];
    }

    public Node getTreeNode(){
        return this.heap[1];
    }

    public void insert(Node node){
        pointer++;
        this.heap[pointer] = node;
        balanceOnAdding(pointer);
    }

    public void mergeNodes(){
        comboNode = new Node(0);
        this.delMin(comboNode);
        this.delMin(comboNode);
        comboNode.setNodeValue(comboNode.getLeft().getNodeValue());
        comboNode.setNodeValue(comboNode.getRight().getNodeValue());
        this.insert(comboNode);
        //printHeap();
        comboNode = null;
    }

    public void delMin(Node combo){
        if(combo.getLeft() == null){
            combo.setLeft(this.heap[1]);
        }
        else{
            combo.setRight(this.heap[1]);
        }
        this.heap[1] = this.heap[pointer];
        pointer--;
        heapify(1);
    }


    public void balanceOnAdding(int index){
        if(index > 1){
            if(this.heap[index].getNodeValue() < this.heap[index/2].getNodeValue() ){
                tempNode = this.heap[index/2];
                tempNode2 = new Node(0);
                this.heap[index/2] = this.heap[index];
                this.heap[index] = tempNode;
                this.heap[index].setLeft(tempNode2.getLeft());
                this.heap[index].setRight(tempNode2.getRight());
                balanceOnAdding(index/2);
            }
        }
    }

    public void heapify(int index){
        if((index*2)+1 <= pointer){
            if ((heap[index*2].getNodeValue()) < heap[index].getNodeValue() || (heap[(index*2)+1].getNodeValue()) < heap[index].getNodeValue()){
                int smaller;
                if(heap[index*2].getNodeValue() <= heap[(index*2)+1].getNodeValue()){
                    smaller = index*2;
                }
                else{
                    smaller = (index*2)+1;
                }

                tempNode = heap[index];
                tempNode2 = heap[smaller];
                heap[index] = heap[smaller];
                heap[smaller] = tempNode;
                tempNode2 = null;
                tempNode = null;
                if(smaller*2+1 <= pointer){
                    heapify(smaller);
                }
            }
        }
        else if(index*2 <= pointer){
            int smaller = (index*2);
            tempNode = heap[index];
            tempNode2 = heap[smaller];
            heap[index] = heap[smaller];
            heap[smaller] = tempNode;
            tempNode2 = null;
            tempNode = null;
            if(smaller*2+1 <= pointer){
                heapify(smaller);
            }
        }
    }

    public int getPointer(){
        return pointer;
    }

    public Node[] getHeap() {
        return heap;
    }


}
