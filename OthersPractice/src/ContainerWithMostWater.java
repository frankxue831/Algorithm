/**
 * LeetCode Problem
 */
public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));


    }

    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right -1);
            ans = Math.max(ans, area);
            if(height[left] <= height[right]){
                ++left;
            }
            else {
                --right;
            }
        }
        return ans;
    }
}
