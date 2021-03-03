import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create a class for Huffman Tree
 */
public class HuffmanTree {
    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 61, 82, 55, 89};
        Node root = HuffmanTree.createHuffmanTree(arr);
        HuffmanTree.preOrder(root);

    }

    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        } else {
            System.out.println("this is a empty tree!");
        }
    }

    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for(int value: arr){
            nodes.add(new Node(value));
        }

        //sort nodes from small to large

        //System.out.println("Sorted nodes: " + nodes);

        while (nodes.size() > 1){
            Collections.sort(nodes);
            System.out.println("Sorted nodes: " + nodes);
            //start to generate the tree from list nodes(0)

            // get left child and right child
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //create new subtree
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            // remove setted nodes from original list
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }

        // root
        return nodes.get(0);



    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value  + '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}