import java.util.Arrays;

public class MergeOrderedArray {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,10,0,0,0,0,0,0,0,0};
        int[] b = {2,6,7,9};
        //mergeSolution1(a,8, b, 4);
        mergeSolution2(a,8, b, 4);
        System.out.println(Arrays.toString(a));

    }

    public static void mergeSolution2(int[] nums1, int m, int[] nums2, int n){
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n){
            if(p1 == m){
                cur = nums2[p2++];
            }else if (p2 == n){
                cur = nums1[p1++];
            }else if(nums1[p1] < nums2[p2]){
                cur = nums1[p1++];
            }else{
                cur = nums2[p2++];
            }
            sorted[p1+p2-1] = cur;
        }for(int i = 0; i != m+n; ++i){
            nums1[i] = sorted[i];
        }
    }

    public static void mergeSolution1(int[] num1,int m, int[] num2, int n){
        //int m = num1.length;
        //int n = num2.length;
        int[] nums = new int[m + n];
        for(int i = 0; i != n; ++i){
            num1[m+i] = num2[i];
        }
        Arrays.sort(num1);
    }
}
