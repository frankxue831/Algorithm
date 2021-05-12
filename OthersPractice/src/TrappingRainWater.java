/**
 * LeetCode Problem 42
 */
public class TrappingRainWater {
    public static void main(String[] args){
        int[] height = {4,2,0,3,2,5};
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = trap1(height1);
        System.out.println(ans);

    }

    public static int trap1(int[] height){
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
            } else{
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

}
