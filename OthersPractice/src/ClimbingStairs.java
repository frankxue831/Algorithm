/**
 * LeetCode Problem 70
 */
public class ClimbingStairs {
    public static void main(String[] args){
        int ans = climbStairs1(5);
        int ans2 = climbStairs3(5);
        System.out.println(ans2);

    }

    public static int climbStairs3(int n){
        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5) /2, n+1) - Math.pow((1 - sqrt5) / 2, n+1);
        return (int)Math.round(fib/ sqrt5);
    }

    public static int climbStairs1(int n) {
        int p;
        int q = 0;
        int r = 1;
        for(int i =1; i<=n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;

    }

    public static int climbStairs2(int n){
        int[][] q = {{1,1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    private static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1,0}, {0,1}};
        while(n > 0){
            if((n & 1) == 1){
                ret = multiply(ret, a);
            }
            n >>=1;
            a =multiply(a,a);

        }
        return ret;
    }

    private static int[][] multiply(int[][] a, int[][] b){
        int[][]c = new int[2][2];
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
