/**
 * Leetcode Problem 33
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args){

    }

    public static int search(int[] nums, int target){
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (1 + right) /2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && target < nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target < nums[mid]) {
                    left = mid + 1;
                }else {
                    right = mid + 1;
                }
            }
        }
        return -1;
    }

}
