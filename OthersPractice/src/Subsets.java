import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(listSubsets(nums).toString());
    }

    public static List<List<Integer>> listSubsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        int n = nums.length;
        for(int mask = 0; mask < (1 <<n); mask++){
            cur.clear();
            for(int i = 0; i<n; i++){
                if((mask & (i << i)) != 0){
                    cur.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(cur));
        }
        return ans;
    }


}
