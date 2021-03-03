package com.huffmancoding;

import java.util.*;

public class HuffmanCode {
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
        huffmanTreeRoot.preOrder();
    }

    /**
     *
     * @param bytes the bytes from the string
     * @return The list of nodes for counting each character repeated times
     */
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<Node>();

        Map<Byte, Integer> counts = new HashMap<>();
        for(byte b : bytes) {
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b, 1);

            } else {
                counts.put(b, count + 1);
            }
        }

        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;

    }

    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
            //System.out.println("###");
        }

        //return the root of HuffmanTree
        return nodes.get(0);
    }

    private static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        } else{
            System.out.println("The tree is empty");
        }

    }
}

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
