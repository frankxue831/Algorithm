

public class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    /**
     * preorder is go through tree by following order
     * parent
     * left child
     * right child
     */
    public void preOrder(){
        System.out.println(this);

        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * infix order is go through tree by following order
     * left child
     * parent
     * right child
     */
    public void infixOrder(){

        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }

    /**
     * postorder is go through tree by following order
     * left child
     * right child
     * parent
     */
    public void postOrder(){

        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public void delNode(int val){

        if(this.left != null && this.left.val == val){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.val == val){
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

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        a1.setLeft(a2);a1.setRight(a3);
        a2.setLeft(a4);a2.setRight(a5);
        a3.setLeft(a6);a3.setRight(a7);
        a1.preOrder();
        System.out.println("******");
        a1.postOrder();
        System.out.println("******");
        a1.infixOrder();
        System.out.println("******");
        a1.delNode(4);
        a1.preOrder();
    }
}

