package com.huffmancoding;

import java.util.*;

/**
 *
 */
public class HuffmanCode {

    // Using map to store the huffman code
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    // Using StringBuilder to save Huffman code representation
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args){
        String str = "I like like like java do you like a java";
        byte[] contentBytes = str.getBytes();
        System.out.println(Arrays.toString(contentBytes));
        System.out.println(contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes=" + nodes);

        System.out.println("Huffman Tree: \n");
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("PreOrder form:");
        HuffmanCode.preOrder(huffmanTreeRoot);

        getCodes(huffmanTreeRoot, "", sb);
        System.out.println("codes:"+ huffmanCodes);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        System.out.println("Bytes + Codes : " + huffmanCodes);

    }

    private static Map<Byte, String> getCodes(Node root){
        if(root == null){
            return null;
        }

        getCodes(root.left, "0", sb);
        getCodes(root.right, "1", sb);
        return huffmanCodes;

    }


    // generate the Huffman code by Huffman tree, every left path mark as 0, right as 1

    /**
     * get all leaf node of the passing node as Huffman code, and put them in huffmanCodes map;
     * @param node the passing node
     * @param code left node mark as 0, right node mark as 1
     * @param stringBuilder collect the path of node. Example:
     *                     [left, right, left]
     *                      ->[0,1,0]
     *                      ->010
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder){
        StringBuilder str = new StringBuilder(stringBuilder);
        // compose the code by path
        str.append(code);
        if(node != null){
            if(node.data == null){ //it is not a leaf node, continue
                // left traverse
                getCodes(node.left, "0", str);
                // right traverse
                getCodes(node.right, "1", str);
            } else{ // it reach the leaf nodes
                huffmanCodes.put(node.data, str.toString());
            }
        }

    }

    /**
     * create a list of nodes from the giving byte array
     * @param bytes the bytes from the string
     * @return The list of nodes for counting each character repeated times
     */
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<Node>();

        Map<Byte, Integer> counts = new HashMap<>();
        for(byte b : bytes) {
            counts.merge(b, 1, Integer::sum);
        }

        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;

    }

    /**
     * create the Huffman tree from the giving list of nodes
     * @param nodes the list of nodes which contain value and weights
     * @return root as Node, which is the root of Huffman tree
     */
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            // 1. sort the order of weights
            Collections.sort(nodes);
            // 2.get the least weight nodes as children
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //3. create the subtree for above two children nodes
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //4. remove the assigned nodes from list
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5. add the new subtree to the tree
            nodes.add(parent);
            //System.out.println("###");
        }

        //when left the last node, mark it as root of tree
        //return the root of HuffmanTree
        return nodes.get(0);
    }

    /**
     * Traverse the tree with preorder
     * @param root Node the root of the tree
     */
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        } else{
            System.out.println("The tree is empty");
        }

    }
}

/**
 * class for creating the node of the huffman tree
 */
class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
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
