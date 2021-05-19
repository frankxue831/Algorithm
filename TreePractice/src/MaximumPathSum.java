/**
 * LeetCode 124
 */
public class MaximumPathSum {
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args){
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
        int res = maxPathSum(a1);
        System.out.println(res);

        }

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static int maxGain(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int priceNewpath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewpath);
        return node.val + Math.max(leftGain, rightGain);
    }
}
