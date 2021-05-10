import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 1
 */
public class TwoSum {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9, 11, 15,10};
        System.out.println(Arrays.toString(twoSum(nums, 26)));

    }
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(table.containsKey(target - nums[i])){
                return new int[]{table.get(target - nums[i]), i};
            }
            table.put(nums[i],i);
        }
        return new int[0];

    }

    //brutal force solution
    public static int[] twoSum2(int[] nums, int target){
        int n = nums.length;
        for(int i = 0; i<n;++i){
            for(int j = i+1; j<n; ++j){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return  new int[0];
    }
}
