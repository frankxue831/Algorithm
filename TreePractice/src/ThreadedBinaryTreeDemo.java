public class ThreadedBinaryTreeDemo {

    public static void main(String[] args){
        ThreadedHeroNode root = new ThreadedHeroNode(1, "Ana");
        ThreadedHeroNode node1 = new ThreadedHeroNode(3, "Ana3");
        ThreadedHeroNode node2 = new ThreadedHeroNode(6, "Ana6");
        ThreadedHeroNode node3 = new ThreadedHeroNode(8, "Ana8");
        ThreadedHeroNode node4 = new ThreadedHeroNode(10, "Ana10");
        ThreadedHeroNode node5 = new ThreadedHeroNode(14, "Ana14");
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        System.out.println("****\n" + node4.getLeft());

        ThreadedBinaryTree tree1 = new ThreadedBinaryTree(root);
        tree1.threadedNodes();
        System.out.println("****\n" + node4.getLeft().getNo());
    }
}

class ThreadedBinaryTree {
    private ThreadedHeroNode root;
    private ThreadedHeroNode pre = null;

    public ThreadedBinaryTree(ThreadedHeroNode root) {
        this.root = root;
    }

    public ThreadedHeroNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedHeroNode root) {
        this.root = root;
    }
    // @override threadedNodes()
    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void threadedNodes(ThreadedHeroNode node) {
        // can not threads node if it is null
        if (node == null) {
            return;
        }

        // first threaded left child
        threadedNodes(node.getLeft());
        // second threaded current node
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        // !!! set pre as current node to begin next loop
        pre = node;

        // third threaded right node
        threadedNodes(node.getRight());
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("Empty Tree, Can not go through");
        }
    }

    public void delNode(int val) {
        if (root != null) {
            if (root.getVal() == val) {
                root = null;
            } else {
                root.delNode(val);
            }
        } else {
            System.out.println("Empty Tree, can not delete!");
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                "node=" + getRoot().getNo() +
                '}';
    }
}

class ThreadedHeroNode{
    private int no;
    private String name;
    private ThreadedHeroNode left;
    private ThreadedHeroNode right;

    //if leftType == 0, pointer is to left child
    //if leftType == 1, pointer is to prefix node
    //if rightType == 0, pointer is to right child
    //if rightType == 1, pointer is to postfix node
    private int leftType;
    private int rightType;

    public ThreadedHeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }


    public int getLeftType(){
        return leftType;
    }

    public int getRightType(){
        return rightType;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public ThreadedHeroNode getLeft() {
        return left;
    }

    public ThreadedHeroNode getRight() {
        return right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(ThreadedHeroNode left) {
        this.left = left;
    }

    public void setRight(ThreadedHeroNode right) {
        this.right = right;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }


    public void preOrder() {
        System.out.println(this);

        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    public int getVal() {
        return no;
    }

    public void delNode(int val) {
        if(this.left != null && this.left.no == val){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == val){
            this.right = null;
            return;
        }
        if(this.left != null){
            this.left.delNode(val);
        }
        if(this.right != null){
            this.right.delNode(val);
        }
    }
}
