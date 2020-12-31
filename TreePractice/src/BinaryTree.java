
public class BinaryTree {
    public TreeNode root;

    public BinaryTree(TreeNode root){
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("Empty Tree, Can not go through");
        }
    }

    public void delNode(int val){
        if(root != null){
            if(root.getVal() == val){
                root = null;
            } else{
                root.delNode(val);
            }
        } else{
            System.out.println("Empty Tree, can not delete!");
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                "node=" + getRoot().val +
                '}';
    }

    public static void  main(String[] args){
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(8);
        a1.setLeft(a2);a1.setRight(a3);
        a2.setLeft(a4);a2.setRight(a5);
        a3.setLeft(a6);a3.setRight(a7);
        BinaryTree tree1 = new BinaryTree(a1);
        tree1.delNode(3);
        tree1.preOrder();


    }
}
