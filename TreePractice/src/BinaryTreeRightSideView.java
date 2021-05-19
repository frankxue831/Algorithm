import java.util.*;

/**
 * LeetCode Problem 199
 */
public class BinaryTreeRightSideView {
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
        List<Integer> res = rightSideView(a1);
        System.out.println(res.toString());



    }

    public static List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightMostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if(node != null) {
                max_depth = Math.max(max_depth, depth);
                if(!rightMostValueAtDepth.containsKey(depth)) {
                    rightMostValueAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for(int depth = 0; depth <= max_depth; depth++){
            rightView.add(rightMostValueAtDepth.get(depth));
        }
        return rightView;
    }

}
