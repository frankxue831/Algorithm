import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode Problem 46
 */
public class Permutation {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,4,50,6,7,8};
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res = permute(nums);
        System.out.println(res.toString());

    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for(int num: nums){
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first){
        if(first == n){
            res.add(new ArrayList<Integer>(output));
        }
        for(int i = first; i < n ; i++){
            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, first, i);

        }
    }
}
