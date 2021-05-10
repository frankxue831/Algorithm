public class BiggestSubArraySum {
    public static void main(String[] args){
        int[] nums = {1,2,4,5,-7,6,-4,-5,-1,10};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums){
        int pre = 0;
        int max = nums[0];
        for(int x : nums) {
            pre = Math.max(pre+x, x);
            max = Math.max(max, pre);
        }
        return max;
    }

}
