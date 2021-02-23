public class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //if leftType == 0, pointer is to left child
    //if leftType == 1, pointer is to prefix node
    //if rightType == 0, pointer is to right child
    //if rightType == 1, pointer is to postfix node
    private int leftType;
    private int rightType;


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

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
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
        if(this.left != null && this.left.getNo() == val){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.getNo() == val){
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
